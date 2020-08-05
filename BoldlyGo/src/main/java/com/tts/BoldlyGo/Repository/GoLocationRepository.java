package com.tts.BoldlyGo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

import java.util.List;

import com.tts.BoldlyGo.Model.GoLocation;
import com.tts.BoldlyGo.Model.User;

public interface GoLocationRepository extends JpaRepository<GoLocation, Long> {
    List<GoLocation> findAllByOrderByCreatedAtDesc();
    List<GoLocation> findAllByUserOrderByCreatedAtDesc(User user);
    List<GoLocation> findAllByUserInOrderByCreatedAtDesc(List<User> users);
}