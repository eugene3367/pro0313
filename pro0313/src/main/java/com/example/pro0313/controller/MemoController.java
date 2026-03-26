package com.example.pro0313.controller;

import com.example.pro0313.service.MemoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.pro0313.dto.MemoDto;
import com.example.pro0313.response.ApiResponse;
import jakarta.validation.Valid;

import java.util.List;

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

    @GetMapping
    public List<MemoDto> getMemos() {
        return memoService.getMemos();
    }

    @PutMapping("/{id}")
    public MemoDto updateMemo(@PathVariable Long id, @RequestBody MemoDto dto) {
        return memoService.updateMemo(id, dto);
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void>  deleteMemo(@PathVariable Long id) {
        memoService.deleteMemo(id);
        return ResponseEntity.noContent().build();
    }
}