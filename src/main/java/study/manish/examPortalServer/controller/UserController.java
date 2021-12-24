package study.manish.examPortalServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import study.manish.examPortalServer.model.Role;
import study.manish.examPortalServer.model.User;
import study.manish.examPortalServer.model.UserRole;
import study.manish.examPortalServer.service.UserService;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
//    creating user
    @PostMapping("/")
    public User createUser(@RequestBody User user) throws Exception {

        Set<UserRole> roles = new HashSet<>();

        Role role = new Role();
        role.setRoleId(45L);
        role.setRoleName("NORMAL");

        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);

        roles.add(userRole);




        return this.userService.createUser(user,roles);
    }

//    get user by user name
    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username){
        return  this.userService.getUser(username);
    }

//    delete user by the id
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId){
        this.userService.deleteUser(userId);
    }



}
