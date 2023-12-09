package com.fsk.redispoc.controller;

import com.fsk.redispoc.model.Post;
import com.fsk.redispoc.service.PostService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/post")
@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    private final Logger LOG = LoggerFactory.getLogger(getClass());


    @GetMapping("/get-post-by-id/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable("id") String id) {
        LOG.info("Getting Post with Id : {} ", id);
        return  ResponseEntity.ok().body(postService.getPostById(id));
    }

    @GetMapping("/get-all-posts")
    public ResponseEntity<List<Post>> getAllPosts() {
        LOG.info("Getting all posts");
        return  ResponseEntity.ok().body(postService.getAllPosts());
    }


    @PostMapping("/add-post")
    public ResponseEntity<Post> addPost(@RequestBody Post post) {
        LOG.info("Saving Post");
        return ResponseEntity.ok().body(postService.addPost(post));
    }


    @GetMapping("/get-all-posts-by-writer-id/{id}")
    public ResponseEntity<List<Post>> getAllPostsByWriterId(@PathVariable("id") String id) {
        return ResponseEntity.ok().body(postService.getAllPostsByWriterId(id));
    }


}
