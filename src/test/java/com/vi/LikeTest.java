package com.vi;

import com.vi.dao.CitationDAO;
import com.vi.dao.LikeDAO;
import com.vi.dao.UserDAO;
import com.vi.entities.Citation;
import com.vi.entities.Like;
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
public class LikeTest {
    @Autowired
    private LikeDAO likeDAO;
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private CitationDAO citationDAO;

    @Test
    public void testLikeMapping() {
        List<Like> likes = likeDAO.getAll();
        Assertions.assertNotNull(likes, "Couldn't get any data from Like table.");

        User userPosted = userDAO.create("test", "test", "test@mail.ru", "Test", new Date(System.currentTimeMillis()), null, 0);
        Assertions.assertNotNull(userPosted, "Couldn't create new User as citation author object in DB for Like testing.");

        User userLiked = userDAO.create("test1", "test1", "test1@mail.ru", "Test1", new Date(System.currentTimeMillis()), null, 0);
        Assertions.assertNotNull(userLiked, "Couldn't create new User object in DB for Like testing.");

        Citation citation = citationDAO.create("Text test.", "Citation test name", userPosted.getUserId(), "eng");
        Assertions.assertNotNull(citation, "Couldn't create new Citation object in DB for Like testing.");

        Like like = likeDAO.create(citation.getCitationId(), userLiked.getUserId(), true, false);
        Assertions.assertNotNull(like, "Couldn't create new Like object in DB.");

        long likeId = like.getLikeId();
        like = likeDAO.update(likeId, citation.getCitationId(), userLiked.getUserId(), false, false);
        Assertions.assertNotNull(like, "Couldn't update Like object with id " + likeId + " in DB.");

        likeDAO.delete(like.getLikeId());
        citationDAO.delete(citation.getCitationId());
        userDAO.delete(userPosted.getUserId());
        userDAO.delete(userLiked.getUserId());
    }
}
