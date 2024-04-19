package com.javabycode.springboot.Presentation;

import com.javabycode.springboot.model.users;
import com.javabycode.springboot.model.posts;
import com.javabycode.springboot.model.comment;
import com.javabycode.springboot.service.PostsService;
import com.javabycode.springboot.service.UserService;

import jakarta.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties.Reactive.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PostsController {
    private final PostsService postsService;

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    public PostsController(PostsService postsService) {
        this.postsService = postsService;
    }

    // 所有文章
    @GetMapping("/posts")
    public String showBookList(Model model, HttpSession session) {

        List <posts> allPosts = postsService.queryAllPosts();
        
        model.addAttribute("allPosts", allPosts);
        // model.addAttribute("loggedInUser", ((users) session.getAttribute("loggedInUser")).getuser_name());
        model.addAttribute("loggedInUser", session.getAttribute("loggedInUser"));

        logger.info("allPosts: {}", allPosts);

        for (posts post : allPosts) {
            logger.info("Post Details: {}", post.toString());
        }

        return "posts";
    }

    // 查看文章詳細內容，包含留言
    @GetMapping("/posts_detail")
    public String showBookDetail(Model model, HttpSession session, @RequestParam("post_id") int post_id) {

        posts post = postsService.queryPost(post_id);
        List <comment> allComments = postsService.queryAllComments(post_id);
        
        model.addAttribute("post", post);
        model.addAttribute("allComments", allComments);
        model.addAttribute("loggedInUser", session.getAttribute("loggedInUser"));

        return "posts_de";
    }

    // 會員自己新增的文章
    @GetMapping("/posts_user")
    public String showBookListUser(Model model, HttpSession session) {

        List <posts> allPosts = postsService.queryAllPostsUser((users) session.getAttribute("loggedInUser"));
        
        model.addAttribute("allPosts", allPosts);
        model.addAttribute("loggedInUser", session.getAttribute("loggedInUser"));

        return "posts_user";
    }

    @GetMapping("/posts_add")
    public String showPostsAdd(Model model, HttpSession session) {

        model.addAttribute("loggedInUser", session.getAttribute("loggedInUser"));

        return "posts_add";
    }

    // 會員新增文章
    @PostMapping("/posts_add_process")
    public String processPostsAdd(Model model, HttpSession session, @RequestParam("content") String content) {

        logger.info("adding post with content: {}", content);
        logger.info("adding post with user: {}", ((users) session.getAttribute("loggedInUser")).getuser_name());

        postsService.addPost(content, (users) session.getAttribute("loggedInUser"));

        // List <posts> allPosts = postsService.queryAllPosts();
        List <posts> allPosts = postsService.queryAllPostsUser((users) session.getAttribute("loggedInUser"));
        
        model.addAttribute("allPosts", allPosts);
        model.addAttribute("loggedInUser", session.getAttribute("loggedInUser"));

        return "posts_user";
    }

    // 會員刪除文章
    @PostMapping("/posts_delete")
    public String processPostsDelete(Model model, HttpSession session, @RequestParam("post_id") int post_id) {

        logger.info("deleting post with post_id: {}", post_id);
        logger.info("deleting post with user: {}", ((users) session.getAttribute("loggedInUser")).getuser_name());

        postsService.deletePost(post_id);

        // List <posts> allPosts = postsService.queryAllPosts();
        
        // model.addAttribute("allPosts", allPosts);
        // model.addAttribute("loggedInUser", session.getAttribute("loggedInUser"));

        return "redirect:/posts_user";
    }

    @GetMapping("/posts_edit")
    public String showPostsEdit(Model model, HttpSession session, @RequestParam("post_id") int post_id) {

        posts post = postsService.queryPost(post_id);
        
        model.addAttribute("post", post);
        model.addAttribute("loggedInUser", session.getAttribute("loggedInUser"));

        return "posts_edit";
    }
    // 會員編輯自己文章
    @PostMapping("/posts_edit_process")
    public String processPostsEdit(Model model, HttpSession session, @RequestParam("post_id") int post_id, @RequestParam("content") String content) {

        logger.info("editing post with post_id: {}", post_id);
        logger.info("editing post with user: {}", ((users) session.getAttribute("loggedInUser")).getuser_name());

        postsService.editPost(post_id, content);

        List <posts> allPosts = postsService.queryAllPosts();
        
        model.addAttribute("allPosts", allPosts);
        model.addAttribute("loggedInUser", session.getAttribute("loggedInUser"));

        return "posts_user";
    }

}
