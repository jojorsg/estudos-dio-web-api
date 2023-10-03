package jojo.web.api.controller;

import jojo.web.api.model.UserModel;
import jojo.web.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping("/users")
    public List<UserModel> getUsers() {
        return repository.listAll();
    }
}
