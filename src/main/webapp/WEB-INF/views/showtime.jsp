<!doctype html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">

<link rel="stylesheet" type="text/css" href="./css/reset.css" />
<link rel="stylesheet" type="text/css" href="./css/showtimes.css" />

<script type="text/javascript" src="js/require/require.js"></script>
<script type="text/javascript" src="js/config.js"></script>

</head>

<body id="body"></body>

<script type="text/javascript">
	require([ 'util', 'knockout', 'models/ShowtimesViewModel' ], function(util, knockout, ShowtimesViewModel) {

		var templateManager = new util.TemplateManager("body");
		var hashManager = new util.HashManager();
		var hash = hashManager.getHash();

		if (hash) {
			templateManager.loadTemplate('showtimes', function() {
				knockout.applyBindings(new ShowtimesViewModel(hashManager, "hu", hash));
			});
		} else {

		}

	});
</script>


</html>
