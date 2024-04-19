package com.javabycode.springboot.model;

import jakarta.persistence.*;

@Entity
@Table(name = "posts")
public class posts {  // 类名首字母大写
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postId;  // 使用驼峰命名法
    @Column(name = "user_id")
    private int userId;
    @Column(name = "content")
    private String content;
    @Column(name = "created_at")
    private String createdAt;

    public posts() {
    }

    public posts(int postId, int userId, String content, String createdAt) {
        this.postId = postId;
        this.userId = userId;
        this.content = content;
        this.createdAt = createdAt;
    }

    // 标准的 JavaBeans getter 方法命名
    public int getPostId() {
        return postId;
    }

    public int getUserId() {
        return userId;
    }

    public String getContent() {
        return content;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    // 标准的 JavaBeans setter 方法命名
    public void setPostId(int postId) {
        this.postId = postId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
