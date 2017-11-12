app.factory("userService",function($http){
    var BASE_URL="http://localhost:7071/SocialNetworkAppRest1";
	var userService ={};
	
	
	userService.getAllUser=function(){
		return $http.get(BASE_URL+"/user/getAllUsers");		
	}
	
	userService.createUser=function(user){
		console.log("****** inside user service--createUser()*****")
		return $http.post(BASE_URL+"/user/register",user);		
	}
	
	return userService;
});