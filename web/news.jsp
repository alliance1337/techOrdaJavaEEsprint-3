<%@ page import="java.util.ArrayList" %>
<%@ page import="kz.bitlab.techorda.db.Book" %>
<%@ page import="kz.bitlab.techorda.db.News" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <%@include file="head.jsp"%>
</head>
<body>
<%@include file="navbar.jsp"%>
<div class="container mt-3">
  <div class="row mt-3">
    <div class="col-12">
      <%
        ArrayList<News> news = (ArrayList<News>) request.getAttribute("news");
        if(news!=null){
          for(News n : news){
      %>
      <div class="p-5 mb-3" style="background-color: #dee1df;">
        <a href="/news-details?id=<%=n.getId()%>">
          <h3><%=n.getTitle()%></h3>
        </a>
        <p><%=n.getContent()%></p>
        <p>
          Posted by <strong><%=n.getUser().getFullName()%></strong>
          At <strong><%=n.getPostDate()%></strong>
        </p>
      </div>
      <%
          }
        }
      %>
    </div>
  </div>
</div>
</body>
</html>