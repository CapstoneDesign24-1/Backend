package com.boj.guidance.dto.PostDto;

import com.boj.guidance.domain.Post;
import com.boj.guidance.domain.enumerate.PostType;

public class PostCreateRequestDto {
    String title;
    String content;
    PostType postType;

    public Post toEntity(String writer) {
        return Post.builder()
                .writer(writer)
                .title(this.title)
                .content(this.content)
                .postType(this.postType)
                .build();
    }
}
