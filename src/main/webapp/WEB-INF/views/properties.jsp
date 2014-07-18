<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html ng-app="propertyApp">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="Australia Real Estate NewAD">
  <title>Properties - NewAD | Real Estate</title>

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
      </ul>
      <h2>所有房源</h2>
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

      <div id="content" class="col-lg-7 col-md-6 col-sm-6 col-xs-12 clearfix" ng-controller="PropertyCtrl">
        
        <div class="property_wrapper img_list_box boxes clearfix" ng-repeat="prop in page.items">
          <div class="title clearfix">
            <h3><a href='/property/prop.id"/>' target="_blank">{{prop.feature}}</a> 
              <small class="small_title">{{prop.address}}</small>
            </h3>
          </div><!-- end title -->

          <div class="ImageWrapper boxes_img">
            <img class="img-responsive" ng-src="/static/propertyPic/{{prop.firstPicId}}" alt="">
            <div class="box_type">$A {{prop.price}}</div>
            <div class="status_type">{{prop.newOrEstablished}}</div>
          </div><!-- ImageWrapper -->

          <div class="boxed_mini_details1 col-md-8 clearfix search_details">
            <span class="type first"><strong>类型</strong>{{prop.propertyType}}</span>
            <span class="sqft"><strong>面积 m<sup>2</sup></strong>{{prop.landSize}}</span>
            <span class="bedrooms"><strong>卧室</strong>{{prop.beds}}</span>
            <span class="status"><strong>浴室</strong>{{prop.bathrooms}}</span>
            <span class="garage"><strong>车位</strong>{{prop.carSpaces}}</span>
          </div><!-- end boxed_mini_details1 -->

          <div class="property_desc clearfix">
            <a class="btn btn-primary btn-xs" ng-href="/property/{{prop.id}}" title="详 细" target="_blank"> 详 细 </a>
          </div>
        </div><!-- end property_wrapper -->
        
        <div class="alert alert-info">
          <span ng-show="page.currentPage > 1" class="navi pre_page" ng-click="navi(page.previousIndex, page.pageSize)" title="上一页"><i class="fa fa-backward"></i></span>
          <span class="crt_loc">Page {{page.currentPage}} / {{page.pageCount}}</span>
          <span ng-show="page.currentPage < page.pageCount" class="navi nxt_page" ng-click="navi(page.nextIndex, page.pageSize)" title="下一页"><i class="fa fa-forward"></i></span>
        </div>

      </div><!-- end content, in ngController -->

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
  <script src="/static/js/public/properties.js"></script>
</body>
</html>