package kz.bitlab.techorda.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/task6")
public class Task6Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        req.setCharacterEncoding("UTF-8");
//        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.print("<form action = '/task6-process' method = 'get'>");
        out.print("<input type = 'text' name = 'full_name'> FULL NAME <br><br>");
        out.print("<input type = 'number' name = 'exam'> POINTS <br><br>");
        out.print("<button>SUBMIT EXAM</button>");
        out.print("</form>");
    }
}
