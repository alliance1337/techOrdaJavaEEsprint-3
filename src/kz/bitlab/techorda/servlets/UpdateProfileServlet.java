package kz.bitlab.techorda.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.bitlab.techorda.db.DBConnection;
import kz.bitlab.techorda.db.User;

import java.io.IOException;

@WebServlet("/update-profile")
public class UpdateProfileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Получение новых данных из запроса
        String newPassword = request.getParameter("password");
        String newFullName = request.getParameter("fullName");

        // Получение текущего пользователя из сессии
        User currentUser = (User) request.getSession().getAttribute("currentUser");

        // Проверка, какие данные нужно обновить
        if (newPassword != null && !newPassword.isEmpty()) {
            // Обновление пароля
            currentUser.setPassword(newPassword);
        }

        if (newFullName != null && !newFullName.isEmpty()) {
            // Обновление имени
            currentUser.setFullName(newFullName);
        }

        // Обновление пользователя в базе данных
        DBConnection.updateUser(currentUser);

        // Перенаправление пользователя на страницу профиля
        response.sendRedirect("/profile");
    }
}
