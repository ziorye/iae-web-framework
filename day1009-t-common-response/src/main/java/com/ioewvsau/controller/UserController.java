package com.ioewvsau.controller;

import com.ioewvsau.pojo.User;
import com.ioewvsau.service.UserService;
import com.ioewvsau.util.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    CommonResponse index(@RequestParam(value = "page", defaultValue = "1") int page,
                         @RequestParam(value = "perPage", defaultValue = "10") int perPage)
    {
        List<User> data = userService.getByPage(perPage, (page - 1) * perPage);
        return CommonResponse.ok(data);
    }

    @PostMapping
    CommonResponse store(@RequestBody User user) {
        userService.save(user);
        return CommonResponse.ok(HttpStatus.CREATED.value(), HttpStatus.CREATED.getReasonPhrase());
    }

    @GetMapping("/{id}")
    CommonResponse show(@PathVariable long id) {
        User data = userService.getById(id);
        return CommonResponse.ok(data == null ? HttpStatus.NOT_FOUND.value() : HttpStatus.OK.value(), data);
    }

    @PutMapping("/{id}")
    CommonResponse update(@PathVariable long id, @RequestBody User user) {
        user.setId(id);
        int result = userService.update(user);
        return CommonResponse.ok(result == 0 ? HttpStatus.NOT_FOUND.value() : HttpStatus.OK.value(), result);

    }

    @DeleteMapping("/{id}")
    CommonResponse delete(@PathVariable long id) {
        int result = userService.deleteById(id);
        return CommonResponse.ok(result == 0 ? HttpStatus.NOT_FOUND.value() : HttpStatus.OK.value(), result);
    }

}
