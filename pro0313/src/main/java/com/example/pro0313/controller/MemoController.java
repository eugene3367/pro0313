package com.example.pro0313.controller;

import com.example.pro0313.service.MemoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.pro0313.dto.MemoDto;

import java.util.List;

@RestController
@RequestMapping("/memo")
public class MemoController {

    private final MemoService memoService;

    public MemoController(MemoService memoService) {
        this.memoService = memoService;
    }

    @PostMapping
    public MemoDto createMemo(@RequestBody MemoDto dto) {
        return memoService.createMemo(dto);
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
        try {
            memoService.deleteMemo(id);
            return ResponseEntity.noContent().build(); // 204 No Content
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }
}