<%@ page contentType="text/html;charset=UTF-8" language="java" %>
${LRFAILED}

<script>
  $(function() {
    $( "#datepicker" ).datepicker();
  });
</script>

<p><form method="post" action="/lessonRequest">
  <%--<p><input id="datepicker" name="datepicker" placeholder="DATE" autofocus />--%>
  <p> Date </p>
  <p><input pattern="[2][0]\d{2}[-]([0][1-9]|[1][0-2])[-]([0-2][\d]|[3][0,1])" name="date" placeholder="yyyy-mm-dd" required>*</p>
  <p> Time </p>
  <p><input pattern="([0][\\d]|[1][0-9]|[2][0-4]):([0-5][0-9])" name="time" placeholder="hh:mm" required>*</p>
  <p><input type="submit" name="commit" value="Sent request"></p>
</form>

<script src="http://code.jquery.com/jquery-latest.min.js"></script>

<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>


