package com.boj.guidance.service;

import com.boj.guidance.dto.CommentDto.CommentCreateRequestDto;
import com.boj.guidance.dto.CommentDto.CommentResponseDto;
import com.boj.guidance.dto.CommentDto.CommentsResponseDto;
import org.springframework.transaction.annotation.Transactional;

public interface CommentService {

    @Transactional
    CommentResponseDto createComment(String memberId, String postId, CommentCreateRequestDto dto);

    @Transactional
    CommentResponseDto createChildComment(String memberId, String postId, String commentId, CommentCreateRequestDto dto);

    @Transactional
    CommentResponseDto deleteComment(String memberId, String commentId);

    @Transactional(readOnly = true)
    CommentsResponseDto commentsOfPost(String postId);
}
