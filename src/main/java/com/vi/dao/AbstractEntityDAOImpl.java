package com.vi.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.vi.dbutils.HibernateUtil;

import javax.persistence.Table;
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
        System.out.println("clazz.getAnnotation(Table.class)");
        System.out.println(clazz.getAnnotation(Table.class));
        List<T> entities = (List<T>) HibernateUtil
                .getSession()
                .createQuery("From " + clazz.getAnnotation(Table.class))
                .list();
        return entities;
    }

    @Override
    public void delete(long id) {
        Session session = HibernateUtil.getSession();
        T t = (T) HibernateUtil.getSession().get(clazz, id);
        Transaction tx1 = session.beginTransaction();
        session.delete(t);
        tx1.commit();
    }
}
