package com.example.demo.repository;

import com.example.demo.entity.Jueces;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JuezRepository extends JpaRepository<Jueces, Long> {
}
