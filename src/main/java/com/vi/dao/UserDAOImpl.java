package com.vi.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.vi.dbutils.HibernateUtil;
import com.vi.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.math.BigInteger;
import java.sql.Date;

@Component
public class UserDAOImpl extends AbstractEntityDAOImpl<User> implements UserDAO {

    public UserDAOImpl() {
        super(User.class);
    }

    @Override
    public User create(String login, String password, String email, String name, Date registerDate, Date lastVisitDate, int level) {
        Session session = HibernateUtil.getSession();
        Transaction tx1 = session.beginTransaction();
        session.save(User.builder()
                .login(login)
                .password(password)
                .email(email)
                .name(name)
                .registerDate(registerDate)
                .lastVisitDate(lastVisitDate)
                .level(BigInteger.valueOf(level))
                .build());
        tx1.commit();
        User user = (User) session.createQuery("FROM User WHERE login = :login AND email = :email AND name = :name")
                .setParameter("login", login)
                .setParameter("email", email)
                .setParameter("name", name)
                .uniqueResult();
        session.close();
        return user;
    }

    @Override
    public User update(long userId, String login, String password, String email, String name, Date registerDate, Date lastVisitDate, int level) {
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
                .level(BigInteger.valueOf(level))
                .build());
        tx1.commit();
        session.close();
        return findById(userId);
    }
}
