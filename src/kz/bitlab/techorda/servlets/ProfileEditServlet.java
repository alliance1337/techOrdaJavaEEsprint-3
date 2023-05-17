package kz.bitlab.techorda.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.bitlab.techorda.db.DBConnection;
import kz.bitlab.techorda.db.User;

import java.io.IOException;
@WebServlet("/profile-edit")
public class ProfileEditServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        User currentUser = (User) request.getSession().getAttribute("currentUser");
        if (currentUser!=null) {
            request.getRequestDispatcher("/profile-edit.jsp").forward(request, response);
        }else {
            response.sendRedirect("/login");
        }

    }
}

