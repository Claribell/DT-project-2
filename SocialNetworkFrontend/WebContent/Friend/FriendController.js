app.controller('FriendController',function($scope,$http,$location)
{
$scope.friend={friendId:0,userName:'',friendName:'',status:''};

$scope.allFriendRequest;

function fetchAllFriendRequests()
{
$http.get("http://localhost:7072/SocialNetworkAppRest1/getAllFriendRequest")
    .then(function(response)
	{
	$scope.allFriendRequest=response.data;
	console.log($scope.allFriendRequest);
	});
	}
	fetchAllFriendRequests();
	
	$scope.reject=function(friendId)
	{
		$http.get("http://localhost:7072/SocialNetworkAppRest1/RejectFriendRequest/"+friendId)
		.success(function(response)
				{
			console.log("Friend request Rejected");
				});
	};
	
	$scope.approve=function(friendId)
	{
		$http.get("http://localhost:7072/SocialNetworkAppRest1/approvalFriendRequest/"+friendId)
		.success(function(response)
				{
			console.log("Friend request accepted");
				});
	};
	
	
	
	});
	
 