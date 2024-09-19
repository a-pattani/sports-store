package com.mysportsstore.controller;

import com.mysportsstore.dao.UserDAO;
import com.mysportsstore.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private UserDAO userDAO;

    public void init() {
        userDAO = new UserDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setEmail(email);

        try {
            userDAO.registerUser(newUser);
            request.setAttribute("errorMessage", "Successfully Registered. Please login.");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Registration failed. Please try again.");
        }
    
        // Forward to the register.jsp page
        request.getRequestDispatcher("register.jsp").forward(request, response);
    }
}
