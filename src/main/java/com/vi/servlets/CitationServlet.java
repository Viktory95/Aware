package com.vi.servlets;

import org.hibernate.Session;
import com.vi.dbutils.HibernateUtil;
import com.vi.dbutils.SessionKeys;
import com.vi.entities.Citation;
import com.vi.entities.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;

//@WebServlet(name = "citation")
public class CitationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws SecurityException, IOException {
//        request.setCharacterEncoding("UTF-8");
//        if (request.getParameter("citation_name") != null
//                && request.getParameter("citation_text") != null
//                && request.getSession(true)
//                .getAttribute(SessionKeys.USER_INFO) != null) {
//            Citation citation = new Citation();
//            citation.setName(request.getParameter("citation_name"));
//            citation.setText(request.getParameter("citation_text"));
//            citation.setPopularity(new BigInteger("0"));
//            citation.setUserId(User.valueOf(request.getSession(true)
//                    .getAttribute(SessionKeys.USER_INFO)).getUserId());
//            citation.setLikes(0);
//            citation.setDislikes(0);
//
//            Session session = HibernateUtil.getSession();
//            session.beginTransaction();
//            session.save(citation);
//            session.getTransaction().commit();
//            session.close();
//            try {
//                request.getRequestDispatcher("/index.jsp").forward(request, response);
//            } catch (ServletException e) {
//                e.printStackTrace();
//            }
//        } else {
//            PrintWriter out = response.getWriter();
//            out.print("Не все поля заполнены!");
//        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws SecurityException, IOException {
    }
}


