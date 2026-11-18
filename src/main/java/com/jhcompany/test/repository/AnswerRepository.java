package com.jhcompany.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jhcompany.test.entity.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {

}
