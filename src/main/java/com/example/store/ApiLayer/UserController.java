package com.example.store.ApiLayer;

import com.example.store.BusinessLayer.UserService;
import com.example.store.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/UserApi")
public class UserController {

    private final UserService service;

    @Autowired
    UserController(UserService service){
        this.service = service;
    }

    @GetMapping("/allUsers")
    public List<User> getAllUsers(){
        return service.getAllUsers();
    }

    @GetMapping("/selectUser/{id}")
    public User getSpecificUser(@PathVariable Long id){ return service.getSpecificUser(id); }

    @PostMapping("/addNewUser")
    public void registerNewUser(@RequestBody User user){ service.addNewUser(user); }

    @PutMapping("/updateUser/{id}")
    public void replaceUser(@PathVariable Long id, @RequestBody User user){ service.replaceUser(id, user); }
}
