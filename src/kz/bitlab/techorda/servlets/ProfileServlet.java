package kz.bitlab.techorda.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.bitlab.techorda.db.User;

import java.io.IOException;

@WebServlet(value = "/profile")
public class ProfileServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        HttpSession session = request.getSession();
//        User currentUser = (User) session.getAttribute("currentUser");
        //тоже самое что 24 строка

        User currentUser = (User) request.getSession().getAttribute("currentUser");
        if (currentUser!=null) {
            request.getRequestDispatcher("/profile.jsp").forward(request, response);
        }else {
            response.sendRedirect("/login");
        }
    }


}
