package hu.debrecen.adastra.card.service.impl;

import hu.debrecen.adastra.card.service.ShowtimeService;
import hu.debrecen.adastra.card.service.model.Movie;
import hu.debrecen.adastra.card.service.model.Theater;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.CharMatcher;
import com.google.common.base.Function;
import com.google.common.collect.Collections2;

public class GoogleShowtimeService implements ShowtimeService {

	private static final String SPACE = " ";

	private static final Logger LOGGER = LoggerFactory.getLogger(GoogleShowtimeService.class);

	public GoogleShowtimeService() {
		super();
	}

	@Override
	public Collection<Theater> getShowtimes(String city, int date) throws Exception {

		String url = String.format("http://www.google.com/movies?near=%s&hl=hu&date=%d", city, date);

		Document doc = Jsoup.connect(url).get();
		doc.outputSettings().charset("UTF-8");

		return Collections2.transform(doc.getElementsByClass("theater"), new Function<Element, Theater>() {
			@Override
			public Theater apply(Element theaterElement) {
				return GoogleShowtimeService.this.processTheaterElement(theaterElement);
			}
		});

	}

	private Theater processTheaterElement(Element element) {

		Elements nameElement = element.select(".theater>.desc>.name>a");
		Elements infoElement = element.select(".theater>.desc>.info");

		Elements moviesElement = element.select(".theater>.showtimes>*>.movie");

		return new Theater(nameElement.text(), infoElement.text(), this.processMoviesElement(moviesElement));
	}

	private Collection<Movie> processMoviesElement(Elements moviesElement) {

		return Collections2.transform(moviesElement, new Function<Element, Movie>() {

			@Override
			public Movie apply(Element movieElement) {
				String name = GoogleShowtimeService.removeSpecialChars(movieElement.select(".name").text());
				String info = GoogleShowtimeService.removeSpecialChars(movieElement.select(".info").text());

				String ratingText = movieElement.select(".info>nobr>img[alt]").attr("alt");

				if (StringUtils.isNotEmpty(ratingText)) {
					info += GoogleShowtimeService.SPACE + ratingText;
				}

				List<String> times = GoogleShowtimeService.processTimesElement(movieElement.select(".times>span"));

				return new Movie(name, info, times);
			}

		});

	}

	private static List<String> processTimesElement(Elements timesElement) {

		return new LinkedList<String>(Collections2.transform(timesElement, new Function<Element, String>() {

			@Override
			public String apply(Element timeElement) {
				// Times should be date, there is a possibly solution for
				// formatting
				// http://magicmonster.com/kb/prg/java/spring/webmvc/jackson_custom.html
				return GoogleShowtimeService.removeSpecialChars(timeElement.text());

			}

		}));

	}

	private static String removeSpecialChars(String text) {
		return CharMatcher.INVISIBLE.and(CharMatcher.isNot(' ')).removeFrom(text);
	}

}
