<%@ page import="java.util.ArrayList" %>
<%@ page import="kz.bitlab.techorda.db.Book" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
      <title>Title</title>
    <%@include file="head.jsp"%>
  </head>
  <body>
  <%@include file="navbar.jsp"%>
    <div class="container mt-3">
      <div class="row">
        <h4 class="text-center">
          Welcome to <%=siteName%>
        </h4>
      </div>
      <div class="row mt-3">
        <div class="col-12">
          <button type="button" class="btn btn-success btn-sm" data-bs-toggle="modal" data-bs-target="#addBook">
            +Add Book
          </button>

          <!-- Modal -->
          <div class="modal fade" id="addBook" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg">
              <div class="modal-content">
                <div class="modal-header">
                  <h1 class="modal-title fs-5" id="staticBackdropLabel">Modal title</h1>
                  <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                  <%@include file="addform.jsp"%>
                </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>

      <div class="row">
        <div class="col-12">
          <table class="table table-striped table-hover">
            <thead>
              <tr>
                <th>ID</th>
                <th>NAME</th>
                <th>AUTHOR</th>
                <th>GENRE</th>
                <th>PRICE</th>
                <th style="width: 10%">DETAILS</th>
              </tr>
            </thead>
            <tbody>
              <%
                ArrayList<Book> kitaptar = (ArrayList<Book>) request.getAttribute("knigi");
                if (kitaptar!=null){


                for (Book book : kitaptar){
              %>
                <tr>
                  <td><%=book.getId()%></td>
                  <td><%=book.getName()%></td>
                  <td><%=book.getAuthor()%></td>
                  <td><%=book.getGenre()%></td>
                  <td><%=book.getPrice()%> KZT</td>
                  <td>
                    <a class="btn btn-success btn-sm" href="/details?book_id=<%=book.getId()%>">DETAILS</a>
                  </td>
                </tr>
              <%
                  }
                }
              %>
            </tbody>
          </table>
        </div>
      </div>
    </div>

  </body>
</html>
