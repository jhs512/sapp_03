package com.tt.sapp.domain.post.post.service;

import com.tt.sapp.domain.post.post.entity.Post;
import com.tt.sapp.domain.post.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public Optional<Post> findById(long id) {
        return postRepository.findById(id);
    }

    @Transactional
    public Post write(String title) {
        Post post = Post.builder()
                .title(title)
                .build();

        return postRepository.save(post);
    }

    @Transactional
    public Post modify(Post post, String title) {
        post.setTitle(title);

        return post;
    }

    @Transactional
    public void delete(Post post) {
        postRepository.delete(post);
    }

    public List<Post> findAllByOrderByIdDesc() {
        return postRepository.findAllByOrderByIdDesc();
    }
}
