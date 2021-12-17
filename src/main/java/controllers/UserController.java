package controllers;


import businessObjects.User;
import businessObjects.UserRequest;
import dataLayer.daoImplements.UserDaoImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Component
@ComponentScan("dataLayer.daoImplements")
@RestController
public class UserController {

    @Autowired
    private UserDaoImplement userDaoImplement;

    @GetMapping("/user")
    public List<User> getUser(@RequestParam(name = "namePrefix") String namePrefix, @RequestParam(name = "olderThan") float olderThan) {
        return userDaoImplement.getUserList(namePrefix, olderThan);
    }

    @PostMapping("/user/save")
    public int addNewUser(@RequestBody UserRequest userRequest) {
        return userDaoImplement.addUser(userRequest);
    }

    @DeleteMapping("/user/delete/{userId}")
    public void deleteUser(@PathVariable(name = "userId") int id) {
        userDaoImplement.deleteByid(id);
    }
}
