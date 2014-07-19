var phonecatApp = angular.module('phonecatApp', ['ngRoute', 'phonecatController']);

phonecatApp.config(['$routeProvider',
    function($routeProvider){
		$routeProvider
		.when('/phones', {
			templateUrl: 'views/phone-list.html',
			controller: 'PhoneListCtrl'
		})
		.when('/phones/:phoneId', {
			templateUrl: 'views/phone-detail.html',
			controller: 'PhoneDetailCtrl'
		})
		.when('/printtmp', {
			templateUrl: 'views/setprinttemplate.html',
			controller: 'SetPrintTempCtrl'
		})
		.otherwise({
			redirectTo: '/phones'
		});
    }
]);

phonecatApp.controller("AppCtrl", ['$scope', '$route', '$location', function($scope, $route, $location){
	$scope.$on("$routeChangeSuccess", function(){
		console.log('route change success...' + $route.current.templateUrl + ', ' + $location.path());
		
		$("a[href *= '"+$location.path()+"']").parent().addClass('active');
	});
	
}]);