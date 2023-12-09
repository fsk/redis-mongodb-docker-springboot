package com.fsk.redispoc.service;

import com.fsk.redispoc.model.Post;
import com.fsk.redispoc.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@EnableCaching
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    private final Logger LOGGER = LoggerFactory.getLogger(PostService.class);


    @Cacheable(value = "PostCache", key = "#id", unless = "#result == null")
    public Post getPostById(String id) {
        return postRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Writer Not Found"));
    }
    @Cacheable(value = "PostCache", key = "'all'")
    public List<Post> getAllPosts() {
        List<Post> postList = postRepository.findAll();

        if (!postList.isEmpty()) {
            LOGGER.info("Bütün post belgeleri Redis önbelleğine eklendi.");
        } else {
            LOGGER.info("Post belgeleri bulunamadı.");
        }

        return postList;
    }

    public Post addPost(Post post) {
        return postRepository.save(post);
    }

    public List<Post> getAllPostsByWriterId(String id) {
        return postRepository.getPostByWriterId(id);
    }
}
