package kz.bitlab.techorda.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/todo-task5")
public class Task5Process extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fio = request.getParameter("user_full_name");
        int age = Integer.parseInt(request.getParameter("user_age"));
        String gender = request.getParameter("user_gender");

        String mainText = "Hello ";

        if (age>=18){
            mainText+="Dear ";
        }else {
            mainText+="Dude ";
        }

        if (gender.equals("muzhik")){
            mainText+="Mister ";
        } else {
            mainText+="Miss ";
        }
        mainText+=fio;

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.print("<h1>"+mainText+"</h1>");
    }
}
