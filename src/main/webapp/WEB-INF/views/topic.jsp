<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="Australia Real Estate NewAD">
  <title><c:out value="${topic.column.name}"/> - NewAD | Real Estate</title>

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

<section class="post-wrapper-top dm-shadow clearfix">
  <div class="container">
    <div class="post-wrapper-top-shadow">
      <span class="s1"></span>
    </div>
    <div class="col-lg-12">
      <ul class="breadcrumb">
        <li><a href="/">Home</a></li>
        <li><a href='/column/<c:out value="${topic.column.id}"/>'><c:out value="${topic.column.name}"/></a></li>
      </ul>
      <h2>文章内容</h2>
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
        <div class="property_wrapper boxes clearfix topic_list">
          <h3><c:out value="${topic.title}"/></h3>
          <small><c:out value="${topic.source}"/></small><small class="gap_time"><c:out value="${topic.readableTime}"/></small>
          <hr/>
          <div class="news_content"><c:out value="${topic.content}" escapeXml="false"/></div>
        </div><!-- end property_wrapper -->
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
  </script>
</body>
</html>