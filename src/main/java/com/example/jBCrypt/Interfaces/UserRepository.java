package com.example.jBCrypt.Interfaces;

import com.example.jBCrypt.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    public UserModel findByUsername(String username);
    public UserModel findById(long id);
}
