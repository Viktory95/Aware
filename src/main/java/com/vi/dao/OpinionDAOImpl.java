package com.vi.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.vi.dbutils.HibernateUtil;
import com.vi.entities.Citation;
import com.vi.entities.Opinion;
import com.vi.entities.User;
import org.springframework.stereotype.Component;

@Component
public class OpinionDAOImpl extends AbstractEntityDAOImpl<Opinion> implements OpinionDAO {

    public OpinionDAOImpl() {
        super(Opinion.class);
    }

    @Override
    public Opinion create(long citationId, long userId, int liked, int shared) {
        Session session = HibernateUtil.getSession();
        Transaction tx1 = session.beginTransaction();
        session.save(Opinion.builder()
                .citation(Citation.builder().citationId(citationId).build())
                .liked(liked)
                .user(User.builder().userId(userId).build())
                .shared(shared)
                .build());
        tx1.commit();
        Opinion opinion = (Opinion) session.createQuery("FROM Opinion WHERE citation_id = :citation_id AND liked = :liked AND user_id = :user_id AND shared = :shared")
                .setParameter("citation_id", citationId)
                .setParameter("liked", liked)
                .setParameter("user_id", userId)
                .setParameter("shared", shared)
                .uniqueResult();
        session.close();
        return opinion;
    }

    @Override
    public Opinion update(long opinionId, long citationId, long userId, int liked, int shared) {
        Session session = HibernateUtil.getSession();
        Transaction tx1 = session.beginTransaction();
        session.update(Opinion.builder()
                .opinionId(opinionId)
                .citation(Citation.builder().citationId(citationId).build())
                .liked(liked)
                .user(User.builder().userId(userId).build())
                .shared(shared)
                .build());
        tx1.commit();
        session.close();
        return findById(opinionId);
    }
}
