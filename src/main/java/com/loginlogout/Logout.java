package com.loginlogout;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class Logout extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] ck = req.getCookies();
        for (Cookie c : ck){
            c.setMaxAge(0);
            resp.addCookie(c);
        }
        resp.sendRedirect("login.html");
    }
}
