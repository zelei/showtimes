require.config({
	baseUrl : 'js',
	packages : [ 'util', 'domain', 'knockout' ],
	paths : {
		'prototype' : 'http://ajax.googleapis.com/ajax/libs/prototype/1.7.0.0/prototype'
	}
});

require.onError = function(err) {
	console.log(err.requireType);
	if (err.requireType === 'timeout') {
		console.log('modules: ' + err.requireModules);
	}

	throw err;
};

define('Class', [ "prototype" ], function() {
	return Class;
});

define('Ajax', [ "prototype" ], function() {
	return Ajax;
});

require([ 'util', 'knockout', 'ShowtimesViewModel' ], function(util, knockout, ShowtimesViewModel) {

	var navigator = new util.Navigator();
	var templateManager = new util.TemplateManager("body");
	var hashManager = new util.HashManager();
	var hash = hashManager.getHash();

	if (hash) {
		templateManager.loadTemplate('showtimes', function() {
			knockout.applyBindings(new ShowtimesViewModel(hashManager, hash));
		});
	} else if (navigator.isSupported()) {

		templateManager.loadTemplate('showtimes', function() {
			var model = new ShowtimesViewModel(hashManager);
			knockout.applyBindings(model);

			navigator.getCity(function(city) {
				model.city(city);
			});
		});

	} else {

	}

});