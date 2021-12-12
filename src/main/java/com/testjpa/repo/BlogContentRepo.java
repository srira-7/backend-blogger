package com.testjpa.repo;

import com.testjpa.entity.BlogContent;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface BlogContentRepo extends JpaRepository<BlogContent, Integer> {
}
