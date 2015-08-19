<%--
  Created by IntelliJ IDEA.
  User: Fairy
  Date: 6/12/2015
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table border="5">
<c:forEach items="${listUser}" var="elem">
  <tr>
    <td><h6>${elem.name} ${elem.surname}</h6></td>
    <td><h6>email: ${elem.email}, phone number: ${elem.phoneNumber}</h6></td>
    <td><form method="get" action="/profile" >
      <input type="hidden" value="${elem.idUser}" name="idUser" >
      <input type="submit" value="Change profile" name="change.profile.button">
    </form></td>
    <td><form method="get" action="/userHome" >
      <input type="hidden" value="${elem.idUser}" name="idUser" >
      <input type="submit" value="look users lesson request" name="look.requests.button">
    </form></td>
  </tr>
</c:forEach>
</table>