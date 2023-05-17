package kz.bitlab.techorda.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.bitlab.techorda.db.Author;
import kz.bitlab.techorda.db.DBConnection;
import kz.bitlab.techorda.db.User;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/add-book-page")
public class AddBookPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = (User) request.getSession().getAttribute("currentUser");
        if (user!=null) {
            if (user.getRole()==1){


            ArrayList<Author> authors = DBConnection.getAuthors();
            request.setAttribute("avtory", authors);
            request.getRequestDispatcher("/addbook.jsp").forward(request, response);
            }else {
                request.getRequestDispatcher("/403.jsp").forward(request,response);
            }
        }else {
            response.sendRedirect("/login");
        }
    }
}
