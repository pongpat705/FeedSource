
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

	  $(document).ready(function() {
		  var table =  $('#news').DataTable( {
			  "aLengthMenu": [[20, 50, 75, -1], [20, 50, 75, "All"]],
			  "iDisplayLength": 20,
			  "processing": true,
			  "serverSide": true,
			  "ajax": {
				  "url": "http://localhost:2000/api/getTitleList",
				  "type": "GET"
			  },
			  "columns": [
				  { "data": "title" },
				  {"defaultContent": "<button class='btn btn-danger btn-xs'>X</button>"}
			  ]
		  } );

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

		location.reload();

    }






		  $('#news tbody').on( 'click', 'button', function () {
			  var data = table.row( $(this).parents('tr') ).data();
			  console.log( data.sourceId );
			  $http.post("http://localhost:2000/app/delete/" + data.sourceId).then(function (response) {
				  if(response.data.response == "OK"){
					  table.ajax.reload();
				  }else{
					  alert(response.data.response);
				  }
			  })
		  } );

	  } );



  }
]);