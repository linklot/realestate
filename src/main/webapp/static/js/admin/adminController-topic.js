AdminControllers.controller('TopicAddSelectColumnCtrl',
                            ['$rootScope', '$scope', '$location',
                             'ColumnService',
  function ($rootScope, $scope, $location, ColumnService) {
    $rootScope.current = "topic_add";

    ColumnService.getRootColumn().success(function(data) {
      $scope.rootColumn = data;
    });

    $scope.selectColumn = function (column_id) {
      $location.path('/column/'+ column_id +'/addTopic');
    };
  }
]);

AdminControllers.controller('TopicAddCtrl',
                            ['$rootScope','$scope','$location',
                             '$routeParams','ColumnService',
                             'TopicService',
  function ($rootScope, $scope, $location, $routeParams, ColumnService, TopicService) {
    $rootScope.current = 'topic_add';
    
    $scope.tinymceOptions = {
      theme: "modern",
      plugins: [
        'advlist', 'autolink', 'lists', 'link', 'image', 'charmap', 'print', 'preview', 'hr', 'anchor', 'pagebreak',
        'searchreplace', 'wordcount', 'visualblocks', 'visualchars', 'code', 'fullscreen',
        'insertdatetime', 'media', 'nonbreaking', 'save', 'table', 'contextmenu', 'directionality',
        'emoticons', 'template', 'paste', 'textcolor'
      ],
      toolbar1: "insertfile undo redo | styleselect | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | link image",
      toolbar2: "print preview media | forecolor backcolor emoticons",
      image_advtab: true
    };

    ColumnService.getColumn($routeParams.columnId).success(function(data) {
        $scope.column = data;
        $scope.topic.columnId = data.id;
    });

    $scope.addTopic = function () {
      var topic = $scope.topic;
      if(topic.title) {
        TopicService.addTopic(topic).success(function (data) {
          $location.path('/topics');
        });
      }
    };
  }
]);

AdminControllers.controller('TopicMgmtCtrl',
                            ['$rootScope','$scope','$location',
                             '$routeParams','TopicService',
  function ($rootScope, $scope, $location, $routeParams, TopicService) {
    $rootScope.current = 'topic_management';
    
    getData(0, 20);
    
    $scope.navi = function(startIndex, pageSize) {
      getData(startIndex, pageSize);
    };
    
    function getData(startIndex, pageSize) {
      var reqData = {'startIndex': startIndex, 'pageSize': pageSize};
      TopicService.getTopics(reqData).success(function (data) {
        $scope.page = data;
      });
    }
    
    $scope.delTopic = function(id) {
      var reqData = {'id': id};
      TopicService.delTopic(reqData).success(function(data) {
        getData($scope.page.startIndex, $scope.page.pageSize);
      });
    };
  }
]);

AdminControllers.controller('TopicModifyCtrl',
                            ['$rootScope','$scope','$location',
                             '$routeParams','TopicService',
  function ($rootScope, $scope, $location, $routeParams, TopicService) {
    $rootScope.current = 'topic_management';
    $scope.updated = false;
    $scope.tinymceOptions = {
      theme: "modern",
      plugins: [
        'advlist', 'autolink', 'lists', 'link', 'image', 'charmap', 'print', 'preview', 'hr', 'anchor', 'pagebreak',
        'searchreplace', 'wordcount', 'visualblocks', 'visualchars', 'code', 'fullscreen',
        'insertdatetime', 'media', 'nonbreaking', 'save', 'table', 'contextmenu', 'directionality',
        'emoticons', 'template', 'paste', 'textcolor'
      ],
      toolbar1: "insertfile undo redo | styleselect | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | link image",
      toolbar2: "print preview media | forecolor backcolor emoticons",
      image_advtab: true
    };
    
    TopicService.getTopic($routeParams.topicId).success(function (data) {
      $scope.topic = data;
    });
    
    $scope.modifyTopic = function() {
      if ($scope.topic.title) {
        TopicService.modifyTopic($scope.topic).success(function (data) {
          $scope.updated = true;
        });
      }
    }
  }
]);