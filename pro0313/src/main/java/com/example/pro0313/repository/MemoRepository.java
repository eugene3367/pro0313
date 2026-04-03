package com.example.pro0313.repository;

import com.example.pro0313.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemoRepository extends JpaRepository<Memo, Long> {

    List<Memo> findByContentContaining(String keyword);
}