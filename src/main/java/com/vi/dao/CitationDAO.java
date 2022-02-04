package com.vi.dao;

import com.vi.entities.Citation;

import java.util.List;

public interface CitationDAO extends EntityDAO<Citation> {
    Citation findById(long citationId);
    List<Citation> getAll();
    Citation create(String text, String name, long userId, String language);
    Citation update(long citationId, String text, String name, long userId, String language);
    void delete(long citationId);
}
