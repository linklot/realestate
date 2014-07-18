<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="Australia Real Estate NewAD">
  <title><c:out value="${property.address}"/>Property - NewAD | Real Estate</title>

  <link href="/static/assets/css/bootstrap.css" rel="stylesheet">
  <link href="/static/css/style.css" rel="stylesheet">
  <link href="//netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">


  <link href='http://fonts.googleapis.com/css?family=Lato:400,300,400italic,700,700italic,900' rel='stylesheet' type='text/css'>
  <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800,300italic,400italic' rel='stylesheet' type='text/css'>

  <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!--[if lt IE 9]>
    <script src="assets/js/html5shiv.js"></script>
    <script src="assets/js/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>

    <c:import url="/header"/>

    <div id="curr_addr" style="display: none"><c:out value="${property.address}"/></div>

    <section class="post-wrapper-top dm-shadow clearfix">
      <div class="container">
        <div class="post-wrapper-top-shadow">
          <span class="s1"></span>
        </div>
        <div class="col-lg-12">
          <ul class="breadcrumb">
            <li><a href="/">Home</a></li>
          </ul>
          <h2>房源展示</h2>
        </div>
      </div>
    </section><!-- end post-wrapper-top -->

    <section class="generalwrapper dm-shadow clearfix">
      <div class="container">
        <div class="row">
          <div id="left_sidebar" class="col-lg-2 col-md-3 col-sm-3 col-xs-12 first clearfix">
            <div class="widget clearfix">
              <div class="title"><h3>广告位</h3></div>
              <a href="#"><img src="/static/demos/03_banner.png" alt="" class="img-thumbnail img-responsive"></a>
            </div><!-- end widget -->
          </div><!-- #left_sidebar -->

          <div id="content" class="col-lg-7 col-md-6 col-sm-6 col-xs-12 clearfix">
            <div class="property_wrapper boxes clearfix">
              <div class="boxes_img">
                <div id="slider" class="flexslider clearfix">
                  <ul class="slides">
                    <c:forEach var="picId" items="${property.picIds}">
                    <li>
                      <img class="img-thumbnail" src='/static/propertyPic/<c:out value="${picId}"/>' alt="">
                    </li>
                  </c:forEach>
                </ul>
              </div>
              <div id="carousel" class="flexslider clearfix">
                <ul class="slides">
                  <c:forEach var="picId" items="${property.picIds}">
                  <li><img class="img-thumbnail" src='/static/propertyPic/<c:out value="${picId}"/>' alt=""></li>
                </c:forEach>
              </ul>
            </div>  
          </div><!-- boxes_img -->

          <hr>

          <div class="title clearfix">
            <h3><c:out value="${property.feature}"/>
              <small class="small_title"><c:out value="${property.address}"/> <mark>$A <c:out value="${property.price}"/></mark></small>
            </h3>
          </div><!-- end title -->

          <div class="boxed_mini_details1 clearfix detail_box">
            <span class="type first"><strong>类型</strong><c:out value="${property.propertyType}"/></span>
            <span class="sqft"><strong>面积</strong><i class="icon-sqft"></i> <c:out value="${property.landSize}"/></span>
            <span class="bedrooms"><strong>卧室</strong><i class="icon-bed"></i> <c:out value="${property.beds}"/></span>
            <span class="status"><strong>浴室</strong><i class="icon-bath"></i> <c:out value="${property.bathrooms}"/></span>
            <span class="garage"><strong>车位</strong><i class="icon-garage"></i> <c:out value="${property.carSpaces}"/></span>
          </div><!-- end boxed_mini_details1 -->

          <div class="property_desc clearfix">

          <p><c:out value="${property.introduction}" escapeXml="false"/></p>
          </div>
        </div><!-- end property_wrapper -->

        <div class="property_wrapper boxes clearfix">
          <div id="map_canvas" class="col-lg-12 col-md-12 col-sm-12 col-xs-12" style="height: 620px"></div>
        </div>

      </div><!-- end content -->

      <div id="right_sidebar" class="col-lg-3 col-md-3 col-sm-3 col-xs-12 last clearfix">
        <div class="widget clearfix">
          <div class="title">
            <h3><i class="fa fa-file-archive-o"></i> 免费领取报告</h3>
          </div>
          <div class="text-left clearfix">
            <div class="report_btn narrow">
              <ul>
                <li><i class="fa fa-paper-plane"></i> 澳大利亚移民指南</li>
                <li><i class="fa fa-graduation-cap"></i> 澳大利亚留学指南</li>
                <li><i class="fa fa-bank"></i> 澳大利亚房产投资报告</li>
              </ul>
            </div>
            <div class="form-group">
              <input type="text" class="form-control report-form-control" placeholder="您的姓名（必填）" ng-model="customer.name" required>
            </div>
            <div class="form-group">
              <input type="email" class="form-control report-form-control" placeholder="您的邮箱地址（必填）" ng-model="customer.email" required>
            </div>
            <div class="form-group">
              <input type="text" class="form-control report-form-control" placeholder="您的电话号码（必填）" ng-model="customer.tel"required>
            </div>
            <div class="form-group">
              <textarea class="form-control report-form-control" rows="3" placeholder="我们可以如何帮助您？" ng-model="customer.need"></textarea>
            </div>
            <button type="submit" class="btn btn-info mail-btn">立即获取邮件</button>
          </div>
        </div><!-- end widget -->

        <div class="widget clearfix">
          <div class="title">
            <h3><i class="fa fa-users"></i> 相关服务</h3>
          </div>
          <div class="text-left clearfix">
            <div class="report_btn narrow">
              <ul>
                <li><i class="fa fa-paper-plane"></i> 澳大利亚移民服务</li>
                <li><i class="fa fa-graduation-cap"></i> 澳大利亚留学服务</li>
                <li><i class="fa fa-bank"></i> 澳大利亚房产投资服务</li>
              </ul>
            </div>
          </div><!-- end of widget -->

          <div class="widget clearfix">
          </div><!-- end of widget -->  
        </div><!-- end sidebar -->

      </div><!-- end row -->
    </div><!-- end container -->
  </section><!-- end generalwrapper -->

  <c:import url="/footer"/>


  <!-- Bootstrap core and JavaScript's
  ================================================== -->
  <script src="/static/js/jquery-1.10.2.min.js"></script>
  <script src="/static/js/bootstrap.js"></script>
  <script src="/static/js/jquery.parallax.js"></script>
  <script src="/static/js/jquery.fitvids.js"></script>    
  <script src="/static/js/jquery.unveilEffects.js"></script>  
  <script src="/static/js/retina-1.1.0.js"></script>
  <script src="/static/js/fhmm.js"></script>
  <script src="/static/js/bootstrap-select.js"></script>
  <script src="/static/fancyBox/jquery.fancybox.pack.js"></script>
  <script src="/static/js/application.js"></script>
  <script src="/static/js/angular-1.2.17.min.js"></script>
  <script src="/static/js/public/index.js"></script>

  <!-- FlexSlider JavaScript
  ================================================== -->
  <script src="/static/js/jquery.flexslider.js"></script>
  <script src="/static/js/angular-flexslider.js"></script>
  <script src="https://maps.googleapis.com/maps/api/js?v=3&language=zh-CN"></script>

  <script>
  $(window).load(function() {
    $('#carousel').flexslider({
      animation: "slide",
      controlNav: true,
      directionNav: false,
      animationLoop: true,
      slideshow: true,
      itemWidth: 114,
      itemMargin: 0,
      asNavFor: '#slider',
    });

    $('#slider').flexslider({
      animation: "fade",
      controlNav: false,
      animationLoop: false,
      slideshow: true,
      sync: "#carousel"
    });

    $('#property-slider .flexslider').flexslider({
      animation: "fade",
      slideshowSpeed: 6000,
      animationSpeed: 1300,
      directionNav: true,
      controlNav: false,
      keyboardNav: true,
      start: function (slider) {
        var idx = slider.currentSlide;
        transfer(idx);
      },
      after: function (slider) {
        var idx = slider.currentSlide;
        transfer(idx);
      }
    });

    var transfer = function (idx) {
      var html = $(".prop_desc:eq("+ idx +")").html();
      $('.searchmodule').html('<p>'+ html +'</p>');
    }
  });

  var geocoder;
  var map;
  var address = $('#curr_addr').html();
  function initialize() {
    geocoder = new google.maps.Geocoder();
    var myOptions = {
      zoom: 12,
      streetViewControl: true,
      zoomControl: true,
      zoomControlOptions: { style: google.maps.ZoomControlStyle.DEFAULT }
    };
    map = new google.maps.Map(document.getElementById("map_canvas"), myOptions);
    if (geocoder) {
      geocoder.geocode( { 'address': address}, function(results, status) {
        if (status == google.maps.GeocoderStatus.OK) {
          if (status != google.maps.GeocoderStatus.ZERO_RESULTS) {
            map.setCenter(results[0].geometry.location);

            var marker = new google.maps.Marker({
                position: results[0].geometry.location,
                map: map, 
                title: address,
                icon: '/static/images/marker.png'
            });
          }
        }
      });
    }
  }

  initialize();
  </script>
</body>
</html>