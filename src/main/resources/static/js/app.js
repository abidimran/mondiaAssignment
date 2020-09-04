

var usrApp = angular.module('usrApp', ['ngRoute']);

usrApp.config(['$routeProvider',function($routeProvider){
	$routeProvider
	.when('/userscheck', { controller: 'usersCtrl', templateUrl: 'index.html'})
	.when('/', { controller: 'usrCtrl', templateUrl: 'index.html'})
	.when('/items', { controller: 'usrCtrl', templateUrl: 'index.html'})
	.when('/twitter', { controller: 'ttrCtrl', templateUrl: 'pages/twitter.html'})
	.otherwise( { redirectTo: '/' } );
}]);

usrApp.controller('usrCtrl', function($scope,$http,$window) {
	
	 $http.defaults.headers.post["Content-Type"] = "application/json";
	console.log("this msg============>");
	$scope.userdetails=function(){		
		
		$http.get('/users').success(function(data){
			console.log("this data users====>"+data);
			$scope.usrId=data;
			$scope.dataLoading = false;
		})
		.error(function (data) {
			$scope.usr="An error occurred during the AJAX request";
		});
		
	
	}
	
	$scope.idp= "";
	$scope.storeid = function(id){
		$scope.idp= id;
	}
	
	$scope.updateuser= function(){
		var fname = document.getElementById("fname").value;
		var lname = document.getElementById("lname").value;
		
		console.log("Adding this item"+fname+lname);
		
		$http.get('UPDT', {params:{"fname": fname, "lname": lname,"id":$scope.idp}}).success(function(data){
			console.log("this data====>"+data);
			$scope.usrId=data;
			$scope.dataLoading = false;
		})
		.error(function (data) {
			$scope.usr="An error occurred during the AJAX request";
		});
	}
	
	$scope.saveuserdetails= function(){
		var fname = document.getElementById("fname").value;
		var lname = document.getElementById("lname").value;
		var id = document.getElementById("id").value;
		var email = document.getElementById("email").value;
		
		console.log("Adding this item"+fname+lname+id+email);
		
		$http.get('SAVE', {params:{"fname": fname, "lname": lname,"id":id, "email":email}}).success(function(data){
			console.log("this data====>"+data);
			$scope.usrId=data;
			$scope.dataLoading = false;
		})
		.error(function (data) {
			$scope.usr="An error occurred during the AJAX request";
		});
	}
	
	
	
	
	$http.get('/items').success(function(data){
		console.log("this data hshd====>"+JSON.stringify(data));
		$scope.usrId=data;
		$scope.dataLoading = false;
	})
	.error(function (data) {
		$scope.usr="An error occurred during the AJAX request";
	});
	
	
	
	
})



//users controller
usrApp.controller('usersCtrl', function($scope,$http,$window) {
	console.log("this msg users============>");
	 $http.defaults.headers.post["Content-Type"] = "application/json";
	
		
		
		$http.get('/userscheck').success(function(data){
			console.log("this data====>"+data);
			$scope.usrId=data;
			$scope.dataLoading = false;
		})
		.error(function (data) {
			$scope.usr="An error occurred during the AJAX request";
		});
		
	
	
})