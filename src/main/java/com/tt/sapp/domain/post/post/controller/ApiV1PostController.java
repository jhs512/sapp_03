package com.tt.sapp.domain.post.post.controller;

import com.tt.sapp.domain.post.post.dto.PostDto;
import com.tt.sapp.domain.post.post.entity.Post;
import com.tt.sapp.domain.post.post.service.PostService;
import com.tt.sapp.global.rsData.RsData;
import com.tt.sapp.standard.dto.Empty;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ApiV1PostController {
    private final PostService postService;

    @GetMapping("")
    public List<PostDto> getItems() {
        List<Post> items = postService.findAllByOrderByIdDesc();

        return items
                .stream()
                .map(PostDto::new)
                .toList();
    }

    @GetMapping("/{id}")
    public PostDto getItem(@PathVariable long id) {
        return postService
                .findById(id)
                .map(PostDto::new)
                .get();
    }


    public record PostWriteRequestBody(String title) {
    }

    @PostMapping("")
    @Transactional
    public RsData<PostDto> write(@RequestBody PostWriteRequestBody requestBody) {
        Post post = postService.write(requestBody.title);

        return new RsData<>(new PostDto(post));
    }


    public record PostModifyRequestBody(String title) {
    }

    @PutMapping("/{id}")
    @Transactional
    public RsData<PostDto> modify(
            @PathVariable long id,
            @RequestBody PostModifyRequestBody requestBody
    ) {
        Post post = postService.findById(id).get();
        postService.modify(post, requestBody.title);

        return new RsData<>(new PostDto(post));
    }


    @DeleteMapping("/{id}")
    @Transactional
    public RsData<Empty> delete(
            @PathVariable long id
    ) {
        Post post = postService.findById(id).get();

        postService.delete(post);

        return new RsData<>();
    }
}