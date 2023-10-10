package com.ioewvsau.controller;

import com.ioewvsau.pojo.User;
import com.ioewvsau.service.UserService;
import com.ioewvsau.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    R index(@RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "perPage", defaultValue = "10") int perPage)
    {
        List<User> data = userService.getByPage(perPage, (page - 1) * perPage);
        return R.ok(data);
    }

    @PostMapping
    R store(@Validated @RequestBody User user) {
        userService.save(user);
        return R.ok(HttpStatus.CREATED.value(), HttpStatus.CREATED.getReasonPhrase());
    }

    @GetMapping("/{id}")
    R show(@PathVariable long id) {
        User data = userService.getById(id);
        return R.ok(data == null ? HttpStatus.NOT_FOUND.value() : HttpStatus.OK.value(), data);
    }

    @PutMapping("/{id}")
    R update(@PathVariable long id, @RequestBody User user) {
        user.setId(id);
        int result = userService.update(user);
        return R.ok(result == 0 ? HttpStatus.NOT_FOUND.value() : HttpStatus.OK.value(), result);

    }

    @DeleteMapping("/{id}")
    R delete(@PathVariable long id) {
        int result = userService.deleteById(id);
        return R.ok(result == 0 ? HttpStatus.NOT_FOUND.value() : HttpStatus.OK.value(), result);
    }

}
