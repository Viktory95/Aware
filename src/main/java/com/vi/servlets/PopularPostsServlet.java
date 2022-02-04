package com.vi.servlets;

import org.hibernate.Query;
import org.hibernate.Session;
import com.vi.dbutils.HibernateUtil;
import com.vi.entities.Citation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

//@WebServlet(name = "popularposts")
public class PopularPostsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws SecurityException, IOException {
//        long citationId = -1;
//        Enumeration<String> cols = request.getParameterNames();
//        if(cols.hasMoreElements()){
//            String col = cols.nextElement();
//            citationId = Long.valueOf(col.substring(0, col.length()-1));
//        }
//
//        try {
//
//            Session session = HibernateUtil.getSession();
//            session.getTransaction();
//            Query query = session.createQuery("from CitationsEntity where citationId = :id");
//            query.setParameter("id", citationId);
//            List<Citation> listResult = query.list();
//            PostServlet.citation = listResult.isEmpty() ? null : listResult.get(0);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        try {
//            request.getRequestDispatcher("/post.jsp").forward(request, response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws SecurityException, IOException {
    }

    public static List<Citation> getCitations(){
        List<Citation> listResult = null;
//        Session session = HibernateUtil.getSession();
//        session.getTransaction();
//        Query query = session.createQuery("from CitationsEntity where likes > 0 order by likes desc");
//        listResult = query.list();
        return listResult;
    }
}
