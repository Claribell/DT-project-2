myApp.controller('BlogController',function($scope,$http)
		
{
	console.log("Http Service called");
	$http.get("http://localhost:7071/SocialNetworkAppRest1/getAllBlogs")
	     .then(function(response){
		$scope.blogdata=response.data;
		console.log("Data stored in scope object");
		
	});
	
	
	
	});