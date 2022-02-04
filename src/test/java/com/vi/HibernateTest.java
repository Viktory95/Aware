package com.vi;

import com.vi.dao.UserDAO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

@SpringBootTest
@ComponentScan({"com.vi.dao"})
public class HibernateTest {
    @Autowired
    private UserDAO userDAO;

    @Test
    public void testUsersGetting() {
        userDAO.getAll().forEach(System.out::println);
    }
}
