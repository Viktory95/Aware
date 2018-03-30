package webapp.dbutils;

import org.hibernate.Query;
import org.hibernate.Session;
import webapp.entities.CitationsEntity;
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

    public static String getUserName(long userId){
        String userName = "";
        try {

            Session session = HibernateUtil.getSession();
            session.getTransaction();
            Query query = session.createQuery("from UsersEntity where userId = :id");
            query.setParameter("id", userId);
            List<UsersEntity> listResult = query.list();
            userName = listResult.isEmpty() ? "" : listResult.get(0).getName();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return userName;
    }

    public static CitationsEntity getDayCitation(){
        CitationsEntity citationsEntity =  new CitationsEntity();
        try {

            Session session = HibernateUtil.getSession();
            session.getTransaction();
            Query query = session.createQuery("from CitationsEntity order by likes desc ");
            List<CitationsEntity> listResult = query.list();
            citationsEntity = listResult.isEmpty() ? new CitationsEntity() : listResult.get(0);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return citationsEntity;
    }
}
