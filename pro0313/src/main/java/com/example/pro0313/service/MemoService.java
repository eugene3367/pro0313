package com.example.pro0313.service;

import com.example.pro0313.entity.Memo;
import com.example.pro0313.repository.MemoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemoService {
    private final MemoRepository memoRepository;

    public MemoService(MemoRepository memoRepository) {
        this.memoRepository = memoRepository;
    }

    public Memo createMemo(Memo memo) {
        return memoRepository.save(memo);
    }

    public List<Memo> getMemos() {
        return memoRepository.findAll();
    }

    public Memo updateMemo(Long id, String content) {
        Memo memo = memoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Memo not found: " + id));
        memo.setContent(content);
        return memoRepository.save(memo);
    }

    // Delete
    public void deleteMemo(Long id) {
        if (!memoRepository.existsById(id)) {
            throw new RuntimeException("Memo not found: " + id);
        }
        memoRepository.deleteById(id);
    }
}