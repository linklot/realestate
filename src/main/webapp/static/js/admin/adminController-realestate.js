AdminControllers.controller('PropertyListCtrl',
                            ['$rootScope', '$scope', '$location', 'PropertyService',
  function ($rootScope, $scope, $location, PropertyService) {
    $rootScope.current = "property_list";
    
    var getData = function (startIndex, pageSize) {
      var reqData = {'startIndex': startIndex, 'pageSize': pageSize};
      PropertyService.getPropertyList(reqData).success(function (data) {
        $scope.page = data;
      });
    };
    
    $scope.navi = function (startIndex, pageSize) {
      getData(startIndex, pageSize);
    };
    
    $scope.modify = function (propertyId) {
      $location.path('/property/' + propertyId);
    };
    
    getData(0, 20);
  }
]);

AdminControllers.controller('PropertyBaseInfoCtrl',
                            ['$rootScope', '$scope', '$location', '$routeParams',
                             'PropertyService',
  function ($rootScope, $scope, $location, $routeParams, PropertyService) {
    $rootScope.current = "realestate_management";
    var propertyId = $routeParams.propertyId;
    if (propertyId > 0) $scope.modifyOld = true;
    else $scope.modifyOld = false;
    
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
    
    PropertyService.getPropertyBaseInfo(propertyId).success(function (data) {
      $scope.property = data;
    });
    
    $scope.saveBaseInfo = function () {
      PropertyService.savePropertyBaseInfo($scope.property).success(function(data) {
        $location.path('/property/'+ data + '/pictures');
      }).error(function(data, status, headers, config) {
        console.log(data);
      });
    };
    
    $scope.delete = function () {
      PropertyService.deleteProperty(propertyId).success(function (data) {
        $location.path('/realestate_list');
      });
    };
  }
]);

AdminControllers.controller('PropertyPictureCtrl',
                            ['$rootScope', '$scope', '$location',
                             '$routeParams', '$upload',
                             'PropertyService',
  function ($rootScope, $scope, $location, $routeParams, $upload, PropertyService) {
    $rootScope.current = "realestate_management";
    
    var fetchPics = function () {
      PropertyService.getPropertyPictures($routeParams.propertyId).success(function (data) {
        $scope.pictureGroup = data;
      });
    }
    
    $scope.onPicSelect = function($files) {
      $scope.file = $files[0];
    };
    
    $scope.upload = function() {
      var file = $scope.file;
      var size = file.size;
      var type = file.type;
      
      if (file && type.indexOf('image') > -1 && size <= 1000000) {
        // it's an image, size <= 1MB
        $upload
          .upload({
            url: '/admin/property/picGroup/pic',
            data: {picGroupId: $scope.pictureGroup.id},
            file: file
          })
          .success(function (data) {
            if(data == 'true') {
              // uploading succeeded
              fetchPics();
            } else {
              // uploading failed
              $scope.uploadingFails = true;
            }
          });
      }
    };
    
    $scope.delete = function (id) {
      PropertyService.deletePropertyPicture(id).success(function (data) {
        fetchPics();
      });
    };
    
    fetchPics();
  }
]);