app.controller('AdminBlogController',function($scope,$http,$location)
		
{
	$scope.blog={blogId:0,blogName:'',blogContent:'',creationDate:'',likes:'',status:'',userName:''};
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
	
	$scope.rejectBlog=function(blogId)
	{
		$http.get("http://localhost:7072/SocialNetworkAppRest1/rejectBlog/"+blogId)
		.then(fetchAllBlog(),function(response)
				{
			console.log("Blog Rejected");
				});
	};
	

	$scope.approveBlog=function(blogId)
	{
		$http.get("http://localhost:7072/SocialNetworkAppRest1/approveBlog/"+blogId)
		.then(fetchAllBlog(),function(response)
				{
			console.log("Blog Approved");
				});
	};
});