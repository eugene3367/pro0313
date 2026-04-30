package com.example.pro0313.controller;

import com.example.pro0313.dto.MemoDto;
import com.example.pro0313.dto.MemoRequestDto;
import com.example.pro0313.dto.MemoResponseDto;
import com.example.pro0313.entity.Memo;
import com.example.pro0313.response.ApiResponse;
import com.example.pro0313.service.MemoService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/memo")
public class MemoController {

    private final MemoService memoService;

    public MemoController(MemoService memoService) {
        this.memoService = memoService;
    }

//    @PostMapping
//    public ResponseEntity<ApiResponse<MemoDto>> createMemo(@Valid @RequestBody MemoDto dto) {
//
//        MemoDto result = memoService.createMemo(dto);
//
//        return ResponseEntity.ok(
//                new ApiResponse<>(true, result, null)
//        );
//    }

    @PostMapping
    public ApiResponse<String> createMemo(
            @RequestBody MemoRequestDto dto,
            Authentication authentication) {

        String username = authentication.getName();

        memoService.createMemo(dto.getContent(), username);

        return ApiResponse.success("메모 생성 성공");
    }


//    @PutMapping("/{id}")
//    public ResponseEntity<ApiResponse<MemoDto>> updateMemo(
//            @PathVariable Long id,
//            @Valid @RequestBody MemoDto dto
//    ) {
//
//        MemoDto result = memoService.updateMemo(id, dto);
//
//        return ResponseEntity.ok(
//                new ApiResponse<>(true, result, null)
//        );
//    }

    @PutMapping("/{id}")
    public ApiResponse<MemoDto> updateMemo(
            @PathVariable Long id,
            @Valid @RequestBody MemoDto dto
    ) {

        MemoDto result = memoService.updateMemo(id, dto);

        return ApiResponse.success(result);
    }



    // Delete
    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteMemo(@PathVariable Long id) {

        memoService.deleteMemo(id);

        return ApiResponse.success(null);
    }


    @GetMapping
    public ApiResponse<Page<MemoResponseDto>> getMemos(
            @RequestParam(required = false) String keyword,
            Authentication authentication,
            Pageable pageable) {

        String username = authentication.getName();

        if (keyword != null && !keyword.isEmpty()) {
            return ApiResponse.success(
                    memoService.searchMemos(username, keyword, pageable)
            );
        }

        return ApiResponse.success(
                memoService.getMyMemos(username, pageable)
        );
    }

//    @GetMapping("/me")
//    public String getCurrentUser(HttpServletRequest request) {
//        String username = (String) request.getAttribute("username");
//        return "현재 사용자: " + username;
//    }

    @GetMapping("/me")
    public ApiResponse<String> me() {

        System.out.println("👉 컨트롤러 진입");

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        System.out.println("👉 authentication: " + authentication);

        return ApiResponse.success(authentication.getName());

    }
}