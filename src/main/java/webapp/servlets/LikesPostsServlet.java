package webapp.servlets;

import org.hibernate.Query;
import org.hibernate.Session;
import webapp.dbutils.HibernateUtil;
import webapp.dbutils.Validate;
import webapp.entities.CitationsEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

@WebServlet(name="likesposts")
public class LikesPostsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws SecurityException, IOException {
        long citationId = -1;
        Enumeration<String> cols = request.getParameterNames();
        if(cols.hasMoreElements()){
            String col = cols.nextElement();
            citationId = Long.valueOf(col.substring(0, col.length()-1));
        }

        try {

            Session session = HibernateUtil.getSession();
            session.getTransaction();
            Query query = session.createQuery("from CitationsEntity where citationId = :id");
            query.setParameter("id", citationId);
            List<CitationsEntity> listResult = query.list();
            PostServlet.citationsEntity = listResult.isEmpty() ? null : listResult.get(0);

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            request.getRequestDispatcher("/post.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws SecurityException, IOException {
    }

    public static List<CitationsEntity> getCitations(){
        List<CitationsEntity> listResult = null;
        Session session = HibernateUtil.getSession();
        session.getTransaction();
        Query query = session.createQuery("from CitationsEntity where citationId in (select citationId from LikesEntity where userId = :id)");
        query.setParameter("id", Validate.usersEntity.getUserId());
        listResult = query.list();
        return listResult;
    }
}
