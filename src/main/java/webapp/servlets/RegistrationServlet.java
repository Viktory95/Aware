package webapp.servlets;

import org.hibernate.Session;
import webapp.dbutils.HibernateUtil;
import webapp.entities.UsersEntity;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.sql.Date;

@WebServlet(name = "registration")
public class RegistrationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws SecurityException, IOException {

        if (request.getParameter("password") != null && request.getParameter("password").equals(request.getParameter("rppassword"))) {
            UsersEntity usersEntity = new UsersEntity();

            usersEntity.setLogin(request.getParameter("loginname"));
            usersEntity.setName(request.getParameter("loginname"));
            usersEntity.setEmail(request.getParameter("email"));
            usersEntity.setPassword(request.getParameter("password"));
            usersEntity.setLevel(new BigInteger(String.valueOf(0)));
            usersEntity.setRegisterDate(new Date(System.currentTimeMillis()));
            usersEntity.setLastVisitDate(new Date(System.currentTimeMillis()));

            Session session = HibernateUtil.getSession();
            session.beginTransaction();
            session.save(usersEntity);
            session.getTransaction().commit();
            session.close();

        } else {
            PrintWriter out = response.getWriter();
            out.print("Пароли не совпадают! Попробуйте снова.");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws SecurityException, IOException {
        PrintWriter out = response.getWriter();
        out.print("login-name " + request.getParameter("loginname")
                + " Password " + request.getParameter("password"));
    }
}
