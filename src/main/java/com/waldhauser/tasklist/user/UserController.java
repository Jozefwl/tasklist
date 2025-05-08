package com.waldhauser.tasklist.user;

import com.waldhauser.tasklist.user.dto.LoginResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "auth")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.register(user.getName(), user.getPassword());
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody User user) {
        return userService.login(user.getName(), user.getPassword());
    }


}