<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="kz.bitlab.techorda.db.News" %>
<%@ page import="kz.bitlab.techorda.db.Comment" %>

<html>
<head>
  <title>Title</title>
  <%@include file="head.jsp"%>
</head>
<body>
<%@include file="navbar.jsp"%>
<div class="container mt-3">
  <div class="row">
    <div class="col-12 mx-auto">
      <h1>HELLO <%=currentUser!=null?currentUser.getFullName():""%></h1>

    </div>
  </div>
</div>
</body>
</html>
