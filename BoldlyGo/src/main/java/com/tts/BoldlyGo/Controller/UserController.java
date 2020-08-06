package com.tts.BoldlyGo.Controller;

import java.security.Principal;
import java.util.Base64;
//import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.tts.BoldlyGo.Model.User;

import org.springframework.web.bind.annotation.RequestBody;

// import com.tts.BoldlyGo.Repository.UserRepository;

// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
 
    // private final UserRepository userRepository = null;
 
    // @RequestMapping("/user")
    // public Principal user(Principal user) {
    //   return user;
    // }
    
    // @GetMapping("/users")
    // public List<User> getUsers() {
    //     return (List<User>) userRepository.findAll();
    // }
 
    // @PostMapping("/users")
    // void addUser(@RequestBody User user) {
    //     userRepository.save(user);
    // }

    @RequestMapping("/login")
    public boolean login(@RequestBody User user) {
        return
          user.getUsername().equals("user") && user.getPassword().equals("password");
    }
	
    @RequestMapping("/user")
    public Principal user(HttpServletRequest request) {
        String authToken = request.getHeader("Authorization")
          .substring("Basic".length()).trim();
        return () ->  new String(Base64.getDecoder()
          .decode(authToken)).split(":")[0];
    }
}