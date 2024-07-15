package com.tt.sapp.domain.post.post.service;

import com.tt.sapp.domain.post.post.entity.Post;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private final List<Post> posts = List.of(
            Post.builder().id(1L).title("title1").build(),
            Post.builder().id(2L).title("title2").build()
    );

    public List<Post> findAll() {
        return posts;
    }

    public Optional<Post> findById(long id) {
        return posts.stream().filter(post -> post.getId().equals(id))
                .findFirst();

    }
}
