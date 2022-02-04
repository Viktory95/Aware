package com.vi.servlets;

import org.hibernate.Session;
import com.vi.dbutils.HibernateUtil;
import com.vi.entities.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;

//@WebServlet(name = "registration")
public class RegistrationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws SecurityException, IOException {
//        request.setCharacterEncoding("UTF-8");
//
//        if (request.getParameter("rppassword") != null && request.getParameter("password") != null && request.getParameter("password").equals(request.getParameter("rppassword"))) {
//            try {
//                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
//                byte[] bytes = messageDigest.digest(request.getParameter("password").getBytes("UTF-8"));
//                StringBuilder stringBuilder = new StringBuilder();
//                for(byte b : bytes){
//                    stringBuilder.append(b);
//                }
//
//                User user = new User();
//
//                user.setLogin(request.getParameter("loginname"));
//                user.setName(request.getParameter("loginname"));
//                user.setEmail(request.getParameter("email"));
//                user.setPassword(stringBuilder.toString());
//                user.setLevel(new BigInteger(String.valueOf(0)));
//                user.setRegisterDate(new Date(System.currentTimeMillis()));
//                user.setLastVisitDate(new Date(System.currentTimeMillis()));
//
//                Session session = HibernateUtil.getSession();
//                session.beginTransaction();
//                session.save(user);
//                session.getTransaction().commit();
//                session.close();
//            } catch (NoSuchAlgorithmException e) {
//                e.printStackTrace();
//            }
//            try {
//                request.getRequestDispatcher("/index.jsp").forward(request, response);
//            } catch (ServletException e) {
//                e.printStackTrace();
//            }
//
//        } else {
//            response.setContentType("text/html; charset=UTF-8");
//            PrintWriter out = response.getWriter();
//            out.print("Пароли не совпадают! Попробуйте снова.");
//        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws SecurityException, IOException {
//        PrintWriter out = response.getWriter();
//        out.print("login-name " + request.getParameter("loginname")
//                + " Password " + request.getParameter("password"));
    }
}
