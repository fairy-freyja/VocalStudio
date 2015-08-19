<%--
  Created by IntelliJ IDEA.
  User: Fairy
  Date: 6/11/2015
  Time: 01:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form method="get" action="/login">
  <input type="hidden" name="hidden.logout" default="logout">
  <input type="submit" name="submit.logout" value="Logout">
</form>

<h4> Hello, ${user.name}! </h4>
<p/>

<h3>Confirmed lesson request:</h3>
  <table border="5">
    <tr>
      <td><h6>User Name</h6></td>
      <td><h6>Contacts</h6></td>
      <td><h6>Date</h6></td>
      <td><h6>Time</h6></td>
      <td><h6>Status</h6></td>
    </tr>
    <c:forEach items="${listLRConfirmed}" var="elem">
      <tr>
        <td><h6>${elem.lrUser.name} ${elem.lrUser.surname}</h6></td>
        <td><h6>${elem.lrUser.email} ${elem.lrUser.phoneNumber}</h6></td>
        <td><h6>${elem.date}</h6></td>
        <td><h6>${elem.time}</h6></td>
        <td><h6>${elem.status}</h6></td>
      </tr>
    </c:forEach>
  </table>

<c:if test="${empty listLRConfirmed}">
  <p><h5>You have no confirmed lesson request</h5></p>
  <p></p>
</c:if>


<h3>Not confirmed lesson requests:</h3>
<table border="3">
  <tr>
    <td><h6>User Name</h6></td>
    <td><h6>Contacts</h6></td>
    <td><h6>Date</h6></td>
    <td><h6>Time</h6></td>
    <td><h6>Status</h6></td>
  </tr>
  <c:forEach items="${listLRNotConfirmed}" var="elem">
    <tr>
      <td><h6>${elem.lrUser.name} ${elem.lrUser.surname}</h6></td>
      <td><h6>${elem.lrUser.email} ${elem.lrUser.phoneNumber}</h6></td>
      <td><h6>${elem.date}</h6></td>
      <td><h6>${elem.time}</h6></td>
      <td><h6>${elem.status}</h6></td>
      <td><form method="post" action="/confirmed" >
        <input type="hidden" value="${elem.id}" name="idLessonRequest" autofocus>
        <input type="submit" value="confirmed" name="confirmed.button">
      </form></td>
    </tr>
  </c:forEach>
</table>