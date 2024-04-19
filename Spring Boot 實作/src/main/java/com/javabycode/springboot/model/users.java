package com.javabycode.springboot.model;

import jakarta.persistence.*;

// import org.hibernate.mapping.List;

@Entity
@Table(name = "users")
public class users {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int user_id;
    @Column(name = "password_hash")
    private String password_hash;
    @Column(name = "user_name")
    private String user_name;
    @Column(name = "email")
    private String email;
    @Column(name = "cover_image")
    private String cover_image;
    @Column(name = "biography")
    private String biography;
    
    public users() {
    }

    public users(int user_id, String password_hash, String user_name, String email, String cover_image, String biography) {
        this.user_id = user_id;
        this.password_hash = password_hash;
        this.user_name = user_name;
        this.email = email;
        this.cover_image = cover_image;
        this.biography = biography;
    }

    // Getters and Setters

    public int getuser_id() {
        return user_id;
    }

    public String getpassword_hash() {
        return password_hash;
    }

    public String getuser_name() {
        return user_name;
    }

    public String getemail() {
        return email;
    }

    public String getcover_image() {
        return cover_image;
    }

    public String getbiography() {
        return biography;
    }

    public void setuser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setpassword_hash(String password_hash) {
        this.password_hash = password_hash;
    }

    public void setuser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setemail(String email) {
        this.email = email;
    }

    public void setcover_image(String cover_image) {
        this.cover_image = cover_image;
    }

    public void setbiography(String biography) {
        this.biography = biography;
    }

}