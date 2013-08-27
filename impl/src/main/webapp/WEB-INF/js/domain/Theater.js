define([ "Class", "./Movie" ], function(Class, Movie) {

	return Class.create({
		initialize : function(name, address, movies) {
			this.name = name;
			this.address = address;
			this.movies = movies;
		}
	});

});
