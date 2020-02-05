package com.hasan.intro.to.spring.controller;

import com.hasan.intro.to.spring.entity.User;
import com.hasan.intro.to.spring.model.UserDTO;
import com.hasan.intro.to.spring.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity createUser(@RequestBody @Valid UserDTO request){
        userService.createUser(request);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    public List<UserDTO> getUsers(){ return userService.getAllUsers(); }

    @GetMapping(value = "/count")
    public long getNumberOfUsers(){ return userService.getNumberOfUsers(); }

    @GetMapping(value = "/{id}")
    public UserDTO getById(@PathVariable Long id){return userService.getById(id);    }

    @PutMapping(value = "/{id}")
    public void editUser(@RequestBody @Valid UserDTO request, @PathVariable Long id){ userService.editUser(request,id);  }

    @DeleteMapping(value = "/{id}")
public  void  deleteUSer( @PathVariable Long id){userService.deleteUser(id);}


}
