package webapp.dbutils;

import org.hibernate.Query;
import org.hibernate.Session;
import webapp.entities.Citation;
import webapp.entities.User;

import java.security.MessageDigest;
import java.util.List;

public class Validate {

    public static User checkUser(String login, String pass) {
        User user = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] bytes = messageDigest.digest(pass.getBytes("UTF-8"));
            StringBuilder stringBuilder = new StringBuilder();
            for(byte b : bytes){
                stringBuilder.append(b);
            }
            Session session = HibernateUtil.getSession();
            session.getTransaction();
            Query query = session.createQuery("from UsersEntity where login = :log and password = :pass");
            query.setParameter("log", login);
            query.setParameter("pass", stringBuilder.toString());
            List<User> listResult = query.list();
            user = listResult.isEmpty() ? null : listResult.get(0);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public static String getUserName(long userId){
        String userName = "";
        try {

            Session session = HibernateUtil.getSession();
            session.getTransaction();
            Query query = session.createQuery("from UsersEntity where userId = :id");
            query.setParameter("id", userId);
            List<User> listResult = query.list();
            userName = listResult.isEmpty() ? "" : listResult.get(0).getName();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return userName;
    }

    public static Citation getDayCitation(){
        Citation citation =  new Citation();
        try {

            Session session = HibernateUtil.getSession();
            session.getTransaction();
            Query query = session.createQuery("from CitationsEntity order by likes desc ");
            List<Citation> listResult = query.list();
            citation = listResult.isEmpty() ? new Citation() : listResult.get(0);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return citation;
    }
}
