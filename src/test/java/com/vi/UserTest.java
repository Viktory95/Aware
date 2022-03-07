package com.vi;

import com.vi.dao.UserDAO;
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
public class UserTest {
    @Autowired
    private UserDAO userDAO;

    @Test
    public void testUserMapping() {
        List<User> users = userDAO.getAll();
        Assertions.assertNotNull(users, "Couldn't get any data from User table.");

        User user = userDAO.create("test", "test", "test@mail.ru", "Test", new Date(System.currentTimeMillis()), null, 0);
        Assertions.assertNotNull(user, "Couldn't create new User object in DB.");

        long userId = user.getUserId();
        user = userDAO.update(userId, "test1", "test1", "test1@mail.ru", "Test1", user.getRegisterDate(), null, 1);
        Assertions.assertNotNull(user, "Couldn't update User object with id " + userId + " in DB.");

        userDAO.delete(user.getUserId());
    }
}
