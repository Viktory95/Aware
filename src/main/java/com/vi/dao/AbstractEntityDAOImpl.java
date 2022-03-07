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
        List<T> entities = (List<T>) HibernateUtil
                .getSession()
                .createQuery("From " + clazz.getSimpleName())
                .list();
        return entities;
    }

    @Override
    public void delete(long id) {
        //TODO: find out what is CriteriaDelete and if I can use it here
        Session session = HibernateUtil.getSession();
        T t = (T) HibernateUtil.getSession().get(clazz, id);
        Transaction tx1 = session.beginTransaction();
        session.delete(t);
        tx1.commit();
    }
}
