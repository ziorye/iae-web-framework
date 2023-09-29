package com.ioewvsau.controller;

import com.ioewvsau.pojo.Post;
import com.ioewvsau.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
//@ResponseBody
@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    PostService postService;

    @GetMapping
    List<Post> index() {
        return postService.getAll();
    }

    @PostMapping
    void store(@RequestBody Post post) {
        postService.save(post);
    }

    @GetMapping("/{id}")
    Post show(@PathVariable long id) {
        return postService.getById(id);
    }

    @PutMapping("/{id}")
    void update(@PathVariable long id, @RequestBody Post post) {
        post.setId(id);
        postService.update(post);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable long id) {
        postService.deleteById(id);
    }

}
