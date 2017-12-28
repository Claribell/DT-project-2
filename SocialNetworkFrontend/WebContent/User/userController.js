app.controller("userController",function($scope,$http,$location,$rootScope,$cookieStore){
	$scope.user={userName:'',password:'',firstName:'',lastName:'',emailId:'',role:'',isOnline:''};
    $scope.allUsers;
    $scope.registerUser=function()
	{
		console.log('Entered into registerUser');
		$http.post("http://localhost:7072/SocialNetworkAppRest1/register",$scope.user)
		.then(function(response){
			 console.log("User Registered Successfully");
			   $location.path("/login");
		});
	};
	
	$rootScope.login=function()
	{
		console.log("log in");
		$http.post("http://localhost:7072/SocialNetworkAppRest1/login",$scope.user)
		.then(function(response){
		$scope.user=response.data;
		$rootScope.currentUser=response.data;
		$cookieStore.put("user",response.data);
		console.log($rootScope.currentUser.role);
		$location.path("/UserHome");
		});
		
	};
	
	function fetchAllUsers()
	{
		console.log('Fetching Users');
		$http.get("http://localhost:7072/SocialNetworkAppRest1/getAllusers")
		.then(function(response){
			 $scope.allUsers=response.data;	
		});
	};
	fetchAllUsers();
	
	$rootScope.logout=function()
	{
		console.log("logging out");
		delete $rootScope.currentUser;
		$cookieStore.remove("user");
		$location.path("/logout");
		
	}
	
	
});