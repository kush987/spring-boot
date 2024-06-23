package com.myproject.demo.reviews.repository;

import com.myproject.demo.reviews.model.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Reviews, Long> {
    List<Reviews> findByCompanyId(Long companyId);
}
