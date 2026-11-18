package com.jhcompany.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhcompany.test.entity.Question;
import com.jhcompany.test.repository.QuestionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QuestionService {

	@Autowired
	private QuestionRepository questionrepository;
	
	//모든 질문 목록을 반환하는 메서드
	public List<Question> getQuestionList() {
		List<Question> questionList = questionrepository.findAll();
		return questionList;
	}
}
