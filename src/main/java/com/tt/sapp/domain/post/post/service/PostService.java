package com.tt.sapp.domain.post.post.service;

import com.tt.sapp.domain.post.post.entity.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private final List<Post> posts = new ArrayList<>() {{
        add(Post.builder().id(1L).title("title1").build());
        add(Post.builder().id(2L).title("title2").build());
    }};

    public List<Post> findAll() {
        return posts;
    }

    public Optional<Post> findById(long id) {
        return posts.stream().filter(post -> post.getId().equals(id))
                .findFirst();

    }

    public Post write(String title) {
        Post post = Post.builder()
                .id(posts.size() + 1L)
                .title(title)
                .build();

        posts.add(post);

        return post;
    }
}
