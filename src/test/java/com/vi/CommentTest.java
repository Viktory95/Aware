package com.vi;

import com.vi.dao.CitationDAO;
import com.vi.dao.CommentDAO;
import com.vi.dao.UserDAO;
import com.vi.entities.Citation;
import com.vi.entities.Comment;
import com.vi.entities.User;
import com.vi.main.Application;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.Date;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {Application.class})
public class CommentTest {
    @Autowired
    private CommentDAO commentDAO;
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private CitationDAO citationDAO;

    @Test
    public void testCommentMapping() {
        List<Comment> comments = commentDAO.getAll();
        Assertions.assertNotNull(comments, "Couldn't get any data from Comment table.");

        User userPosted = userDAO.create("test", "test", "test@mail.ru", "Test", new Date(System.currentTimeMillis()), null, 0);
        Assertions.assertNotNull(userPosted, "Couldn't create new User as citation author object in DB for Comment testing.");

        Citation citation = citationDAO.create("Text test.", "Citation test name", userPosted.getUserId(), "eng");
        Assertions.assertNotNull(citation, "Couldn't create new Citation object in DB for Comment testing.");

        Comment comment = commentDAO.create(citation.getCitationId(), "Test comment", userPosted.getUserId(), new Date(System.currentTimeMillis()));
        Assertions.assertNotNull(comment, "Couldn't create new Comment object in DB.");

        long commentId = comment.getCommentId();
        comment = commentDAO.update(commentId, citation.getCitationId(), "Test comment1", userPosted.getUserId(), new Date(System.currentTimeMillis()));
        Assertions.assertNotNull(comment, "Couldn't update Comment object with id " + commentId + " in DB.");
        commentDAO.delete(comment.getCommentId());
        citationDAO.delete(citation.getCitationId());
        userDAO.delete(userPosted.getUserId());
    }
}
