package com.example.pro0313.repository;

import com.example.pro0313.entity.Memo;
import com.example.pro0313.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemoRepository extends JpaRepository<Memo, Long> {

    Page<Memo> findByUserAndContentContaining(User user, String keyword, Pageable pageable);

    List<Memo> findByUser(User user);

    Page<Memo> findByUser(User user, Pageable pageable);
}