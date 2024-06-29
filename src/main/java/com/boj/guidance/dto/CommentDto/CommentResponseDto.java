package com.boj.guidance.dto.CommentDto;

import com.boj.guidance.domain.Comment;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class CommentResponseDto {
    private String id;
    private String post;
    private String writer;
    private String content;
    private String createdAt;
    private String parentComment;
    private List<String> commentList;
    private Boolean isDeleted;

    @Builder
    public CommentResponseDto(
            String id,
            String post,
            String member,
            String content,
            String createdAt,
            String parentComment,
            List<String> commentList,
            Boolean isDeleted
    ) {
        this.id = id;
        this.post = post;
        this.writer = member;
        this.content = content;
        this.createdAt = createdAt;
        this.parentComment = parentComment;
        this.commentList = commentList;
        this.isDeleted = isDeleted;
    }

    public CommentResponseDto toDto(Comment entity) {
        return CommentResponseDto.builder()
                .id(entity.getId())
                .post(entity.getPost().getId())
                .member(entity.getWriter().getHandle())
                .content(entity.getContent())
                .createdAt(entity.getCreatedAt())
                .parentComment(entity.getParentComment() != null ? entity.getParentComment().getId() : null)
                .commentList(entity.getCommentList().stream().map(Comment::getId).toList())
                .isDeleted(entity.getIsDeleted())
                .build();
    }
}
