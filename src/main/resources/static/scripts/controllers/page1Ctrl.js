
'use strict';
angular
    .module('app')
        .controller('page1Ctrl', [  '$scope', '$http', 'services',
  function page1Ctrl($scope, $http, services) {
    
     $scope.test = "test1";
     $scope.title = {};
    $scope.$watch("init", function(){
        
        console.log('page1');
        
    });
    $scope.save = function(){
    	$http.post("http://localhost:2000/app/insert/title",$scope.title).then(function(response){
    		console.log(response);
    		if(response.data.response=="ERROR"){
    			alert(response.data.data);
    		}	
    		console.log(response.data.response=="ERROR");
    	}).catch(function(response){
    		console.log(response);
    	});
    	console.log($scope.title);
    }
  }
]);