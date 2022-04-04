package com.example.jBCrypt.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity

public class PostModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String title;
    String body;
    Date createdAt;

    @ManyToOne
    UserModel applicationUser;
    public PostModel() {

    }


    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public UserModel getApplicationUser() {
        return applicationUser;
    }

    public void setApplicationUser(UserModel postByUser) {
        this.applicationUser = postByUser;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public PostModel(String title, String body) {
        this.title = title;
        this.body = body;
    }
}
