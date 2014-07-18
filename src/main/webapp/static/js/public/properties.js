var propertyApp = angular.module('propertyApp', []);

propertyApp.controller('PropertyCtrl', ['$scope', 'PropertyService',
  function ($scope, PropertyService) {
    var req_data = {startIndex: 0, pageSize: 20};
    PropertyService.getProperties(req_data)
    .success(function (data) {
      $scope.page = data;
    });

    $scope.navi = function(startIndex, pageSize) {
      var req_data = {'startIndex': startIndex, 'pageSize': pageSize};
      PropertyService.getProperties(req_data)
      .success(function (data) {
        $scope.page = data;
      });
    };
  }
]);

propertyApp.factory('PropertyService', function ($http) {
  return {
    getProperties: function (req_data) {
      return $http.post('/paginatedProperties', req_data);
    }
  }
});