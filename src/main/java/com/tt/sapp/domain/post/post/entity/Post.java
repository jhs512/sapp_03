package com.tt.sapp.domain.post.post.entity;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Post {
    private Long id;
    private String title;
}
