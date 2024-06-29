package com.boj.guidance.dto.PostDto;

import com.boj.guidance.domain.Post;
import com.boj.guidance.domain.enumerate.PostType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostResponseDto {
    String id;
    String writer;
    String title;
    String content;
    String createdAt;
    String updatedAt;
    Boolean isDeleted;
    PostType postType;
    Integer likes;

    @Builder
    public PostResponseDto(
            String id,
            String writer,
            String title,
            String content,
            String createdAt,
            String updatedAt,
            Boolean isDeleted,
            PostType postType,
            Integer likes
    ) {
        this.id = id;
        this.writer = writer;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.isDeleted = isDeleted;
        this.postType = postType;
        this.likes = likes;
    }

    public PostResponseDto toDto(Post entity) {
        return PostResponseDto.builder()
                .id(entity.getId())
                .writer(entity.getWriter())
                .title(entity.getTitle())
                .content(entity.getContent())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .isDeleted(entity.getIsDeleted())
                .postType(entity.getPostType())
                .likes(entity.getLikes())
                .build();
    }
}
