package com.vi.dao;

import com.vi.entities.Opinion;

import java.util.List;

public interface OpinionDAO extends EntityDAO<Opinion> {
    Opinion findById(long opinionId);
    List<Opinion> getAll();
    Opinion create(long citationId, long userId, int liked, int shared);
    Opinion update(long opinionId, long citationId, long userId, int liked, int shared);
    void delete(long opinionId);
}
