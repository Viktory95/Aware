package com.vi.dao;

import com.vi.entities.Like;

import java.util.List;

public interface LikeDAO extends EntityDAO<Like> {
    Like findById(long likeId);
    List<Like> getAll();
    Like create(long citationId, long userId, boolean isLike, boolean isShared);
    Like update(long likeId, long citationId, long userId, boolean isLike, boolean isShared);
    void delete(long likeId);
}
