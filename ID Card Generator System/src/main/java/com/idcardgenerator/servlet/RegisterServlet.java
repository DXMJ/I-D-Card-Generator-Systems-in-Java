package com.idcardgenerator.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.idcardgenerator.db.DatabaseConnection;

public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String bloodGroup = request.getParameter("blood_group");
        String registerNumber = request.getParameter("register_number");
        String department = request.getParameter("department");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO users (name, age, blood_group, register_number, department, username, password) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, name);
            pstmt.setInt(2, Integer.parseInt(age));
            pstmt.setString(3, bloodGroup);
            pstmt.setString(4, registerNumber);
            pstmt.setString(5, department);
            pstmt.setString(6, username);
            pstmt.setString(7, password);
            pstmt.executeUpdate();
            response.sendRedirect("index.jsp?registered=1");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
