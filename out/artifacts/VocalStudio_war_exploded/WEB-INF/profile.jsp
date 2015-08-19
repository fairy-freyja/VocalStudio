<%--
  Created by IntelliJ IDEA.
  User: Fairy
  Date: 6/12/2015
  Time: 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h5>${Failed}</h5>

<p><form method="post" action="/profile">


  <p><input type="hidden" name="id" value="${currentUser.idUser}" />

  <p> <h6>Login </h6><input type="text" name="login" value="${currentUser.login}" autofocus required/>

  <p>  <h6> Password </h6><input type="password" name="password" value="${currentUser.password}" placeholder="Password" required/>

  <p> <h6>Email</h6> <input type="email" name="email" value="${currentUser.email}" placeholder="Email" required/>

  <p> <h6>Name</h6> <input type="text" name="name" value="${currentUser.name}" placeholder="Name" required/>

  <p>  <h6>Surname</h6> <input type="text" name="surname" value="${currentUser.surname}" placeholder="Surname" />

  <p> <h6>Phone number</h6><input type="text" name="phoneNumber" value="${currentUser.phoneNumber}" placeholder="Phone number" required />

  <p> <h6>Sex</h6> <select name="sex" value="${currentUser.sex}" >
  <option value="m">man</option>
  <option value="w">woman</option>
  </select>

  <p><input type="submit" name="commit" value="Change your profile"></p>

</form>