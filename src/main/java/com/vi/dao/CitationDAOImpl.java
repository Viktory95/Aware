package com.vi.dao;

import com.vi.dbutils.HibernateUtil;
import com.vi.entities.Citation;
import com.vi.entities.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

@Component
public class CitationDAOImpl extends AbstractEntityDAOImpl<Citation> implements CitationDAO {

    public CitationDAOImpl() {
        super(Citation.class);
    }

    @Override
    public Citation create(String text, String name, long userId, String language) {
        Session session = HibernateUtil.getSession();
        Transaction tx1 = session.beginTransaction();
        session.save(Citation.builder()
                .text(text)
                .name(name)
                .user(User.builder().userId(userId).build())
                .language(language)
                .build());
        tx1.commit();
        Citation citation = (Citation) session.createQuery("FROM Citation WHERE text = :text AND name = :name AND user_id = :user_id AND language = :language")
                .setParameter("text", text)
                .setParameter("name", name)
                .setParameter("user_id", userId)
                .setParameter("language", language)
                .uniqueResult();
        return citation;
    }

    @Override
    public Citation update(long citationId, String text, String name, long userId, String language) {
        Session session = HibernateUtil.getSession();
        Transaction tx1 = session.beginTransaction();
        session.update(Citation.builder()
                .citationId(citationId)
                .text(text)
                .name(name)
                .user(User.builder().userId(userId).build())
                .language(language)
                .build());
        tx1.commit();
        return findById(citationId);
    }
}
