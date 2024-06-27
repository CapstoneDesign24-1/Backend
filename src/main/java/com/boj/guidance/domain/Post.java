package com.boj.guidance.domain;

import com.boj.guidance.domain.enumerate.PostType;
import com.boj.guidance.util.annotation.LockSerial;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Getter
@NoArgsConstructor
public class Post {

    @Id
    @LockSerial
    private String id;
    private String writer;
    private String title;
    private String content;
    private String createdAt;
    private String updatedAt;
    private Boolean isDeleted;
    private PostType postType;
    private Integer likes;

    @Builder
    public Post(
            String writer,
            String title,
            String content,
            PostType postType
    ) {
        this.writer = writer;
        this.title = title;
        this.content = content;
        this.createdAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        this.updatedAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        this.isDeleted = Boolean.FALSE;
        this.postType = postType;
        this.likes = 0;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
        this.updatedAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public void addLikes() {
        this.likes++;
    }

    public void deleted() {
        this.isDeleted = Boolean.TRUE;
    }
}

