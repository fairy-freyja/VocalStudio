<%--
  Created by IntelliJ IDEA.
  User: Wyvern
  Date: 08.05.2015
  Time: 20:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <title>Login Form</title>
  <link rel="stylesheet" href="css/style.css">
  <!--[if lt IE 9]><script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
</head>
<body>
<%= request.getAttribute("Failed") != null ? request.getAttribute("Failed") : ""%>
<section class="container">
  <div class="login">
    <h1>Login to Web App</h1>
    <form method="post" action="/login">
      <p><input type="text" name="login" value="" placeholder="Username"></p>
      <p><input type="password" name="password" value="" placeholder="Password"></p>
      <p><input type="email" name="email" value="email" placeholder="Email"></p>
      <p class="remember_me">
        <label>
          <input type="checkbox" name="remember_me" id="remember_me">
          Remember me on this computer
        </label>
      </p>
      <p class="submit"><input type="submit" name="commit" value="Login"></p>
    </form>
    <form method="get" action="/registration">
      <input type="submit" value="Registration">
    </form>
  </div>


  <div class="login-help">
    <img src="/logo.gif" alt="logo"/>
    <p>Forgot your password? <a href="index.html">Click here to reset it</a>.</p>
    <p>Wonna register? <a href="/register">Click here to register</a>.</p>

  </div>
</section>

</body>
</html>