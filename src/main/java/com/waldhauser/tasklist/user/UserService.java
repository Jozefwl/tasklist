package com.waldhauser.tasklist.user;

import com.waldhauser.tasklist.security.JwtMaker;
import com.waldhauser.tasklist.user.dto.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final JwtMaker jwtMaker;
    private final LoginResponse loginResponse;

    @Autowired // used to inject userRepository
    public UserService(UserRepository userRepository, JwtMaker jwtMaker) {
        this.userRepository = userRepository;
        this.jwtMaker = jwtMaker;
        this.loginResponse = null;
    }

    // ------------------ REGISTER -------------------
    public User register(String name, String password) {
        // Check if user already exists
        if (userRepository.findByName(name).isPresent()) {
            throw new IllegalStateException("Username already taken");
        }

        // save new user to database
        return userRepository.save(new User(name, password));
    }
    // ----------------------------------------------

    // ------------------- LOGIN --------------------
    public LoginResponse login(String name, String password) {
        // find user
        if (userRepository.findByName(name).isPresent()) {
            // finds user and his password
            User user = userRepository.findByName(name).get();
            if (user.getPassword().equals(password)) {
                return new LoginResponse(user.getId(), user.getName(),jwtMaker.generateToken(user));
            }
        } else { throw new IllegalStateException("Wrong username or password."); }

        // default return, likely won't ever get here
        return null;
    }
    // ----------------------------------------------
}