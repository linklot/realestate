AdminControllers.controller('ColumnMgmtCtrl', ['$rootScope', '$scope', '$location', 'ColumnService',
  function ($rootScope, $scope, $location, ColumnService) {
    $rootScope.current = "column_management";
    
    ColumnService.getRootColumn().success(function(data) {
      $scope.rootColumn = data;
    });

    $scope.addSubColumn = function (parent_id) {
      $location.path(parent_id +'/addColumn');
    }

    $scope.deleteColumn = function (column_id, column_name) {
      ColumnService.deleteColumn(column_id).success(function (data) {
        ColumnService.getRootColumn().success(function(data) {
          $scope.rootColumn = data;
        });
      });
    }
  }
]);

AdminControllers.controller('ColumnAddCtrl', ['$rootScope', '$scope', '$location', '$routeParams', 'ColumnService',
  function ($rootScope, $scope, $location, $routeParams, ColumnService) {
    $rootScope.current = "column_management";

    ColumnService.getColumn($routeParams.parentId).success(function(data) {
        $scope.parentColumn = data;
    });

    $scope.addColumn = function () {
        var req_data = {
            'parentColumnId': $scope.parentColumn.id,
            'columnName': $scope.subColumnName
        };
        ColumnService.addSubColumn(req_data)
        .success(function (data) {
            $location.path("/column_list");
        });
    };
  }
]);