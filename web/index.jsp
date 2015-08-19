<%--
  Created by IntelliJ IDEA.
  User: Wyvern
  Date: 03.05.2015
  Time: 1:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/WEB-INF/custom.tld" %>

<head>
    <link href="resources/css/base.css" rel="stylesheet" type="text/css"   />
    <meta charset="utf-8">
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script src="//code.jquery.com/jquery-1.10.2.js"></script>
    <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
    <link rel="stylesheet" href="/resources/demos/style.css">
    <title>Tonique</title>
</head>

<body class="${page}">
    <div id="header">
        <h1><a href="#">Tonique<span>Vocal school</span></a></h1>
    </div>

    <div id = "menu">
        <jsp:include page="/WEB-INF/${menu}.jsp"/>
    </div>
    <section>
        <div >
            <jsp:include page="/WEB-INF/${page}.jsp"/>
        </div>
    </section>

<%--${not empty user} вернёт true если атрибут юзер не null --%>
    <%--<footer>--%>
        <%--<h4><text-align: right> телефон: (077)-777-77-77</text-align:></h4>--%>
        <%--<h4><text-align: right> адрес: город, дом, улица </text-align:></h4>--%>
    <%--</footer>--%>
</body>
</html>