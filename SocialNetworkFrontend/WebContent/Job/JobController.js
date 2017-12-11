app.controller('JobController',function($scope,$http,$location)
		{
	 $scope.job={jobId:'0',jobProfile:'',jobDescription:'',postDate:''};
	 $scope.listJobs;
	 
	 $scope.applyjob=function()
		{
			console.log('Entered into apply job');
			$http.post("http://localhost:7072/SocialNetworkAppRest1/addJob",$scope.job)
			   .then(function(response)
					   {
				   console.log("Job added Successfully");
					   });
		};
		$scope.deletejob=function(jobId)
		{
		console.log('Deleting job');
			$http.get("http://localhost:7072/SocialNetworkAppRest1/deletejob/"+ jobId)
			.then(function(response)
			{
			console.log('Job Deleted');
			});
		}
		
		function fetchAllJobs()
		{
		$http.get("http://localhost:7072/SocialNetworkAppRest1/showAlljobs")
			.then(function(response)
			{
			$scope.listJobs=response.data;
			console.log('Job Deleted');
			});
			};
			fetchAllJobs();
			
		
	 
	 
		});
		