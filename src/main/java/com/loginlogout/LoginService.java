package com.loginlogout;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class LoginService extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String userName = req.getParameter("email");
        String password = req.getParameter("password");
        String rememberMe = req.getParameter("rememberme");


        if(userName.equals("a@gmail.com") && password.equals("123")){
            if(compare(rememberMe,"Selected")){
                Cookie ck = new Cookie("username",userName);
                ck.setMaxAge(60*60*24*365);
                resp.addCookie(ck);

                Cookie ck2 = new Cookie("status","true");
                ck2.setMaxAge(60*60*24*365);
                resp.addCookie(ck2);
            }
            resp.sendRedirect("profile");
        }
        else {
            out.println("email and password not macth...");
            RequestDispatcher rd = req.getRequestDispatcher("login.html");
            rd.include(req,resp);
        }
    }
    public static boolean compare(String str1, String str2)
    {
        return (str1==null ? str2==null : str1.equals(str2));
    }
}
