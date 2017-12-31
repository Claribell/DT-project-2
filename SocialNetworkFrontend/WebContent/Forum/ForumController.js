app.controller('ForumController',function($scope,$http,$location)
		
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
	
	$scope.insertforum=function()
	{
		console.log('Entered into Insert Forum');
		$http.post('http://localhost:7072/SocialNetworkAppRest1/insertForum',$scope.forum)
		   .then(fetchAllForums(),function(response)
				   {
			   console.log("Forum entered Successfully");
			   $scope.refresh();
			   $location.path("/Forum");
				   });
	};
	
	$scope.deleteForum=function(forumId){
		console.log('Entered into Delete Forum');
		$http.get("http://localhost:7072/SocialNetworkAppRest1/deleteForum/"+forumId)
		.success(fetchAllForums(),function(response){
			console.log('Successful Deletion');	
			$scope.refresh();
			$location.path("/Forum")
			
		});
	};
	
	
	
	
	
	});