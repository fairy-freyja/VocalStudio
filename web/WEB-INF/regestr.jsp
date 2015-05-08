/**
 * Created by Wyvern on 08.05.2015.
 */
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<title></title>
</head>
<body>
<%= request.getAttribute("Failed") != null ? request.getAttribute("Failed") : ""%>

<div class="container">

<form method="post" action="/registration">

<input type="text" name="login" placeholder="Login" autofocus />

<input type="password" name="password" placeholder="Password" />

<input type="email" name="email" placeholder="Email" />

<p><input type="submit" name="commit" value="Register"></p>

</form>
</div>
</body>
</html>
