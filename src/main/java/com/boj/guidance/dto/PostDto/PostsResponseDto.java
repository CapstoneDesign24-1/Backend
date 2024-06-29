package com.boj.guidance.dto.PostDto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class PostsResponseDto {
    List<PostResponseDto> postList;
    Integer count;

    @Builder
    public PostsResponseDto(
        List<PostResponseDto> postList,
        Integer count
    ) {
        this.postList = postList;
        this.count = count;
    }
}
