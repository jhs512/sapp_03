package com.tt.sapp.domain.post.post.controller;

import com.tt.sapp.domain.post.post.dto.PostDto;
import com.tt.sapp.domain.post.post.entity.Post;
import com.tt.sapp.domain.post.post.service.PostService;
import com.tt.sapp.global.rsData.RsData;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
@RequiredArgsConstructor
public class ApiV1PostController {
    private final PostService postService;

    @GetMapping("")
    public List<PostDto> getItems() {
        List<Post> items = postService.findAll();

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
    public RsData<PostDto> write(@RequestBody PostWriteRequestBody requestBody) {
        return new RsData<>(
                "200-1",
                "성공",
                new PostDto(
                        postService.write(requestBody.title)
                )
        );
    }
}