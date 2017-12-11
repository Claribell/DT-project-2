var app = angular.module('myApp', ['ngRoute']);

//configure our routes
app.config(function($routeProvider, $locationProvider) {
  $locationProvider.hashPrefix('');
	$routeProvider

		// route for the home page
		.when('/', {
			templateUrl : 'index.html'
        })
        
		.when('/blog', {
			templateUrl : 'Blog/Blog.html',
			controller  : 'BlogController'
		})
		// route for the about page
		.when('/forum', {
			templateUrl : 'Forum/Forum.html',
			controller  : 'ForumController'
		})
	
	    .when('/adminBlog', {
		templateUrl : 'Blog/AdminBlog.html',
		controller  : 'AdminBlogController'
	})
	
	 .when('/register', {
			templateUrl : 'User/register.html',
			controller  : 'userController'
		})
		
	 .when('/login', {
				templateUrl : 'User/login.html',
				controller  : 'userController'
			})
	.when('/UserHome', {
			templateUrl : 'Blog/Blog.html'
        })
        	
	 .when('/friend', {
				templateUrl : 'Friend/Friend.html',
				controller  : 'friendController'
			})
	.when('/job', {
			   templateUrl : 'Job/Job.html',
			   controller  : 'JobController'
		   })
	.when('/showjob', {
		   templateUrl : 'Job/showjob.html',
		   controller  : 'JobController'
	   });
		
			
});