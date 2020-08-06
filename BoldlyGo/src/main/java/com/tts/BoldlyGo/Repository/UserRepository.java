package com.tts.BoldlyGo.Repository;

import com.tts.BoldlyGo.Model.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
    User findByUsername(String username);
}