<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: Wyvern
  Date: 08.05.2015
  Time: 20:47
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<form method="get" action="/login">
    <input type="submit" name="submit.logout" value="Logout">
</form>


<h4> Hello, ${user.name}! </h4>
<p/>
<c:if test="${not empty listLRConfirmed}">
<h3>Confirmed lesson request:</h3>
<table border="5">
    <tr>
        <td><h6>Date</h6></td>
        <td><h6>Time</h6></td>
        <td><h6>Status</h6></td>
    </tr>
    <c:forEach items="${listLRConfirmed}" var="elem">
        <tr>
            <td><h6>${elem.date}</h6></td>
            <td><h6>${elem.time}</h6></td>
            <td><h6>${elem.status}</h6></td>
        </tr>
    </c:forEach>
</table>
</c:if>
<%--<c:if test="${not empty listLRConfirmed}">--%>
<p>.</p>
<p>.</p>
<%--</c:if>--%>
<h3>Not confirmed lesson requests:</h3>
<table border="3">
    <tr>
        <td><h6>Date</h6></td>
        <td><h6>Time</h6></td>
        <td><h6>Status</h6></td>
    </tr>
    <c:forEach items="${listLRNotConfirmed}" var="elem">
        <tr>
            <td><h6>${elem.date}</h6></td>
            <td><h6>${elem.time}</h6></td>
            <td><h6>${elem.status}</h6></td></tr>
    </c:forEach>
</table>
<p>
<p>
<p> <h6> If you wont send new lesson request please  </h6>
        <a href="/lessonRequest">
            <button>FORM lesson request</button>
        </a>
    </h6>
</p>