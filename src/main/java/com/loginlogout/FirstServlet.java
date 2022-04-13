package com.loginlogout;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class FirstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie ck[] = req.getCookies();
        int value = 0;
        for (Cookie c:ck){
            if(c.getName().equals("status")){
                value = 1;
            }
        }
        if(value==1){
            resp.sendRedirect("profile");
        }
        else {
            resp.sendRedirect("login.html");
        }
    }
}
