package cz.czechitas.java2webapps.ukol7.controller;

import cz.czechitas.java2webapps.ukol7.Application;
import cz.czechitas.java2webapps.ukol7.entity.Post;
import cz.czechitas.java2webapps.ukol7.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@Controller
public class PostController {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {

        this.postService = postService;
    }

    @GetMapping("/")
    public String getAllPosts(Model model) {
        Page<Post> postsPage = postService.list();
        model.addAttribute("posts", postsPage.getContent());
        return "index";
    }

    @GetMapping("/post/{slug}")
    public String postDetail(Model model, @PathVariable("slug") String slug) {
        List<Post> posts = postService.findPostBySlug(slug);
        model.addAttribute("posts", posts);
        return "post";
    }

    @GetMapping("/new")
    public String newPostForm(Model model) {
        model.addAttribute("post", new Post());
        return "new_post";
    }

    @PostMapping("/new")
    public String saveNewPost(@ModelAttribute Post post, @RequestParam("publishedDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date publishedDate) {
        post.setPublished(publishedDate);
        postService.savePost(post);
        return "redirect:/";
    }
    @GetMapping("/edit_post/{slug}")
    public String editPostForm(Model model, @PathVariable("slug") String slug) {
        List<Post> posts = postService.findPostBySlug(slug);
        if (!posts.isEmpty()) {
            model.addAttribute("edit_post", posts.get(0));
            return "edit_post"; // edit_post.ftlh template
        } else {
            return "not_found"; // handle if post with given slug is not found
        }
    }
    @PostMapping("/edit_post/{slug}")
    public String updatePost(@PathVariable("slug") String slug, @ModelAttribute Post updatedPost) {
        postService.updatePost(slug, updatedPost);
        return "redirect:/"; // Redirect to main page or any other URL after updating
    }


}