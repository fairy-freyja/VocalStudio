<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h5><%= request.getAttribute("Failed") != null ? request.getAttribute("Failed") : ""%></h5>

 <p><form method="post" action="/registration">
     <p> <h6> Login</h6> <h5><input type="text" name="login" placeholder="Login" required autofocus />*</h5>

     <p> <h6>Password</h6> <h5><input type="password" name="password" required placeholder="Password" />*</h5>

     <p> <h6>Email</h6> <h5><input type="email" name="email" required placeholder="Email" />*</h5>

     <p> <h6>Name</h6> <h5><input type="text" name="name" required placeholder="Name" />*</h5>

     <p> <h6>Surname</h6> <input type="text" name="surname" placeholder="Surname" />

     <p> <h6>Phone number</h6> <h5><input type="text" name="phone_number" required placeholder="Phone number" /> *</h5>

     <p> <h6>Sex</h6> <input type="text" name="sex" placeholder="Sex" />

     <p><input type="submit" name="commit" value="Register"></p>
 </form>
