define([ './knockout-2.1.0' ], function(knockout) {
	
	var ENTER_KEY = 13;

	// a custom binding to handle the enter key (could go in a separate library)
	knockout.bindingHandlers.enterKey = {
		init : function(element, valueAccessor, allBindingsAccessor, data) {
			var wrappedHandler, newValueAccessor;

			// wrap the handler with a check for the enter key
			wrappedHandler = function(data, event) {
				if (event.keyCode === ENTER_KEY) {
					valueAccessor().call(this, data, event);
				}
			};

			// create a valueAccessor with the options that we would want to
			// pass to the event binding
			newValueAccessor = function() {
				return {
					keyup : wrappedHandler
				};
			};

			// call the real event binding's init function
			knockout.bindingHandlers.event.init(element, newValueAccessor, allBindingsAccessor, data);
		}
	};

	
	return knockout;
});