package cz.czechitas.java2webapps.ukol7.service;

import cz.czechitas.java2webapps.ukol7.entity.Post;
import cz.czechitas.java2webapps.ukol7.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> findPostBySlug(String slug) {
        return postRepository.findBySlug(slug);
    }
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Page<Post> list() {
        Date currentDate = new Date(); // Aktuální datum
        return postRepository.findAllByPublishedBeforeOrderByPublishedDesc(currentDate, PageRequest.of(0, 20));
    }

    public void savePost(Post post) {
        postRepository.save(post);
    }

    public void updatePost(String slug, Post updatedPost) {
        List<Post> existingPosts = postRepository.findBySlug(slug);
        if (!existingPosts.isEmpty()) {
            Post existingPost = existingPosts.get(0);
            existingPost.setTitle(updatedPost.getTitle());
            existingPost.setAuthor(updatedPost.getAuthor());
            existingPost.setPerex(updatedPost.getPerex());
            existingPost.setBody(updatedPost.getBody());
            existingPost.setPublished(updatedPost.getPublished());
            postRepository.save(existingPost);
        } else {
            throw new IllegalArgumentException("Post with slug " + slug + " not found.");
        }
    }

}