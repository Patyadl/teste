package com.example.curriculo.Controller;

import com.example.curriculo.Model.User;
import com.example.curriculo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id).orElse(null);
    }

    @PostMapping
    public User criarUser(@RequestBody User user) {
        return userService.criarUser(user);
    }

    @PutMapping("/{id}")
    public User atualizarUser(@PathVariable Long id, @RequestBody User userDetails) throws Exception {
        return userService.atualizarUser(id, userDetails);
    }

    @DeleteMapping("/{id}")
    public void deletarUser(@PathVariable Long id) {
        userService.deletarUser(id);
    }
}
