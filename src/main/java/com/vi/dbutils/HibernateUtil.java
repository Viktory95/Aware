package com.vi.dbutils;


import com.vi.entities.Citation;
import com.vi.entities.Comment;
import com.vi.entities.Opinion;
import com.vi.entities.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        try {
            Configuration configuration = new Configuration()
                    .addAnnotatedClass(User.class)
                    .addAnnotatedClass(Citation.class)
                    .addAnnotatedClass(Comment.class)
                    .addAnnotatedClass(Opinion.class)
                    .configure();

            sessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return sessionFactory.openSession();
    }
}
