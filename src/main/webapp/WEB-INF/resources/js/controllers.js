var phonecatController = angular.module("phonecatController", []);

phonecatController.controller('PhoneListCtrl', ['$scope', '$http', function($scope, $http){
	
	$http.get('../resources/phones.json').success(function(data){
		
		$scope.phones = data;
	});
	
	$scope.orderProp = 'age';
	
}]);

phonecatController.controller('PhoneDetailCtrl', ['$scope', '$routeParams', function($scope, $routeParams){
	
	$scope.phoneId = $routeParams.phoneId;
	
}]);

phonecatController.controller('SetPrintTempCtrl', ['$scope', '$http', function($scope, $http){
	$http.get('../print/listExpComp').success(function(data){
		$scope.expcomps = data;
	});
}]);