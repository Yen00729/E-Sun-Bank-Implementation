package com.javabycode.springboot.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javabycode.springboot.model.comment;
import com.javabycode.springboot.model.users;
import com.javabycode.springboot.model.posts;
import com.javabycode.springboot.repository.PostsRepository;
import com.javabycode.springboot.repository.CommentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;
import java.security.SecureRandom;
import java.util.Base64;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.spec.KeySpec;
import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
public class PostsService {

    private static final Logger logger = LoggerFactory.getLogger(PostsService.class);
    private final PostsRepository postsRepository;
    private final CommentRepository commentRepository;

    @Autowired
    public PostsService(PostsRepository postsRepository, CommentRepository commentRepository) {
        this.postsRepository = postsRepository;
        this.commentRepository = commentRepository;
    }
    public void deletePost(int post_id) {
        postsRepository.deleteById(post_id);
    }

    public List<posts> queryAllPosts() {
        logger.info("Retrieving all Inventory");

        List<posts> allPosts = postsRepository.findAll();

        logger.info("Retrieved {} Inventory", allPosts.size());

        for (int i = 0; i < allPosts.size(); i++) {
            logger.info("posts_id: {}", allPosts.get(i).getPostId());
            logger.info("user_id: {}", allPosts.get(i).getUserId());
            logger.info("created_at: {}", allPosts.get(i).getCreatedAt());
        }

        return allPosts;
    }

    public posts queryPost(int post_id) {
        logger.info("Retrieving post with post_id: {}", post_id);

        posts post = postsRepository.findByPostId(post_id);

        if (post == null) {
            logger.info("post not found");
            return null;
        }

        logger.info("posts_id: {}", post.getPostId());
        logger.info("user_id: {}", post.getUserId());
        logger.info("created_at: {}", post.getCreatedAt());

        return post;
    }

    public List <comment> queryAllComments(int post_id) {
        logger.info("Retrieving all comments");

        List<comment> allComments = commentRepository.findByPostId(post_id);

        logger.info("Retrieved {} comments", allComments.size());

        return allComments;
    }

    public List<posts> queryAllPostsUser(users user) {
        logger.info("Retrieving all Posts");

        int user_id = user.getuser_id();

        List<posts> allPosts = postsRepository.findByUserId(user_id);

        logger.info("Retrieved {} Inventory", allPosts.size());

        return allPosts;
    }

    public void addPost(String content, users user) {
        logger.info("adding post with content: {}", content);
        logger.info("adding post with user: {}", user.getuser_id());

        posts post = new posts();

        post.setUserId(user.getuser_id());
        post.setContent(content);
        post.setCreatedAt(LocalDateTime.now().toString());

        postsRepository.save(post);
    }

    // public static void deletePost(int post_id) {
    //     logger.info("deleting post with post_id: {}", post_id);

    //     PostsService.deletePost(post_id);
    // }

    public void editPost(int post_id, String content) {
        logger.info("editing post with post_id: {}", post_id);

        posts post = postsRepository.findByPostId(post_id);

        if (post == null) {
            logger.info("post not found");
            return;
        }

        post.setContent(content);

        postsRepository.save(post);
    }

}
