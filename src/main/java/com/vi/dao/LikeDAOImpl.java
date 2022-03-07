package com.vi.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.vi.dbutils.HibernateUtil;
import com.vi.entities.Citation;
import com.vi.entities.Like;
import com.vi.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;

@Component
public class LikeDAOImpl extends AbstractEntityDAOImpl<Like> implements LikeDAO {

    public LikeDAOImpl() {
        super(Like.class);
    }

    @Override
    public Like create(long citationId, long userId, boolean isLike, boolean isShared) {
        Session session = HibernateUtil.getSession();
        Transaction tx1 = session.beginTransaction();
        session.save(Like.builder()
                .citation(Citation.builder().citationId(citationId).build())
                .isLike(isLike)
                .user(User.builder().userId(userId).build())
                .isShared(isShared)
                .build());
        tx1.commit();
        Like like = (Like) session.createQuery("FROM Like WHERE citation_id = :citation_id AND is_like = :is_like AND user_id = :user_id AND is_shared = :is_shared")
                .setParameter("citation_id", citationId)
                .setParameter("is_like", isLike)
                .setParameter("user_id", userId)
                .setParameter("is_shared", isShared)
                .uniqueResult();
        return like;
    }

    @Override
    public Like update(long likeId, long citationId, long userId, boolean isLike, boolean isShared) {
        Session session = HibernateUtil.getSession();
        Transaction tx1 = session.beginTransaction();
        session.update(Like.builder()
                .likeId(likeId)
                .citation(Citation.builder().citationId(citationId).build())
                .isLike(isLike)
                .user(User.builder().userId(userId).build())
                .isShared(isShared)
                .build());
        tx1.commit();
        return findById(likeId);
    }
}
