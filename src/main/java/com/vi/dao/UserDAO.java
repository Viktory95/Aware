package com.vi.dao;

import com.vi.entities.User;

import java.math.BigInteger;
import java.sql.Date;
import java.util.List;

public interface UserDAO extends EntityDAO<User> {
    User findById(long userId);
    List<User> getAll();
    User create(String login, String password, String email, String name, Date registerDate, Date lastVisitDate, int level);
    User update(long userId, String login, String password, String email, String name, Date registerDate, Date lastVisitDate, int level);
    void delete(long userId);
}
