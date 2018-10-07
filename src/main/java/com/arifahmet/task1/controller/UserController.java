package com.arifahmet.task1.controller;


import com.arifahmet.task1.domain.User;
import com.arifahmet.task1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@RestController
@RequestMapping("/user")
@EnableSwagger2
public class UserController {

    @Autowired
    private UserService userService;

    @CrossOrigin
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity getUsersByName(@RequestParam(value ="name",required = true) String name) {
        List<User> list = userService.getUsersByName(name);
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity addUser(@Validated @ModelAttribute User user) {
        user = userService.addUser(user);

        return new ResponseEntity(user, HttpStatus.OK);
    }

}
