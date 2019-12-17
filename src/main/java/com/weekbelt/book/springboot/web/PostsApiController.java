package com.weekbelt.book.springboot.web;

import com.weekbelt.book.springboot.service.PostsService;
import com.weekbelt.book.springboot.web.dto.PostUpdateRequestDto;
import com.weekbelt.book.springboot.web.dto.PostsResponseDto;
import com.weekbelt.book.springboot.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    // 글 생성 Create
    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    // 글 조회 Read
    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }

    // 글 수정 Update
    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    // 글 삭제 Delete
    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }

}
