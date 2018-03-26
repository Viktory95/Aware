package webapp.dbutils;

import org.hibernate.Query;
import org.hibernate.Session;
import webapp.entities.UsersEntity;

import java.util.List;

public class Validate {

    public static UsersEntity usersEntity = null;

    public static UsersEntity checkUser(String login, String pass) {
        try {

            Session session = HibernateUtil.getSession();
            session.getTransaction();
            Query query = session.createQuery("from UsersEntity where login = :log and password = :pass");
            query.setParameter("log", login);
            query.setParameter("pass", pass);
            List<UsersEntity> listResult = query.list();
            usersEntity = listResult.isEmpty() ? null : listResult.get(0);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return usersEntity;
    }
}
