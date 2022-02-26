package com.vi;

import com.vi.dao.UserDAO;
import com.vi.main.Application;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

//@ExtendWith(SpringExtension.class)
@SpringBootTest(classes={Application.class})
public class HibernateTest {
    @Autowired
    private UserDAO userDAO;

    @Test
    public void testUsersGetting() {
//        Assertions.assertTrue(true);
        System.out.println("userDAO");
        System.out.println(userDAO);
        userDAO.getAll().forEach(System.out::println);
    }
}
