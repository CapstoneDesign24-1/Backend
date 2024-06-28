package com.boj.guidance.controller;

import com.boj.guidance.dto.PostDto.PostCreateRequestDto;
import com.boj.guidance.dto.PostDto.PostResponseDto;
import com.boj.guidance.service.PostService;
import com.boj.guidance.util.api.ApiResponse;
import com.boj.guidance.util.api.ResponseCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/{memberId}")
    public ApiResponse<PostResponseDto> create(
            @PathVariable("memberId") String memberId,
            @RequestBody PostCreateRequestDto dto
    ) {
        return ApiResponse.success(ResponseCode.POST_CREATE_SUCCESS.getMessage(), postService.createPost(memberId, dto));
    }

    @PutMapping("/likes/{postId}")
    public void likes(@PathVariable("postId") String postId) {
        postService.updateLikes(postId);
    }

}
