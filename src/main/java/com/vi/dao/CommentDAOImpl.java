package com.vi.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.vi.dbutils.HibernateUtil;
import com.vi.entities.Citation;
import com.vi.entities.Comment;
import com.vi.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.sql.Date;

@Component
public class CommentDAOImpl extends AbstractEntityDAOImpl<Comment> implements CommentDAO {

    public CommentDAOImpl() {
        super(Comment.class);
    }

    @Override
    public Comment create(long citationId, String text, long userId, Date commentDate) {
        Session session = HibernateUtil.getSession();
        Transaction tx1 = session.beginTransaction();
        session.save(Comment.builder()
                .citation(Citation.builder().citationId(citationId).build())
                .text(text)
                .user(User.builder().userId(userId).build())
                .commentDate(commentDate)
                .build());
        tx1.commit();
        Comment comment = (Comment) session.createQuery("FROM Comment WHERE citation_id = :citation_id AND text = :text AND user_id = :user_id AND commentDate = :commentDate")
                .setParameter("citation_id", citationId)
                .setParameter("text", text)
                .setParameter("user_id", userId)
                .setParameter("commentDate", commentDate)
                .uniqueResult();
        session.close();
        return comment;
    }

    @Override
    public Comment update(long commentId, long citationId, String text, long userId, Date commentDate) {
        Session session = HibernateUtil.getSession();
        Transaction tx1 = session.beginTransaction();
        session.update(Comment.builder()
                .commentId(commentId)
                .citation(Citation.builder().citationId(citationId).build())
                .text(text)
                .user(User.builder().userId(userId).build())
                .commentDate(commentDate)
                .build());
        tx1.commit();
        session.close();
        return findById(commentId);
    }
}
