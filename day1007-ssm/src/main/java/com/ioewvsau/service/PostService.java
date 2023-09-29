package com.ioewvsau.service;

import com.ioewvsau.pojo.Post;

import java.util.List;

public interface PostService {
    List<Post> getAll();

    Post getById(long id);

    boolean save(Post post);

    boolean update(Post post);

    boolean deleteById(long id);
}
