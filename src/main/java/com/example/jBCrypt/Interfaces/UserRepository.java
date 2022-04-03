package com.example.jBCrypt.Interfaces;

import com.example.jBCrypt.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long> {
//    UserModel findByUsername(String username);
    UserModel findByUsername(String username1);
    UserModel getUserModelById(Long id) ;

}
