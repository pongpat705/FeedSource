
'use strict';
angular
    .module('app')
        .controller('page2Ctrl', [  '$scope', '$http', 'services',
  function page2Ctrl($scope, $http, services) {

    $scope.$watch("init", function(){
        
        console.log('page2');


        $(document).ready(function() {
           var table =  $('#news').DataTable( {
                "aLengthMenu": [[20, 50, 75, -1], [20, 50, 75, "All"]],
                "iDisplayLength": 20,
                "processing": true,
                "serverSide": true,
                "ajax": {
                    "url": "http://localhost:8080/api/getTitleList",
                    "type": "GET"
                },
                "columns": [
                     { "data": "title" },
                    { "data": "url" },
                    {"defaultContent": "<button class='btn btn-danger btn-xs'>X</button>"}
                ]
            } );

            $('#news tbody').on( 'click', 'button', function () {
                var data = table.row( $(this).parents('tr') ).data();
                console.log( data.sourceId );
            } );

        } );

        
    });
    
    
    
 
  }
]);