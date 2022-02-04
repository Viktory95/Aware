package com.vi.servlets;

import com.vi.dbutils.SessionKeys;
import com.vi.dbutils.Validate;
import com.vi.entities.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet(name = "login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws SecurityException, IOException {
//        response.setContentType("text/html; charset=UTF-8");
//        PrintWriter out = response.getWriter();
//        User user = Validate.checkUser(request.getParameter("loginname"), request.getParameter("password"));
//        if (user != null) {
//            request.getSession(true)
//                    .setAttribute(SessionKeys.USER_INFO,
//                            Validate.checkUser(request.getParameter("loginname"),
//                                    request.getParameter("password")));
//            try {
//                request.getRequestDispatcher("/index.jsp").forward(request, response);
//            } catch (ServletException e) {
//                e.printStackTrace();
//            }
//        }
//        else
//        {
//            out.println("Username or Password incorrect");
//            try {
//                request.getRequestDispatcher("/index.jsp").forward(request, response);
//            } catch (ServletException e) {
//                e.printStackTrace();
//            }
//        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws SecurityException, IOException {
//        PrintWriter out = response.getWriter();
//        out.print("login-name " + request.getParameter("loginname")
//                + " Password " + request.getParameter("password"));
    }
}

