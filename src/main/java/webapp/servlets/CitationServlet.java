package webapp.servlets;

import org.hibernate.Session;
import webapp.dbutils.HibernateUtil;
import webapp.dbutils.SessionKeys;
import webapp.dbutils.Validate;
import webapp.entities.CitationsEntity;
import webapp.entities.UsersEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;

@WebServlet(name = "citation")
public class CitationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws SecurityException, IOException {
        request.setCharacterEncoding("UTF-8");
        if (request.getParameter("citation_name") != null
                && request.getParameter("citation_text") != null
                && request.getSession(true)
                .getAttribute(SessionKeys.USER_INFO) != null) {
            CitationsEntity citationsEntity = new CitationsEntity();
            citationsEntity.setName(request.getParameter("citation_name"));
            citationsEntity.setText(request.getParameter("citation_text"));
            citationsEntity.setPopularity(new BigInteger("0"));
            citationsEntity.setUserId(UsersEntity.valueOf(request.getSession(true)
                    .getAttribute(SessionKeys.USER_INFO)).getUserId());
            citationsEntity.setLikes(0);
            citationsEntity.setDislikes(0);

            Session session = HibernateUtil.getSession();
            session.beginTransaction();
            session.save(citationsEntity);
            session.getTransaction().commit();
            session.close();
            try {
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            }
        } else {
            PrintWriter out = response.getWriter();
            out.print("Не все поля заполнены!");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws SecurityException, IOException {
    }
}


