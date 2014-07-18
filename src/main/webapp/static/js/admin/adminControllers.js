var AdminControllers = angular.module('adminControllers', []);

AdminControllers.controller('IndexCtrl', ['$rootScope', '$scope', '$location',
  function ($rootScope, $scope, $location) {
    $rootScope.current = "index";
  }
]);