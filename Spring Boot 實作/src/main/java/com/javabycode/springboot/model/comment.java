package com.javabycode.springboot.model;

import jakarta.persistence.*;

@Entity
@Table(name = "comment")
public class comment {  // 类名首字母大写

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commentId;  // 使用小驼峰命名法
    @Column(name = "user_id")
    private int userId;
    @Column(name = "post_id")
    private int postId;
    @Column(name = "content")
    private String content;
    @Column(name = "created_at")
    private String createdAt;

    public comment() {
    }

    public comment(int commentId, int userId, int postId, String content, String createdAt) {
        this.commentId = commentId;
        this.userId = userId;
        this.postId = postId;
        this.content = content;
        this.createdAt = createdAt;
    }

    public int getCommentId() {  // 遵循 JavaBeans 命名约定
        return commentId;
    }

    public int getUserId() {
        return userId;
    }

    public int getPostId() {
        return postId;
    }

    public String getContent() {
        return content;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}