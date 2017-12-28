app.controller('ChatController', function($scope,$rootScope,chatService)
{
	$scope.messages=[];
	$scope.message="";
	$scope.max=140;
	
	$scope.addMessage=function()
	{
		console.log("Add message called");
		chatService.send($rootScope.currentUser.userName+":" +$scope.message);
		$scope.message="";
	};

   chatService.receive(function(message)
	{
		console.log("Receive message called");
		$scope.messages.push(message);
	});	

});
