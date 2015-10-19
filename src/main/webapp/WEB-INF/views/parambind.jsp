<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/10/19
  Time: 9:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>parambind.jsp</title>
</head>
<body>
<form action="parambind?urlParam=AAA" method="post" enctype="multipart/form-data">
    <input type="text" name="formParam"/><br/>
    <input type="file" name="formFile"/><br/>
    <input type="submit" value="Submit"/>
</form>
</body>
</html>
