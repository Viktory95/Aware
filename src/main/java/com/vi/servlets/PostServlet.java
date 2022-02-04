package com.vi.servlets;

import org.hibernate.Session;
import org.hibernate.Query;
import com.vi.dbutils.HibernateUtil;
import com.vi.dbutils.SessionKeys;
import com.vi.entities.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

//@WebServlet(name = "post")
public class PostServlet extends HttpServlet {

    public static Citation citation;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws SecurityException, IOException {

//        request.setCharacterEncoding("UTF-8");
//
//        Session session = HibernateUtil.getSession();
//
//        Like like = new Like();
//        like.setCitationId(citation.getCitationId());
//        like.setUserId(User.valueOf(request.getSession(true)
//                .getAttribute(SessionKeys.USER_INFO)).getUserId());
//
//        Query likesQuery = session.createQuery("from LikesEntity where citationId = :citationId and userId = :userId");
//        likesQuery.setParameter("citationId", citation.getCitationId());
//        likesQuery.setParameter("userId", User.valueOf(request.getSession(true)
//                .getAttribute(SessionKeys.USER_INFO)).getUserId());
//        List<Like> likesListResult = likesQuery.list();
//
//        DislikesEntity dislikesEntity = new DislikesEntity();
//        dislikesEntity.setCitationId(citation.getCitationId());
//        dislikesEntity.setUserId(User.valueOf(request.getSession(true)
//                .getAttribute(SessionKeys.USER_INFO)).getUserId());
//
//        Query dislikesQuery = session.createQuery("from DislikesEntity where citationId = :citationId and userId = :userId");
//        dislikesQuery.setParameter("citationId", citation.getCitationId());
//        dislikesQuery.setParameter("userId", User.valueOf(request.getSession(true)
//                .getAttribute(SessionKeys.USER_INFO)).getUserId());
//        List<DislikesEntity> dislikesListResult = dislikesQuery.list();
//
//        if(request.getParameter("like") != null){
//
//            if(likesListResult.isEmpty()) {
//                if(!dislikesListResult.isEmpty()){
//                    dislikesEntity = dislikesListResult.get(0);
//                    session.beginTransaction();
//                    session.delete(dislikesEntity);
//                    session.getTransaction().commit();
//                    citation.setDislikes(citation.getDislikes() - 1);
//                }
//                citation.setLikes(citation.getLikes() + 1);
//
//                session.beginTransaction();
//                session.update(citation);
//                session.getTransaction().commit();
//                session.beginTransaction();
//                session.save(like);
//                session.getTransaction().commit();
//                System.out.println("LIKE");
//            }
//            else {
//                citation.setLikes(citation.getLikes() - 1);
//                like = likesListResult.get(0);
//
//                session.beginTransaction();
//                session.update(citation);
//                session.getTransaction().commit();
//                session.beginTransaction();
//                session.delete(like);
//                session.getTransaction().commit();
//                System.out.println("UNLIKE");
//            }
//        }
//        else if(request.getParameter("dislike") != null){
//
//            if(dislikesListResult.isEmpty()) {
//                if(!likesListResult.isEmpty()){
//                    like = likesListResult.get(0);
//                    session.beginTransaction();
//                    session.delete(like);
//                    session.getTransaction().commit();
//                    citation.setLikes(citation.getLikes() - 1);
//                }
//                citation.setDislikes(citation.getDislikes() + 1);
//
//                session.beginTransaction();
//                session.update(citation);
//                session.getTransaction().commit();
//                session.beginTransaction();
//                session.save(dislikesEntity);
//                session.getTransaction().commit();
//                System.out.println("DISLIKE");
//            }
//            else {
//                citation.setDislikes(citation.getDislikes() - 1);
//                dislikesEntity = dislikesListResult.get(0);
//
//                session.beginTransaction();
//                session.update(citation);
//                session.getTransaction().commit();
//                session.beginTransaction();
//                session.delete(dislikesEntity);
//                session.getTransaction().commit();
//                System.out.println("UNDISLIKE");
//            }
//        }
//        else if(request.getParameter("comment") != null){
//            Comment comment = new Comment();
//            comment.setCitationId(citation.getCitationId());
//            comment.setUserId(User.valueOf(request.getSession(true)
//                    .getAttribute(SessionKeys.USER_INFO)).getUserId());
//            comment.setText(request.getParameter("comm"));
//            comment.setCommentDate(new Date(System.currentTimeMillis()));
//            session.beginTransaction();
//            session.save(comment);
//            session.getTransaction().commit();
//            System.out.println("COMMENT");
//        }
//        try {
//            request.getRequestDispatcher("/post.jsp").forward(request, response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        }
//        finally {
//            session.close();
//        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws SecurityException, IOException {
    }

    public static List<Comment> getComments(){
        List<Comment> listResult = null;
//        Session session = HibernateUtil.getSession();
//        session.getTransaction();
//        Query query = session.createQuery("from CommentsEntity where citationId = :id");
//        query.setParameter("id", citation.getCitationId());
//        listResult = query.list();
        return listResult;
    }

}
