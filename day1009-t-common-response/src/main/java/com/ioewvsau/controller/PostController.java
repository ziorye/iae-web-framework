package com.ioewvsau.controller;

import com.ioewvsau.pojo.Post;
import com.ioewvsau.service.PostService;
import com.ioewvsau.util.CommonResponse;
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
    CommonResponse index(@RequestParam(value = "page", defaultValue = "1") int page,
                     @RequestParam(value = "perPage", defaultValue = "10") int perPage)
    {
        List<Post> data = postService.getByPage(perPage, (page - 1) * perPage);
        return CommonResponse.ok(data);
    }

    @PostMapping
    CommonResponse store(@RequestBody Post post) {
        postService.save(post);
        return CommonResponse.ok(HttpStatus.CREATED.value(), HttpStatus.CREATED.getReasonPhrase());
    }

    @GetMapping("/{id}")
    CommonResponse show(@PathVariable long id) {
        Post data = postService.getById(id);
        return CommonResponse.ok(data == null ? HttpStatus.NOT_FOUND.value() : HttpStatus.OK.value(), data);
    }

    @PutMapping("/{id}")
    CommonResponse update(@PathVariable long id, @RequestBody Post post) {
        post.setId(id);
        int result = postService.update(post);
        return CommonResponse.ok(result == 0 ? HttpStatus.NOT_FOUND.value() : HttpStatus.OK.value(), result);
    }

    @DeleteMapping("/{id}")
    CommonResponse delete(@PathVariable long id) {
        int result = postService.deleteById(id);
        return CommonResponse.ok(result == 0 ? HttpStatus.NOT_FOUND.value() : HttpStatus.OK.value(), result);
    }

}
