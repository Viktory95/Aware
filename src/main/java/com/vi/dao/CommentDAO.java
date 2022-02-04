package com.vi.dao;

import com.vi.entities.Comment;

import java.sql.Date;
import java.util.List;

public interface CommentDAO extends EntityDAO<Comment>  {
    Comment findById(long commentId);
    List<Comment> getAll();
    Comment create(long citationId, String text, long userId, Date commentDate);
    Comment update(long commentId, long citationId, String text, long userId, Date commentDate);
    void delete(long commentId);
}
