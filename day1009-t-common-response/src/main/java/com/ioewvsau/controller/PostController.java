package com.ioewvsau.controller;

import com.ioewvsau.pojo.Post;
import com.ioewvsau.service.PostService;
import com.ioewvsau.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    R index(@RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "perPage", defaultValue = "10") int perPage)
    {
        List<Post> data = postService.getByPage(perPage, (page - 1) * perPage);
        return R.ok(data);
    }

    @PostMapping
    R store(@RequestBody Post post) {
        postService.save(post);
        return R.ok(HttpStatus.CREATED.value(), HttpStatus.CREATED.getReasonPhrase());
    }

    @GetMapping("/{id}")
    R show(@PathVariable long id) {
        Post data = postService.getById(id);
        return R.ok(data == null ? HttpStatus.NOT_FOUND.value() : HttpStatus.OK.value(), data);
    }

    @PutMapping("/{id}")
    R update(@PathVariable long id, @RequestBody Post post) {
        post.setId(id);
        int result = postService.update(post);
        return R.ok(result == 0 ? HttpStatus.NOT_FOUND.value() : HttpStatus.OK.value(), result);
    }

    @DeleteMapping("/{id}")
    R delete(@PathVariable long id) {
        int result = postService.deleteById(id);
        return R.ok(result == 0 ? HttpStatus.NOT_FOUND.value() : HttpStatus.OK.value(), result);
    }

}
