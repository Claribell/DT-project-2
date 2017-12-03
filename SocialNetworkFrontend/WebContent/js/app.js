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
		});		
});

