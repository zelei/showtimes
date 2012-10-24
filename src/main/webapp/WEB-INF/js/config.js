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

