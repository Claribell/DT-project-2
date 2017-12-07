app.controller('BlogController',function($scope,$http,$location)
		
{
	$scope.blog={blogId:0,blogName:'',blogContent:'',creationDate:'',likes:' ',status:'',userName:''};
	$scope.blogdata;
	function fetchAllBlog()
	{
	console.log('Fetching Blogs');
	$http.get("http://localhost:7072/SocialNetworkAppRest1/getAllBlogs")
	     .then(function(response){
		$scope.blogdata=response.data;
	     });
		
	};
	fetchAllBlog();
	
	$scope.insertBlog=function()
	{
		console.log('Entered into Insert Blog');
		$http.post('http://localhost:7072/SocialNetworkAppRest1/insertBlog',$scope.blog)
		   .then(fetchAllBlog(),function(response)
				   {
			   console.log("Blog entered Successfully");
			   $location.path("/Blog");
				   });
	};
	
	$scope.deleteBlog=function(blogId){
		console.log('Entered into Delete Blog');
		$http.get("http://localhost:7072/SocialNetworkAppRest1/deleteBlog/"+blogId)
		.success(fetchAllBlog(),function(response){
			console.log('Successful Deletion');
			$scope.refresh();
			$location.path("/Blog")
			
		});
	};
	
	$scope.editBlog=function(blogId)
	{
		console.log('Entered to the edit Blog');
		console.log('Entered into Delete Blog');
		$http.get("http://localhost:7072/SocialNetworkAppRest1/editBlog"+blogId)
		.success(fetchAllBlog(),function(response){
			console.log('Editing');
			$scope.blog=response.data;
			console.log($scope.blog);
			$location.path("/Blog")
	});
	};
	
	$scope.incrementLike=function(blogId){
		console.log('Entered into Increment Like');
		$http.get("http://localhost:7072/SocialNetworkAppRest1/inclike/"+blogId)
		.success(fetchAllBlog(),function(response){
			console.log('Like Incremented');
			$scope.refresh();
			$location.path("/Blog")
			
		});
	};
			
	
	
	});