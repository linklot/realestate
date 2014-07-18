AdminControllers.controller('ReportRequestCtrl', ['$rootScope', '$scope', '$modal', 'ReportRequestService',
  function ($rootScope, $scope, $modal, ReportRequestService) {
    $rootScope.current = "report_request";

    ReportRequestService.getRequestList().success(function (data) {
      $scope.items = data;
    });

    $scope.pop = function(need) {
      var modalInstance = $modal.open({
        templateUrl: 'myModalContent.html',
        controller: ModalInstanceCtrl,
        backdrop: false,
        resolve: {
          message: function () {
            return need;
          }
        }
      });
    };

    var ModalInstanceCtrl = function ($scope, $modalInstance, message) {

      $scope.msg = message;

      $scope.cancel = function () {
        $modalInstance.dismiss('cancel');
      };
    };
  }
]);