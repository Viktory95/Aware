package com.vi.dao;

import java.util.List;

public interface EntityDAO<T> {
    T findById(long id);
    List<T> getAll();
    void delete(long id);
}
