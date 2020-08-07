  
package com.tts.BoldlyGo.Service;

import com.tts.BoldlyGo.Model.User;
import com.tts.BoldlyGo.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService{
    @Autowired
    private UserRepository userRepository;

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public void saveNew(User user) {
        //user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public void saveExisting(User user) {
        userRepository.save(user);
    }

    // public User getLoggedInUser() {
    //     return findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
    // }
    
}