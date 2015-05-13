<%--
  Created by IntelliJ IDEA.
  User: Wyvern
  Date: 03.05.2015
  Time: 1:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/WEB-INF/custom.tld" %>
<html>
<link rel="stylesheet" href="resources/css/base.css">

 <title>Tonique</title>
  <body>


  <section>
      <div id="header">

          <h1><a href="#">Tonique<span>Vocal school</span></a></h1>

          <%--<h2><text-align: right> телефон: 1234567890</text-align:></h2>--%>
          <%--<h2><text-align: right>  адрес: город, дом, улица </text-align:></h2>--%>

      </div>
      <div id = "menu">
              <ul class="navigation">
                  <li><a href="/"<s:selected check="/"/>>Home</a></li>
                  <li><a href="/login"<s:selected check="login.jsp"/>>Login</a></li>
                  <li><a href="/registration"<s:selected check="registr.jsp"/>>Registration</a></li>
                  <li><a href="/userHome" <s:selected check="userHome.jsp"/>>User Home</a></li>
              </ul>
          </div>
      <div id = selected>
          <jsp:include page="/WEB-INF/${page}"/>

${page}

      </div>
      <footer>
      </footer>
  </section>


  </body>
</html>
