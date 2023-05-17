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
      <h1>Welcome Back <%=currentUser!=null?currentUser.getFullName():""%></h1>

      <form action="/update-profile" method="POST">
        <div class="form-floating mb-3">
          <input type="password" class="form-control" id="floatingPassword" name="password" placeholder="Password">
          <label for="floatingPassword">Password</label>
        </div>
        <div class="form-floating mb-3">
          <input type="text" class="form-control" id="floatingFullName" name="fullName" placeholder="Full Name">
          <label for="floatingFullName">Full Name</label>
        </div>
        <input type="submit" value="Update Profile" class="btn btn-success">
      </form>
    </div>
  </div>
</div>

