var newadApp = angular.module('newadApp',
  [
    'angular-flexslider', 'ui.bootstrap.modal',
    'template/modal/window.html'
]);

newadApp.controller('SlideCtrl', ['$scope', 'SlideService',
  function ($scope, SlideService) {
    var slides = [];
    SlideService.getSlides().success(function (data) {
      for(var i=0; i<data.length; i++) {
        var item = data[i];
        slides.push({
          id: item.id,
          title: item.feature,
          intro: item.address,
          type: item.propertyType,
          price: '$A' + item.price,
          status: item.newOrEstablished,
          path: '/static/propertyPic/' + item.firstPicId,
          url: 'property/' + item.id
        });
      }
      $scope.slides = slides;
    });
  }
]);

newadApp.controller('EmailCtrl', ['$scope', '$modal', 'EmailService',
  function ($scope, $modal, EmailService) {

    $scope.reportNeed = {
      gfzn: true,
      tzym: true,
      jsym: true,
      gzdb: true,
      dxlx: true,
      zxlx: true
    };

    $scope.btnDisabled = true;

    $scope.change = function (str) {
      switch(str) {
        case 'gfzn':
          $scope.reportNeed.gfzn = !$scope.reportNeed.gfzn;
          checkForm();
          break;
        case 'tzym':
          $scope.reportNeed.tzym = !$scope.reportNeed.tzym;
          checkForm();
          break;
        case 'jsym':
          $scope.reportNeed.jsym = !$scope.reportNeed.jsym;
          checkForm();
          break;
        case 'gzdb':
          $scope.reportNeed.gzdb = !$scope.reportNeed.gzdb;
          checkForm();
          break;
        case 'dxlx':
          $scope.reportNeed.dxlx = !$scope.reportNeed.dxlx;
          checkForm();
          break;
        case 'zxlx':
          $scope.reportNeed.zxlx = !$scope.reportNeed.zxlx;
          checkForm();
          break;
        default:
          checkForm();
          break;
      }
    }

    $scope.pop = function (need) {
      var modalInstance = $modal.open({
        templateUrl: 'myModalContent.html',
        controller: ModalInstanceCtrl,
        backdrop: false,
        resolve: {
          message: function () {
            var msg = {title: '发送资料', content: '正在发送，请稍后检查您的邮箱。'};
            if(!$scope.customer) return msg;
            else {
              var customer = $scope.customer;
              customer.reports = $scope.reportNeed;
              EmailService.sendEmail(customer).
              success(function(data) {
                msg.title = '资料已发送';
                msg.content = '资料已发送到您所提供的邮箱，请稍后查收。谢谢！';
                $scope.customer = {name: '', email: '', tel: '', need: ''};
              }).
              error(function(data) {
                msg.title = '资料已发送';
                msg.content = '资料已发送到您所提供的邮箱，请稍后查收。谢谢！';
                $scope.customer = {name: '', email: '', tel: '', need: ''};
              });
              return msg;
            }
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

    var checkForm = function () {
      if((
          $scope.reportNeed.gfzn ||
          $scope.reportNeed.tzym ||
          $scope.reportNeed.jsym ||
          $scope.reportNeed.gzdb ||
          $scope.reportNeed.dxlx ||
          $scope.reportNeed.zxlx
         )
         && ($scope.customer)
         && ($scope.customer.name)
         && ($scope.customer.email)
         && ($scope.customer.tel)
        ) $scope.btnDisabled = false;
        else $scope.btnDisabled = true;
    }

    $scope.checkForm = checkForm;

    checkForm();

  }
]);

newadApp.factory('EmailService', function ($http) {
  return {
    sendEmail: function (form) {
      return $http.post('/sendEmail', form);
    }
  }
});

newadApp.factory('SlideService', function ($http) {
  return {
    getSlides: function () {
      return $http.get('/carouselProperties');
    }
  }
});