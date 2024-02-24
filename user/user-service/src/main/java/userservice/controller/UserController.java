package userservice.controller;


import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import userservice.dto.UpdateDTO;
import userservice.dto.UserDTO;
import userservice.model.User;
import userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String register(@RequestBody User user) {

        User registeredUser = userService.register(user);
        if (registeredUser != null) {
            return "success";
        } else {
            return "failed";
        }
    }


    @PostMapping("/login")
    public String login(@RequestBody User user) {
        boolean loginUser = userService.login(user.getUsername(), user.getPassword());
        if (loginUser) {
            return "success";
        } else {
            return "failed";
        }


    }

    @GetMapping("/")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout() {
        SecurityContextHolder.clearContext();
        return ResponseEntity.status(HttpStatus.OK).body("logged out");
    }


    @PutMapping("/update")
    public String updatePassword(@RequestBody UpdateDTO user) {
        if (userService.updatePassword(user.getUsername(), user.getPassword(), user.getNewPassword())) {
            return "success";
        }
        else {
            return "failed";
        }
    }
}
