package com.example.pro0313.controller;

import com.example.pro0313.dto.MemoDto;
import com.example.pro0313.response.ApiResponse;
import com.example.pro0313.service.MemoService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/memo")
public class MemoController {

    private final MemoService memoService;

    public MemoController(MemoService memoService) {
        this.memoService = memoService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<MemoDto>> createMemo(@Valid @RequestBody MemoDto dto) {

        MemoDto result = memoService.createMemo(dto);

        return ResponseEntity.ok(
                new ApiResponse<>(true, result, null)
        );
    }


    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<MemoDto>> updateMemo(
            @PathVariable Long id,
            @Valid @RequestBody MemoDto dto
    ) {

        MemoDto result = memoService.updateMemo(id, dto);

        return ResponseEntity.ok(
                new ApiResponse<>(true, result, null)
        );
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteMemo(@PathVariable Long id) {

        memoService.deleteMemo(id);

        return ResponseEntity.ok(
                new ApiResponse<>(true, null, null)
        );
    }

    @GetMapping
    public ApiResponse<?> getMemos(
            @RequestParam(required = false) String keyword,
            Pageable pageable
    ) {
        if (keyword != null) {
            return ApiResponse.success(memoService.search(keyword));
        }

        return ApiResponse.success(memoService.findAll(pageable));
    }
}