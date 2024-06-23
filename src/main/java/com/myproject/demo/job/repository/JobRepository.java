package com.myproject.demo.job.repository;

import com.myproject.demo.job.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}
