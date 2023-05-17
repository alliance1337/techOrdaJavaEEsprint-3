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
        // Ваш код для обработки GET-запроса на редактирование профиля
        // Здесь вы можете отобразить форму редактирования профиля или выполнить другую логику
        // в соответствии с вашими требованиями
        // Например:
        request.getRequestDispatcher("/profile-edit.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Ваш код для обработки POST-запроса на редактирование профиля
        // Здесь вы можете получить данные из формы и выполнить обновление профиля
        // Например:
        String newPassword = request.getParameter("password");
        String newFullName = request.getParameter("fullName");

        // Обновление профиля в базе данных или выполнение другой логики
        // ...

        // Перенаправление пользователя на страницу профиля
        response.sendRedirect("/profile");
    }
}

