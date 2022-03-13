package com.vi.dao;

import com.vi.dbutils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AbstractEntityDAOImpl<T> implements EntityDAO<T> {
    private Class clazz;

    public AbstractEntityDAOImpl(Class clazz) {
        this.clazz = clazz;
    }

    @Override
    public T findById(long id) {
        return (T) HibernateUtil.getSession().get(clazz, id);
    }

    @Override
    public List<T> getAll() {
        Session session = HibernateUtil.getSession();
        List<T> entities = (List<T>) session
                .createQuery("From " + clazz.getSimpleName())
                .list();
        session.close();
        return entities;
    }

    @Override
    public void delete(long id) {
        //TODO: find out what is CriteriaDelete and if I can use it here
        Session session = HibernateUtil.getSession();
        T t = (T) session.get(clazz, id);
        Transaction tx1 = session.beginTransaction();
        session.delete(t);
        tx1.commit();
        session.close();
    }
}
