app.controller("userController",function($scope,$http,$location){
	$scope.user={userId:0,userName:'',password:'',firstName:'',lastName:'',emailId:''};
	$scope.registerUser=function()
	{
		console.log('Entered into registerUser');
		$http.post("http://localhost:7072/SocialNetworkAppRest1/register",$scope.user)
		.then(function(response){
			 console.log("User Registered Successfully");
			   $location.path("/User");
		});
	};
	
	
});