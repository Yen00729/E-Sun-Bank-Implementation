package com.javabycode.springboot.Presentation;

import com.javabycode.springboot.model.users;
import com.javabycode.springboot.model.comment;
import com.javabycode.springboot.service.CommentService;
import com.javabycode.springboot.service.UserService;

import jakarta.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CommentController {

    private final CommentService commentService;

    private static final Logger logger = LoggerFactory.getLogger(CommentService.class);

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    // @GetMapping("/comment_form_post")
    // public String show_comment_from_post(Model model, HttpSession session, @RequestParam("post_id") int post_id) {

    //     List <comment> allComments = commentService.queryAllComment(post_id);
    //     model.addAttribute("allComments", allComments);
    //     model.addAttribute("posts_id", post_id);

    //     return "comment-form-post";
    // }

    // @GetMapping("/comment_form_add")
    // public String show_comment_from_add(Model model, HttpSession session, @RequestParam("post_id") int post_id) {

    //     model.addAttribute("posts_id", post_id);

    //     return "comment-form-add";
    // }

    @PostMapping("/comment_form_add_process")
    public String add_comment_from_add(Model model, HttpSession session, @RequestParam("post_id") int post_id, @RequestParam("content") String content) {

        users user = (users) session.getAttribute("loggedInUser");
        int user_id = user.getuser_id();

        commentService.addComment(user_id, post_id, content);

        return "redirect:/posts_detail?post_id=" + post_id;
    }

}