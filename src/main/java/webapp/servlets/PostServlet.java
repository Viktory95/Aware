package webapp.servlets;

import org.hibernate.Session;
import org.hibernate.Query;
import webapp.dbutils.HibernateUtil;
import webapp.dbutils.Validate;
import webapp.entities.CitationsEntity;
import webapp.entities.CommentsEntity;
import webapp.entities.DislikesEntity;
import webapp.entities.LikesEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "post")
public class PostServlet extends HttpServlet {

    public static CitationsEntity citationsEntity;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws SecurityException, IOException {

        Session session = HibernateUtil.getSession();

        LikesEntity likesEntity = new LikesEntity();
        likesEntity.setCitationId(citationsEntity.getCitationId());
        likesEntity.setUserId(Validate.usersEntity.getUserId());

        Query likesQuery = session.createQuery("from LikesEntity where citationId = :citationId and userId = :userId");
        likesQuery.setParameter("citationId", citationsEntity.getCitationId());
        likesQuery.setParameter("userId", Validate.usersEntity.getUserId());
        List<LikesEntity> likesListResult = likesQuery.list();

        DislikesEntity dislikesEntity = new DislikesEntity();
        dislikesEntity.setCitationId(citationsEntity.getCitationId());
        dislikesEntity.setUserId(Validate.usersEntity.getUserId());

        Query dislikesQuery = session.createQuery("from DislikesEntity where citationId = :citationId and userId = :userId");
        dislikesQuery.setParameter("citationId", citationsEntity.getCitationId());
        dislikesQuery.setParameter("userId", Validate.usersEntity.getUserId());
        List<DislikesEntity> dislikesListResult = dislikesQuery.list();

        if(request.getParameter("like") != null){

            if(likesListResult.isEmpty()) {
                if(!dislikesListResult.isEmpty()){
                    dislikesEntity = dislikesListResult.get(0);
                    session.beginTransaction();
                    session.delete(dislikesEntity);
                    session.getTransaction().commit();
                    citationsEntity.setDislikes(citationsEntity.getDislikes() - 1);
                }
                citationsEntity.setLikes(citationsEntity.getLikes() + 1);

                session.beginTransaction();
                session.update(citationsEntity);
                session.getTransaction().commit();
                session.beginTransaction();
                session.save(likesEntity);
                session.getTransaction().commit();
                System.out.println("LIKE");
            }
            else {
                citationsEntity.setLikes(citationsEntity.getLikes() - 1);
                likesEntity = likesListResult.get(0);

                session.beginTransaction();
                session.update(citationsEntity);
                session.getTransaction().commit();
                session.beginTransaction();
                session.delete(likesEntity);
                session.getTransaction().commit();
                System.out.println("UNLIKE");
            }
        }
        else if(request.getParameter("dislike") != null){

            if(dislikesListResult.isEmpty()) {
                if(!likesListResult.isEmpty()){
                    likesEntity = likesListResult.get(0);
                    session.beginTransaction();
                    session.delete(likesEntity);
                    session.getTransaction().commit();
                    citationsEntity.setLikes(citationsEntity.getLikes() - 1);
                }
                citationsEntity.setDislikes(citationsEntity.getDislikes() + 1);

                session.beginTransaction();
                session.update(citationsEntity);
                session.getTransaction().commit();
                session.beginTransaction();
                session.save(dislikesEntity);
                session.getTransaction().commit();
                System.out.println("DISLIKE");
            }
            else {
                citationsEntity.setDislikes(citationsEntity.getDislikes() - 1);
                dislikesEntity = dislikesListResult.get(0);

                session.beginTransaction();
                session.update(citationsEntity);
                session.getTransaction().commit();
                session.beginTransaction();
                session.delete(dislikesEntity);
                session.getTransaction().commit();
                System.out.println("UNDISLIKE");
            }
        }
        else if(request.getParameter("comment") != null){
            CommentsEntity commentsEntity = new CommentsEntity();
            commentsEntity.setCitationId(citationsEntity.getCitationId());
            commentsEntity.setUserId(Validate.usersEntity.getUserId());
            commentsEntity.setText(request.getParameter("comm"));
            commentsEntity.setCommentDate(new Date(System.currentTimeMillis()));
            session.beginTransaction();
            session.save(commentsEntity);
            session.getTransaction().commit();
            System.out.println("COMMENT");
        }
        try {
            request.getRequestDispatcher("/post.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws SecurityException, IOException {
    }

    public static List<CommentsEntity> getComments(){
        List<CommentsEntity> listResult = null;
        Session session = HibernateUtil.getSession();
        session.getTransaction();
        Query query = session.createQuery("from CommentsEntity");
        listResult = query.list();
        return listResult;
    }
}
