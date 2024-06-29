package com.boj.guidance.service;

import com.boj.guidance.dto.PostDto.*;
import org.springframework.transaction.annotation.Transactional;

public interface PostService {

    @Transactional
    PostResponseDto createPost(String creator, PostCreateRequestDto dto);

    @Transactional
    PostResponseDto deletePost(String deleter, String postId);

    @Transactional
    PostResponseDto updatePost(String updater, String postId, PostUpdateRequestDtp dto);

    @Transactional
    void updateLikes(String postId);

    @Transactional(readOnly = true)
    PostsResponseDto findPostListByPage(Integer currentPage, Integer page);
}
