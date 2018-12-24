
'use strict';
angular
    .module('app')
        .controller('page2Ctrl', [  '$scope', '$http', 'services',
  function page2Ctrl($scope, $http, services) {
    
     $scope.test = "test2";
    $scope.$watch("init", function(){
        
        console.log('page2');
        
    });
    
    
    
 
  }
]);