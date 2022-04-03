package com.example.jBCrypt.Interfaces;

import com.example.jBCrypt.Model.PostModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostModel, Long> {
}
