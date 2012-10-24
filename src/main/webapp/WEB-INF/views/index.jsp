<!doctype html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">

<link rel="stylesheet" type="text/css" href="./css/reset.css" />
<link rel="stylesheet" type="text/css" href="./css/showtimes.css" />

<script src="http://maps.google.com/maps/api/js?sensor=false"></script>
<script type="text/javascript" src="js/require/require.js"></script>
<script type="text/javascript" src="js/config.js"></script>

</head>

<body id="body"></body>

<script type="text/javascript">
	require([ 'util' ], function(util, knockout, ShowtimesViewModel) {

		var navigator = new util.Navigator();

		if (navigator.isSupported()) {
			navigator.getCity(function(local, city) {
				window.location = "./" + local.toLowerCase() + "#" + city;
			});
		} else {

		}

	});
</script>
</html>
