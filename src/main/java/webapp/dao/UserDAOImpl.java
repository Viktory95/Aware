package webapp.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import webapp.dbutils.HibernateUtil;
import webapp.entities.User;

import java.math.BigInteger;
import java.sql.Date;

public class UserDAOImpl extends AbstractEntityDAOImpl<User> implements UserDAO {

    public UserDAOImpl() {
        super(User.class);
    }

    @Override
    public User create(String login, String password, String email, String name, Date registerDate, Date lastVisitDate, BigInteger level) {
        Session session = HibernateUtil.getSession();
        Transaction tx1 = session.beginTransaction();
        session.save(User.builder()
                .login(login)
                .password(password)
                .email(email)
                .name(name)
                .registerDate(registerDate)
                .lastVisitDate(lastVisitDate)
                .level(level)
                .build());
        tx1.commit();
        User user = (User) session.createQuery("SELECT * FROM user WHERE login = :login AND email = :email AND name = :name")
                .setParameter("login", login)
                .setParameter("email", email)
                .setParameter("name", name)
                .uniqueResult();
        return user;
    }

    @Override
    public User update(long userId, String login, String password, String email, String name, Date registerDate, Date lastVisitDate, BigInteger level) {
        Session session = HibernateUtil.getSession();
        Transaction tx1 = session.beginTransaction();
        session.update(User.builder()
                .userId(userId)
                .login(login)
                .password(password)
                .email(email)
                .name(name)
                .registerDate(registerDate)
                .lastVisitDate(lastVisitDate)
                .level(level)
                .build());
        tx1.commit();
        return findById(userId);
    }
}
