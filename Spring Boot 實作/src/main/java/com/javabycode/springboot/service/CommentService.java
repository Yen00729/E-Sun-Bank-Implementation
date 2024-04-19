package com.javabycode.springboot.service;

import com.javabycode.springboot.model.users;
import com.javabycode.springboot.model.comment;
import com.javabycode.springboot.repository.CommentRepository;
import com.javabycode.springboot.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;

import java.util.List;
import java.util.Base64;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.spec.KeySpec;
import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class CommentService {

    private static final Logger logger = LoggerFactory.getLogger(CommentService.class);
    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<comment> queryAllComment(int post_id) {
        logger.info("Retrieving all comments");

        List<comment> allComments = commentRepository.findByPostId(post_id);

        logger.info("Retrieved {} comments", allComments.size());

        return allComments;
    }

    public void addComment(int user_id, int post_id, String content) {
        logger.info("Adding comment");

        comment newComment = new comment();
        newComment.setUserId(user_id);
        newComment.setPostId(post_id);
        newComment.setContent(content);
        newComment.setCreatedAt(LocalDateTime.now().toString());
        
        commentRepository.save(newComment);

        logger.info("Comment added");
    }

    
}