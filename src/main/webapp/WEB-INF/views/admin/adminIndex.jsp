<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="adminApp">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>NewAD - Admin Console</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="/static/css/dashboard.css">
    <link href="//netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/static/css/admin/admin.css">
    <script src="/static/js/angular-1.2.17.min.js"></script>
    <script src="/static/js/angular-route-1.2.17.min.js"></script>
    <script src="/static/js/tinymce/tinymce.min.js"></script>
    <script src="/static/js/ng-tinymce.js"></script>
    <script src="/static/js/angular-file-upload.min.js"></script>
    <script src="/static/js/ui-bootstrap-custom-tpls-0.10.0.min.js"></script>
    <script src="/static/js/admin/adminApp.js"></script>
    <script src="/static/js/admin/adminControllers.js"></script>
    <script src="/static/js/admin/adminController-realestate.js"></script>
    <script src="/static/js/admin/adminController-column.js"></script>
    <script src="/static/js/admin/adminController-topic.js"></script>
    <script src="/static/js/admin/adminController-reportRequest.js"></script>
</head>
<body ng-controller="IndexCtrl">

    <c:url value="/newad-logout" var="logoutUrl" />

    <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">新澳东房产 - 管理</a>
        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="${logoutUrl}" title="Quit">Quit</a></li>
          </ul>
        </div>
      </div>
    </div>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li ng-class="(current=='property_list') ? 'active' : ''"><a href="#/realestate_list">房源列表</a></li>
            <li ng-class="(current=='realestate_management') ? 'active' : ''"><a href="#/property/0">新增/管理</a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li ng-class="(current=='report_request') ? 'active' : ''"><a href="#/reportRequest">投资报告发送记录</a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li ng-class="(current=='column_management') ? 'active' : ''"><a href="#/column_list">栏目管理</a></li>
            <li ng-class="(current=='topic_management') ? 'active' : ''"><a href="#/topics">新闻列表</a></li>
            <li ng-class="(current=='topic_add') ? 'active' : ''"><a href="#/topic_add">发布新闻</a></li>
          </ul>
        </div>

        <section ng-view></section>

      </div>
    </div>
</body>
</html>