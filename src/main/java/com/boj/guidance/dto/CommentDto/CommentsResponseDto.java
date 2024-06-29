package com.boj.guidance.dto.CommentDto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class CommentsResponseDto {
    private List<CommentResponseDto> commentList;
    private Integer count;

    @Builder
    private CommentsResponseDto(
            List<CommentResponseDto> commentList,
            Integer count
            ) {
        this.commentList = commentList;
        this.count = count;
    }

    public CommentsResponseDto toDtos(
            List<CommentResponseDto> commentList,
            Integer count
            ) {
        return CommentsResponseDto.builder()
                .commentList(commentList)
                .count(count)
                .build();
    }
}
