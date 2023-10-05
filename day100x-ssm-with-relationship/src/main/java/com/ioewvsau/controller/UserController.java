package com.ioewvsau.controller;

import com.ioewvsau.pojo.User;
import com.ioewvsau.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    List<User> index(@RequestParam(value = "page", defaultValue = "1") int page,
                     @RequestParam(value = "perPage", defaultValue = "10") int perPage)
    {
        return userService.getByPage(perPage, (page - 1) * perPage);
    }

    @PostMapping
    void store(@RequestBody User user) {
        userService.save(user);
    }

    @GetMapping("/{id}")
    User show(@PathVariable long id) {
        return userService.getById(id);
    }

    @PutMapping("/{id}")
    void update(@PathVariable long id, @RequestBody User user) {
        user.setId(id);
        userService.update(user);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable long id) {
        userService.deleteById(id);
    }

}
