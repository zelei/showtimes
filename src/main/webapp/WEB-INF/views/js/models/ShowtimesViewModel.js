define([ 'Class', 'knockout', 'Ajax', 'domain' ], function(Class, ko, Ajax, domain) {

	return Class.create({

		initialize : function(hashManager, local, city) {

			var self = this;

			// setters
			this.city = city;
			this.local = local;
			this.hashManager = hashManager;

			// observables
			this.loaded = ko.observable(false);
			this.city = ko.observable();
			this.theaters = ko.observableArray([]);

			// subscribers
			this.city.subscribe(hashManager.setHash, this);

			this.theaters.subscribe(function(value) {
				self.loaded(value ? true : false);
			}, this);

			this.hashManager.setHashchangeListener(function(value) {
				self.load(value);
			});

			//
			if (city) {
				this.city(city);
				this.load(local, city);
			}

		},

		load : function(local, near) {
			var self = this;
			var url = './api';
			new Ajax.Request(url, {
				method : 'GET',
				parameters : {
					near : near,
					hl : local
				},
				evalJSON : true,
				onSuccess : function(transport) {
					try {
						self.theaters(self.processTheatersJSON(transport.responseJSON));
					} catch (e) {
						console.log(e);
					}
				}
			});
		},

		processTheatersJSON : function(theaters) {
			var self = this;
			return theaters.each(function(theaterJSON) {
				return new domain.Theater(theaterJSON.name, theaterJSON.address, self.processMoviesJSON(theaterJSON.movies));
			});
		},

		processMoviesJSON : function(movies) {
			return movies.each(function(movieJSON) {
				return new domain.Movie(movieJSON.name, movieJSON.info, movieJSON.rating, movieJSON.times);
			});
		}

	});

});
