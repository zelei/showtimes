define(["Class"], function(Class) {
	
	
		var Navigator = Class.create({

			initialize : function() {
			},

			isSupported : function() {
				return navigator && navigator.geolocation;
			},
			
			getCoords : function(coordFunction) {
				navigator.geolocation.getCurrentPosition(function(position) {
					var lat = position.coords.latitude;
					var lng = position.coords.longitude;
					coordFunction(lat, lng);
				});
			},

			getCity : function(cityFunction) {

				var self = this;

				this.getCoords(function(lat, lng) {

					var geocoder = new google.maps.Geocoder();

					var params = {
						'latLng' : new google.maps.LatLng(lat, lng)
					};
					
					geocoder.geocode(params, function(results, status) {
						cityFunction(self.getCityShortName(results));
					});

				});

			},

			getCityShortName : function(results) {
				
				var shorName = undefined;
				results[0].address_components.each(function(address) {
					if (address.types.indexOf("locality") >= 0) {
						shorName = address.short_name;
						return
					}
				});

				return shorName;
			}
		});



	var HashManager = Class.create({

			initialize : function() {
				var self = this;
				window.onhashchange = function() {
					self.listener(self.getHash());
				};
			},

			setHashchangeListener : function(listener) {
				this.listener = listener;
			},

			setHash : function(hash) {
				window.location.hash = hash;
			},

			getHash : function() {
				return window.location.hash.substring(1);
			}

		});


	
	var	TemplateManager = Class.create({

			initialize : function(parentElementId) {
				this.parentElementId = parentElementId;
			},

			loadTemplate : function(templateName, loadCallbackFunction) {
				var self = this;
				requirejs(['require/text!../template/'+templateName+'.html'], function(tpl) {
					document.getElementById(self.parentElementId).innerHTML = tpl;
					loadCallbackFunction();
				});
			}

		});
	
	return {
		name : 'util',
		TemplateManager : TemplateManager,
		HashManager : HashManager,
		Navigator : Navigator
	};
});