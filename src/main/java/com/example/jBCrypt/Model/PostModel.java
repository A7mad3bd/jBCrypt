package com.example.jBCrypt.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity

public class PostModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long postId;
//    Long userId;
    String text_content;


    public PostModel(String text_content) {
        this.text_content = text_content;
    }

    @ManyToOne
    UserModel user;

    public PostModel() {

    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }


    public String getText_content() {
        return text_content;
    }

    public void setText_content(String text_content) {
        this.text_content = text_content;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "PostModel{" +
                "postId=" + postId +
                ", text_content='" + text_content + '\'' +
                ", user=" + user +
                '}';
    }
}
