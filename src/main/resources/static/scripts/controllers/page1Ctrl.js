
'use strict';
angular
    .module('app')
        .controller('page1Ctrl', [  '$scope', '$http', 'services',
  function page1Ctrl($scope, $http, services) {
    
     $scope.test = "test1";
    $scope.$watch("init", function(){
        
        console.log('page1');
        
    });
    
    
    
 
  }
]);