package com.tt.sapp.domain.post.post.dto;

import com.tt.sapp.domain.post.post.entity.Post;
import lombok.Getter;

@Getter
public class PostDto {
    private final Long id;
    private final String title;

    public PostDto(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
    }
}
