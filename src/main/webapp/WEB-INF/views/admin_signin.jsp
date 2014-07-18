<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Sign-in as Admin</title>
  <link rel="stylesheet" href="/static/css/bootstrap.min.css">
  <link rel="stylesheet" href="/static/css/bootstrap-theme.min.css">
  <link rel="stylesheet" href="/static/css/signin.css">
</head>
<body>
  <div class="container">
    <form class="form-signin" role="form" action="/newad-login" method="post">
      <h3 class="form-signin-heading">管理员登录</h3>
      <input type="text" class="form-control" name="j_username" placeholder="account" required autofocus>
      <input type="password" class="form-control" name="j_password" placeholder="password" required>
      <label class="checkbox">
        <input type="checkbox" name="remember-me"> Remember Me
      </label>
      <button type="submit" class="btn btn-success btn-block">登录</button>
    </form>
  </div>
</body>
</html>