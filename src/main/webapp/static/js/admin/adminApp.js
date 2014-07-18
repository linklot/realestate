var adminApp = angular.module('adminApp', [
  'ngRoute',
  'adminControllers',
  'ui.tinymce',
  'angularFileUpload',
  'ui.bootstrap.modal',
  'template/modal/window.html'
]);

adminApp.config(['$routeProvider',
  function($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: '/static/html/admin/admin-index.html',
        controller: 'IndexCtrl'
      })
      .when('/realestate_list', {
        templateUrl: '/static/html/admin/property-list.html',
        controller: 'PropertyListCtrl'
      })
      .when('/property/:propertyId', {
        templateUrl: '/static/html/admin/property_baseInfo.html',
        controller: 'PropertyBaseInfoCtrl'
      })
      .when('/column_list', {
        templateUrl: '/static/html/admin/column_list.html',
        controller: 'ColumnMgmtCtrl'
      })
      .when('/:parentId/addColumn', {
        templateUrl: '/static/html/admin/column_add.html',
        controller: 'ColumnAddCtrl'
      })
      .when('/topic_add', {
        templateUrl: '/static/html/admin/topic_add_1.html',
        controller: 'TopicAddSelectColumnCtrl'
      })
      .when('/topics', {
        templateUrl: '/static/html/admin/topics.html',
        controller: 'TopicMgmtCtrl'
      })
      .when('/topic/:topicId', {
        templateUrl: '/static/html/admin/topic.html',
        controller: 'TopicModifyCtrl'
      })
      .when('/column/:columnId/addTopic', {
        templateUrl: '/static/html/admin/topic_add_2.html',
        controller: 'TopicAddCtrl'
      })
      .when('/property/:propertyId/pictures', {
        templateUrl: '/static/html/admin/property_pictures.html',
        controller: 'PropertyPictureCtrl'
      })
      .when('/reportRequest', {
        templateUrl: '/static/html/admin/reportRequest.html',
        controller: 'ReportRequestCtrl'
      })
      .otherwise({
        redirectTo: '/'
      });
  }]);

// The service used to access column data from server
adminApp.factory('ColumnService', function ($http) {
  return {
    getRootColumn: function () {
      return $http.get('/admin/columnTree');
    },
    getColumn: function (id) {
      return $http.get('/admin/column/' + id);
    },
    addSubColumn: function (req_data) {
      return $http.post('/admin/column', req_data);
    },
    deleteColumn: function (id) {
      return $http.get('/admin/column/'+ id +'/delete');
    }
  }
});

// The service used to access topic data from server
adminApp.factory('TopicService', function ($http) {
  return {
    addTopic: function (topic) {
      return $http.post('/admin/topic', topic);
    },
    getTopics: function (reqData) {
      return $http.post('/admin/topics', reqData);
    },
    delTopic: function (reqData) {
      return $http.post('admin/topic/del', reqData);
    },
    getTopic: function (id) {
      return $http.get('/admin/topic/' + id);
    },
    modifyTopic: function (reqData) {
      return $http.post('/admin/topic/' + reqData.id, reqData);
    }
  }
});

adminApp.factory('PropertyService', function($http) {
  return {
    getPropertyBaseInfo: function(id) {
      return $http.get('/admin/property/' + id);
    },
    savePropertyBaseInfo: function (property) {
      return $http.post('/admin/property', property);
    },
    getPropertyList: function (reqData) {
      return $http.post('/admin/propertyList', reqData);
    },
    getPropertyPictures: function (id) {
      return $http.get('/admin/property/' + id +'/pictures');
    },
    deletePropertyPicture: function (id) {
      return $http.get('/admin/property/picture/'+ id + '/delete');
    },
    deleteProperty: function (id) {
      return $http.get('/admin/property/'+ id +'/delete');
    }
  };
});

adminApp.factory('ReportRequestService', function($http) {
  return {
    getRequestList: function() {
      return $http.get('/admin/reportRequests');
    }
  };
});

adminApp.directive('ngConfirmClick', [
  function() {
    return {
      priority: 1,
      terminal: true,
      link: function (scope, element, attr) {
        var msg = attr.ngConfirmClick || "确定执行？";
        var clickAction = attr.ngClick;
        element.bind('click',function (event) {
            if ( window.confirm(msg) ) {
                scope.$eval(clickAction)
            }
        });
      }
    };
  }
]);