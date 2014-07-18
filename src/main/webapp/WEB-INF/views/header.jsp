<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="topbar clearfix">
  <div class="container">
    <div class="row">
      <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
        <div class="callus">
          <p>
            <span><i class="fa fa-envelope"></i> <a href="mailto:info@newad.com.au" title="邮件地址">info@newad.com.au</a></span>
            <span><i class="fa fa-phone-square"></i> +61 0333 444 555</span>
          </p>
        </div><!-- end callus-->
      </div><!-- end col-lg-6 -->
    </div><!-- end col-lg-6 -->
  </div><!-- end row -->
</div><!-- end container -->

<header class="header1">
  <div class="container">
    <div class="row header-row">
      <div class="col-lg-12 col-md-12 col-sm-12">
        <div class="logo-wrapper">
          <div class="logo">
            <a href="/" title="Home">
              <img src="/static/images/logo_3.png" alt="NewAD Real Estate">
            </a>
          </div><!-- /.site-name -->
        </div><!-- /.logo-wrapper -->
        <div class="banner-wrapper"></div>
        <div class="icon-wrapper">
          <a href="http://www.newad.com.au" target="_blank"><img src="/static/images/immi_icon.jpg" alt="新澳东留学移民网" title="新澳东留学移民"></a>
        </div>
      </div>
    </div><!-- end row -->
    <nav class="navbar navbar-default fhmm" role="navigation">
      <div class="menudrop container">
        <div id="defaultmenu" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <!-- Mega Menu -->
            <li class="dropdown fhmm-fw active"><a href="/"><i class="fa fa-home"></i> 首页</a></li><!-- mega menu -->
            <!-- list elements -->
            <li class="dropdown fhmm-fw"><a href="#" data-toggle="dropdown" class="dropdown-toggle">房源搜索 <b class="caret"></b></a>
              <ul class="dropdown-menu half">
                <li class="fhmm-content withoutdesc">
                  <div class="row">
                    <form id="advanced_search_module" class="clearfix" action="/search" name="advanced_search_module" method="post">
                      <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                        <label for="suburb">Suburb</label>
                        <input type="text" class="form-control" id="suburb" placeholder="部分名称" name="suburb"></input>
                      </div>                                       
                      <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
                        <label for="newOrEstablished">现房/期房</label>
                        <select id="newOrEstablished" class="form-control" name="newOrEstablished">
                          <option value="any">不限</option>
                          <option value="established">现房</option>
                          <option value="new">期房</option>
                        </select>
                      </div>
                      <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
                        <label for="type">类型</label>
                        <select id="type" class="form-control" name="type">
                          <option value="any">不限</option>
                          <option value="house">House</option>
                          <option value="townhouse">Townhouse</option>
                          <option value="apartment">Apartment</option>
                          <option value="unit">Unit</option>
                          <option value="land">Land</option>
                        </select>
                      </div>
                      <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
                        <label for="beds">卧室</label>
                        <select id="beds" class="form-control" name="beds">
                          <option value="0">不限</option>
                          <option value="1">1</option>
                          <option value="2">2</option>
                          <option value="3">3</option>
                          <option value="4">4</option>
                          <option value="5">5</option>
                          <option value="6">6</option>
                        </select>
                      </div>
                      <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
                        <label for="baths">浴室</label>
                        <select id="baths" class="form-control" name="bathrooms">
                          <option value="0">不限</option>
                          <option value="1">1</option>
                          <option value="2">2</option>
                          <option value="3">3</option>
                        </select>
                      </div>
                      <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
                        <label for="min_price">最低价格</label>
                        <select id="min_price" class="form-control" name="minPrice">
                          <option value="0">不限</option>
                          <option value="200000">$200,000</option>
                          <option value="250000">$250,000</option>
                          <option value="300000">$300,000</option>
                          <option value="350000">$350,000</option>
                          <option value="400000">$400,000</option>
                          <option value="500000">$500,000</option>
                        </select>
                      </div>
                      <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
                        <label for="max_price">最高价格</label>
                        <select id="max_price" class="form-control" name="maxPrice">
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
                      <hr>
                      <div class="col-lg-8 col-md-8 col-sm-8 col-xs-12">
                        <p>搜索符合您预期条件的房源。</p>
                      </div>
                      <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
                        <button class="btn btn-primary btn-block"><i class="fa fa-search"></i> 搜索</button>
                      </div> 
                      </form>
                    </div>
                  </li><!-- end grid demo -->
                </ul>
              </li><!-- end list elements -->
              <!-- list elements -->
              <li class="dropdown fhmm-fw"><a href="/column/3">最新动态</a>
              </li><!-- end list elements -->
              <!-- list elements -->
              <li class="dropdown fhmm-fw"><a href="/column/2">政策法规</a>
              </li><!-- end list elements -->
              <!-- standard drop down -->
              <li class="dropdown"><a href="/column/4">投资指南</a>
              </li><!-- end standard drop down -->
              <li><a href="/column/5">购房须知</a></li>
              <li><a href="/about">关于我们</a></li>
              <li><a href="/contact">联系我们</a></li>
            </ul><!-- end nav navbar-nav -->
          </div><!-- end #navbar-collapse-1 -->
        </div><!-- end dm_container -->
      </nav><!-- end navbar navbar-default fhmm -->
    </div><!-- end container -->
</header><!-- end header -->