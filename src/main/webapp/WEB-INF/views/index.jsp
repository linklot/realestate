<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html ng-app="newadApp">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="Australia Real Estate NewAD">
  <title>NewAD - Real Estate</title>

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

    <section id="one-parallax" class="parallax" style="background-color: #19B8DF;">
      <div class="mapandslider" ng-controller="SlideCtrl">
        <div class="overlay1 dm-shadow">
          <div class="container">
            <div class="row">
              <div class="col-lg-8 col-md-8 col-sm-12">
                <div id="property-slider" class="clearfix">
                  <div class="flexslider">
                    <ul class="slides">
                      <flex-slider slide="s in slides track by s.id">
                      <li>
                        <div class="desc">
                          <div class="ps-desc">
                            <h3><a href="{{s.url}}" target="_blank">{{s.title}}</a></h3>
                            <span class="prop_desc">{{s.intro}}</span>
                            <span class="type">{{s.type}}</span>
                            <span class="price">{{s.price}}</span>
                            <span class="status">{{s.status}}</span>
                          </div>
                        </div>
                        <a href="{{s.url}}" target="_blank"><img ng-src="{{s.path}}"></a>
                      </li>
                    </flex-slider>
                  </ul><!-- end slides -->
                </div><!-- end flexslider -->
              </div><!-- end property-slider -->
            </div><!-- end col-lg-8 -->

            <div class="col-lg-4 col-md-4 col-sm-12">
              <div class="searchmodule clearfix" data-effect="slide-right">
                <form id="advanced_search" action="/search" class="clearfix" name="advanced_search" method="post">
                  <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <label for="suburb">Suburb</label>
                    <input type="text" class="form-control" id="suburb" placeholder="部分名称" name="suburb"></input>
                  </div>
                  <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
                    <label for="newOrEstablished">现房/期房</label>
                    <select id="newOrEstablished" class="show-menu-arrow selectpicker" name="newOrEstablished">
                      <option value="any">不限</option>
                      <option value="established">现房</option>
                      <option value="new">期房</option>
                    </select>
                  </div>
                  <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
                    <label for="type">类型</label>
                    <select id="type" class="show-menu-arrow selectpicker" name="type">
                      <option value="any">不限</option>
                      <option value="house">House</option>
                      <option value="townhouse">Townhouse</option>
                      <option value="apartment">Apartment</option>
                      <option value="unit">Unit</option>
                      <option value="land">Land</option>
                    </select>
                  </div>
                  <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
                    <label for="beds">卧室</label>
                    <select id="beds" class="show-menu-arrow selectpicker" name="beds">
                      <option value="0">不限</option>
                      <option value="1">1</option>
                      <option value="2">2</option>
                      <option value="3">3</option>
                      <option value="4">4</option>
                      <option value="5">5</option>
                      <option value="6">6</option>
                    </select>
                  </div>
                  <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
                    <label for="baths">浴室</label>
                    <select id="baths" class="show-menu-arrow selectpicker" name="bathrooms">
                      <option value="0">不限</option>
                      <option value="1">1</option>
                      <option value="2">2</option>
                      <option value="3">3</option>
                    </select>
                  </div>
                  <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
                    <label for="min_price">最低价格</label>
                    <select id="min_price" class="show-menu-arrow selectpicker" name="minPrice">
                      <option value="0">不限</option>
                      <option value="200000">$200,000</option>
                      <option value="250000">$250,000</option>
                      <option value="300000">$300,000</option>
                      <option value="350000">$350,000</option>
                      <option value="400000">$400,000</option>
                      <option value="500000">$500,000</option>
                    </select>
                  </div>
                  <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
                    <label for="max_price">最高价格</label>
                    <select id="max_price" class="show-menu-arrow selectpicker" name="maxPrice">
                      <option value="0">不限</option>
                      <option value="500000">$500,000</option>
                      <option value="600000">$600,000</option>
                      <option value="700000">$700,000</option>
                      <option value="800000">$800,000</option>
                      <option value="900000">$900,000</option>
                      <option value="1000000">$1,000,000+</option>
                    </select>
                  </div>
                  <div class="clearfix"></div>
                  <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <button class="btn btn-inverse btn-block"><i class="fa fa-search"></i> 搜索房源</button>
                  </div>
                </form>
              </div><!-- end search module -->
            </div><!-- end col-lg-4 --> 
          </div><!-- end row -->
        </div><!-- end dm_container -->
      </div>
    </div>
  </section><!-- end mapandslider -->

  <section>
    <div class="threewrapper">
      <div class="overlay1 dm-shadow">
        <div class="container">
          <div class="col-md-8">

            <div class="text-center clearfix">
              <h3 class="big_title"><a href="/properties">最新房源</a></h3>
            </div>

            <c:forEach var="p" items="${data.propertyDtos}">
            <div class="col-lg-6 col-md-6 col-sm-12 col-xs-15">
              <div class="boxes first" data-effect="slide-bottom">
                <div class="ImageWrapper boxes_img">
                  <img class="img-responsive" src='/static/propertyPic/<c:out value="${p.firstPicId}"/>' alt="">
                  <div class="ImageOverlayH"></div>
                  <div class="Buttons StyleMg">
                    <span class="WhiteSquare"><a href='/property/<c:out value="${p.id}"/>' target="_blank"><i class="fa fa-link"></i></a>
                    </span>
                  </div>
                  <div class="box_type">$A <c:out value="${p.price}"/></div>
                  <div class="status_type"><c:out value="${p.newOrEstablished}"/></div>
                </div>
                <h2 class="title"><a href='/property/<c:out value="${p.id}"/>' target="_blank"><c:out value="${p.feature}"/></a> <small class="small_title"><c:out value="${p.address}"/></small></h2>

                <div class="boxed_mini_details1 clearfix">
                  <span class="garage first"><strong>车位</strong><i class="icon-garage"></i> <c:out value="${p.carSpaces}"/></span>
                  <span class="bedrooms"><strong>卧室</strong><i class="icon-bed"></i> <c:out value="${p.beds}"/></span>
                  <span class="status"><strong>浴室</strong><i class="icon-bath"></i> <c:out value="${p.bathrooms}"/></span>
                  <span class="sqft last"><strong>面积 M<sup>2</sup></strong><i class="icon-sqft"></i> <c:out value="${p.landSize}"/></span>
                </div>
              </div><!-- end boxes -->
            </div>
          </c:forEach>
          <div class="clearfix"></div>
          <a href="/properties" class="btn btn-info more_property">查看更多</a>
          <div class="clearfix"></div>
        </div>
          <!-- end row -->

        <div class="col-md-4 col-right">
          <div id="report_wrapper" class="boxes">
            <div class="text-center clearfix" ng-controller="EmailCtrl">
              <h3 class="big_title">免费领取报告<small class="small_title">填写表格立即获得以下资料！</small></h3>
              <div class="text-left clearfix">
                <div class="report_btn">
                  <ul>
                    <li ng-click="change('gfzn')"><i ng-class="reportNeed.gfzn ? 'fa fa-check-square-o' : 'fa fa-square-o'"></i> 澳洲购房指南</li>
                    <li ng-click="change('tzym')"><i ng-class="reportNeed.tzym ? 'fa fa-check-square-o' : 'fa fa-square-o'"></i> 澳洲商业投资移民签证简介</li>
                    <li ng-click="change('jsym')"><i ng-class="reportNeed.jsym ? 'fa fa-check-square-o' : 'fa fa-square-o'"></i> 澳洲独立技术移民简介</li>
                    <li ng-click="change('gzdb')"><i ng-class="reportNeed.gzdb ? 'fa fa-check-square-o' : 'fa fa-square-o'"></i> 澳洲雇主担保移民简介</li>
                    <li ng-click="change('dxlx')"><i ng-class="reportNeed.dxlx ? 'fa fa-check-square-o' : 'fa fa-square-o'"></i> 大学生留学方案</li>
                    <li ng-click="change('zxlx')"><i ng-class="reportNeed.zxlx ? 'fa fa-check-square-o' : 'fa fa-square-o'"></i> 中学生留学方案</li>
                  </ul>
                </div>
                <div class="form-group">
                  <input type="text" class="form-control report-form-control" placeholder="您的姓名（必填）" ng-model="customer.name" ng-change="checkForm()" required>
                </div>
                <div class="form-group">
                  <input type="text" class="form-control report-form-control" placeholder="您的邮箱地址（必填）" ng-model="customer.email" ng-change="checkForm()" required>
                </div>
                <div class="form-group">
                  <input type="text" class="form-control report-form-control" placeholder="您的电话号码（必填）" ng-model="customer.tel" ng-change="checkForm()"required>
                </div>
                <div class="form-group">
                  <textarea class="form-control report-form-control" rows="3" placeholder="我们可以如何帮助您？" ng-model="customer.need"></textarea>
                </div>
                <button type="submit" class="btn btn-info mail-btn" ng-click="pop()" ng-disabled="btnDisabled">立即获取资料</button>
              </div>
            </div>
          </div>

          <div id="service_wrapper" class="boxes">
            <div class="text-center clearfix">
              <h3 class="big_title">相关服务<small class="small_title">为客户提供量身定制的服务</small></h3>
              <div class="text-left clearfix">
                <div class="report_btn">
                  <ul>
                    <li><i class="fa fa-paper-plane"></i> 澳大利亚移民服务</li>
                    <li><i class="fa fa-graduation-cap"></i> 澳大利亚留学服务</li>
                    <li><i class="fa fa-bank"></i> 澳大利亚房产投资服务</li>
                  </ul>
                </div>
              </div>
            </div>
          </div>
        </div>

      </div><!-- end container -->
    </div><!-- end overlay1 -->
  </div><!-- end threewrapper -->
</section><!-- end parallax -->

<section id="two-parallax" class="parallax" style="background-color: #19B8DF;" data-stellar-background-ratio="0.6" data-stellar-vertical-offset="20">
  <div class="threewrapper">
    <div class="overlay1 dm-shadow">
      <div class="container">
        <div class="row">
          <div class="text-center clearfix">
            <h3 class="big_title">房产资讯</h3>
          </div><!-- text-center -->
          <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
            <div class="boxes testimonial_widget text-left first" data-effect="slide-left">
              <div class="testimonial_desc">
                <h3 class="title"><a href="/column/3">最新动态</a></h3>
                <ul>
                  <c:forEach var="topic" items="${data.column_zxdt.topics}">
                  <li>
                    <span class="topic_title"><i class="fa fa-square"></i> <a href='/topic/<c:out value="${topic.id}"/>' target="_blank"><c:out value="${topic.title}"/></a></span>
                    <span class="topic_time"><c:out value="${topic.time}"/></span>
                  </li>
                </c:forEach>
              </ul>
            </div>
          </div>
        </div>
        <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
          <div class="boxes testimonial_widget text-left last" data-effect="slide-right">
            <div class="testimonial_desc">
              <h3 class="title"><a href="/column/2">政策法规</a></h3>
              <ul>
                <c:forEach var="topic" items="${data.column_zcfg.topics}">
                <li>
                  <span class="topic_title"><i class="fa fa-square"></i> <a href='/topic/<c:out value="${topic.id}"/>' target="_blank"><c:out value="${topic.title}"/></a></span>
                  <span class="topic_time"><c:out value="${topic.time}"/></span>
                </li>
              </c:forEach>
            </ul>
          </div>
        </div>
      </div>
      <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
        <div class="boxes testimonial_widget text-left first" data-effect="slide-left">
          <div class="testimonial_desc">
            <h3 class="title"><a href="/column/4">投资指南</a></h3>
            <ul>
              <c:forEach var="topic" items="${data.column_tzzn.topics}">
              <li>
                <span class="topic_title"><i class="fa fa-square"></i> <a href='/topic/<c:out value="${topic.id}"/>' target="_blank"><c:out value="${topic.title}"/></a></span>
                <span class="topic_time"><c:out value="${topic.time}"/></span>
              </li>
            </c:forEach>
          </ul>
        </div>
      </div>
    </div>
    <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
      <div class="boxes testimonial_widget text-left last" data-effect="slide-right">
        <div class="testimonial_desc">
          <h3 class="title"><a href="/column/5">购房须知</a></h3>
          <ul>
            <c:forEach var="topic" items="${data.column_gfxz.topics}">
            <li>
              <span class="topic_title"><i class="fa fa-square"></i> <a href='/topic/<c:out value="${topic.id}"/>' target="_blank"><c:out value="${topic.title}"/></a></span>
              <span class="topic_time"><c:out value="${topic.time}"/></span>
            </li>
          </c:forEach>
        </ul>
      </div>
    </div>
  </div>
</div><!-- end row -->
</div><!-- end container -->
</div><!-- end overlay1 -->
</div><!-- end threewrapper -->
</section><!-- end parallax -->

<c:import url="/footer"/>

<script type="text/ng-template" id="myModalContent.html">
  <div class="modal-header">
    <h3 class="modal-title">{{msg.title}}</h3>
  </div>
  <div class="modal-body">
    {{msg.content}}
  </div>
  <div class="modal-footer">
    <button class="btn btn-warning" ng-click="cancel()">确定</button>
  </div>
</script>


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
  <script src="/static/js/ui-bootstrap-custom-tpls-0.10.0.min.js"></script>
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
      keyboardNav: true
    });
  });
  </script>

</body>

</html>