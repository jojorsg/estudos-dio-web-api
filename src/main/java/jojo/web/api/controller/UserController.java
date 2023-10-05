package jojo.web.api.controller;

import jojo.web.api.model.UserModel;
import jojo.web.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping
    public List<UserModel> getUsers() {
        return repository.listAll();
    }

    @GetMapping("/{id}")
    public UserModel getOne(@PathVariable Integer id) {
        return repository.finById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        repository.remove(id);
    }

    @PostMapping
    public void postUser(@RequestBody UserModel user) {
        repository.save(user);
    }

    @PutMapping
    public void putUser(@RequestBody UserModel user) {
        repository.save(user);
    }
}
