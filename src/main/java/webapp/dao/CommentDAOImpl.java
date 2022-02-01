package webapp.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import webapp.dbutils.HibernateUtil;
import webapp.entities.Citation;
import webapp.entities.Comment;
import webapp.entities.User;

import java.sql.Date;

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
        Comment comment = (Comment) session.createQuery("SELECT * FROM comment WHERE citation_id = :citation_id AND text = :text AND user_id = :user_id AND commentDate = :commentDate")
                .setParameter("citation_id", citationId)
                .setParameter("text", text)
                .setParameter("user_id", userId)
                .setParameter("commentDate", commentDate)
                .uniqueResult();
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
        return findById(commentId);
    }
}
