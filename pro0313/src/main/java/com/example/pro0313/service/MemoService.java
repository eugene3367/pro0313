package com.example.pro0313.service;

import com.example.pro0313.dto.MemoResponseDto;
import com.example.pro0313.entity.Memo;
import com.example.pro0313.exception.MemoNotFoundException;
import com.example.pro0313.repository.MemoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.pro0313.dto.MemoDto;

import java.util.List;

@Service
public class MemoService {
    private final MemoRepository memoRepository;

    public MemoService(MemoRepository memoRepository) {
        this.memoRepository = memoRepository;
    }

    public MemoDto createMemo(MemoDto dto) {
        Memo memo = new Memo();
        memo.setContent(dto.getContent());

        Memo saved = memoRepository.save(memo);

        return toDto(saved);
    }

    public List<MemoDto> getMemos() {
        return memoRepository.findAll()
                .stream()
                .map(this::toDto)
                .toList();
    }

    public MemoDto updateMemo(Long id, MemoDto dto) {
        Memo memo = memoRepository.findById(id)
                .orElseThrow(() -> new MemoNotFoundException(id));

        memo.setContent(dto.getContent());

        Memo updated = memoRepository.save(memo);

        return toDto(updated);
    }

    // Delete
    public void deleteMemo(Long id) {
        if (!memoRepository.existsById(id)) {
            throw new MemoNotFoundException(id);
        }
        memoRepository.deleteById(id);
    }

    private MemoDto toDto(Memo memo) {
        MemoDto dto = new MemoDto();
        dto.setId(memo.getId());
        dto.setContent(memo.getContent());
        return dto;
    }

    public List<MemoResponseDto> search(String keyword) {
        return memoRepository.findByContentContaining(keyword)
                .stream()
                .map(MemoResponseDto::new)
                .toList();
    }

    public List<MemoResponseDto> findAll() {
        return memoRepository.findAll()
                .stream()
                .map(MemoResponseDto::new)
                .toList();
    }

    public Page<MemoResponseDto> findAll(Pageable pageable) {
        return memoRepository.findAll(pageable)
                .map(MemoResponseDto::new);
    }
}