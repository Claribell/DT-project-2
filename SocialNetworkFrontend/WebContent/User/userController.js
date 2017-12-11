app.controller("userController",function($scope,$http,$location){
	$scope.user={userName:'',password:'',firstName:'',lastName:'',emailId:'',role:''};
	
	$scope.registerUser=function()
	{
		console.log('Entered into registerUser');
		$http.post("http://localhost:7072/SocialNetworkAppRest1/register",$scope.user)
		.then(function(response){
			 console.log("User Registered Successfully");
			   $location.path("/User");
		});
	}
	
	$scope.login=function()
	{
		console.log("log in");
		$http.post("http://localhost:7072/SocialNetworkAppRest1/login",$scope.user)
		.then(function(response){
		$scope.user=response.data;
		$location.path("/UserHome");
		});
		
	}
	
	
});