define([ "Class" ], function(Class) {

	return Class.create({
		initialize : function(name, info, rating, times) {
			this.name = name;
			this.info = info;
			this.rating = rating;
			this.times = times;
		}
	});

});
