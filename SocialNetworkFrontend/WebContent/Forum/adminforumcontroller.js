app.controller('adminForumController',function($scope,$http,$location)
		
{
	$scope.forum={forumId:0,forumName:'',forumContent:'',creationDate:'',status:'',userName:''};
	$scope.forumdata;
	
	function fetchAllForums()
	{
	console.log('Fetching Forums');
	$http.get("http://localhost:7072/SocialNetworkAppRest1/getAllForums")
	     .then(function(response){
		$scope.forumdata=response.data;
	     });
		
	};
	fetchAllForums();
	
	$scope.rejectforum=function(forumId)
	{
		$http.get("http://localhost:7072/SocialNetworkAppRest1/rejectForum/"+forumId)
		.then(fetchAllForums(),function(response)
				{
			console.log("Forum Rejected");
				});
	};
	

	$scope.approveforum=function(forumId)
	{
		$http.get("http://localhost:7072/SocialNetworkAppRest1/approveForum/"+forumId)
		.then(fetchAllForums(),function(response)
				{
			console.log("Forum Approved");
				});
	};
});