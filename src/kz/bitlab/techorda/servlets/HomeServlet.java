package kz.bitlab.techorda.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.bitlab.techorda.db.Book;
import kz.bitlab.techorda.db.DBConnection;
import kz.bitlab.techorda.db.DBManager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(value = "/home.html")
public class HomeServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<Book> books = DBConnection.getBooks();

        request.setAttribute("knigi", books);

        request.getRequestDispatcher("/books.jsp").forward(request,response);




//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//        out.print("<html>");
//        out.print("<head>");
//        out.print("<link rel = 'stylesheet' type = 'text/css' href = 'https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css'");
//        out.print("<title>Books</title>");
//        out.print("</head>");
//        out.print("<body>");
//
//        out.print("<div class = 'container'>");
//
//        out.print("<form action = '/add-book' method = 'POST'>");
//        out.print("<input type = 'text' name = 'book_name'> NAME <br><br>");
//        out.print("<input type = 'text' name = 'book_author'> AUTHOR <br><br>");
//        out.print("<select name = 'book_genre'>");
//        out.print("<option>Fantasy</option>");
//        out.print("<option>Horror</option>");
//        out.print("<option>Roman</option>");
//        out.print("<option>Biography</option>");
//        out.print("<option>Action</option>");
//        out.print("</select>");
//        out.print(" GENRE <br><br>");
//        out.print("<input type = 'number' name = 'book_price'> PRICE <br><br>");
//        out.print("<button>ADD BOOK</button>");
//        out.print("</form>");
//
//        out.print("<table cellpadding = '20'>");
//        out.print("<thead>");
//        out.print("<tr>");
//        out.print("<th>ID</th>");
//        out.print("<th>NAME</th>");
//        out.print("<th>AUTHOR</th>");
//        out.print("<th>GENRE</th>");
//        out.print("<th>PRICE</th>");
//        out.print("</tr>");
//        out.print("</thead>");
//        out.print("<tbody>");
//        ArrayList<Book> books = DBManager.getBooks();
//        if(books!=null){
//            for(Book b : books){
//                out.print("<tr>");
//                out.print("<td>"+b.getId()+"</td>");
//                out.print("<td>"+b.getName()+"</td>");
//                out.print("<td>"+b.getAuthor()+"</td>");
//                out.print("<td>"+b.getGenre()+"</td>");
//                out.print("<td>"+b.getPrice()+"</td>");
//                out.print("</tr>");
//            }
//        }
//        out.print("</tbody>");
//        out.print("</table>");
//
//        out.print("</div>");
//
//        out.print("</body>");
//        out.print("</html>");


    }
}
