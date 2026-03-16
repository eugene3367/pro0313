package com.example.pro0313.controller;

import com.example.pro0313.entity.Memo;
import com.example.pro0313.repository.MemoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/memo")
public class MemoController {

    private final MemoRepository memoRepository;

    public MemoController(MemoRepository memoRepository) {
        this.memoRepository = memoRepository;
    }

    @PostMapping
    public Memo createMemo(@RequestBody Memo memo) {
        return memoRepository.save(memo);
    }

    @GetMapping
    public List<Memo> getMemos() {
        return memoRepository.findAll();
    }

}