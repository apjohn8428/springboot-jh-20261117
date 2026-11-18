package com.jhcompany.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jhcompany.test.entity.Answer;
import com.jhcompany.test.entity.Question;
import com.jhcompany.test.repository.AnswerRepository;
import com.jhcompany.test.repository.QuestionRepository;

@SpringBootTest
class SbbProjectAnswerTest {

	@Autowired
	private AnswerRepository arpo;
	@Autowired
	private QuestionRepository qrpo;
	
	@Test
	@DisplayName("답변 저장 테스트")
	void testJpa() {
		Optional<Question> questionOp = qrpo.findById(1);
		assertTrue(questionOp.isPresent()); //괄호 안이 참이면 그대로 진행
		Question quest1 = questionOp.get();
		
		Answer answer = new Answer();
		answer.setContent("1번 질문글 답변입니다");
		answer.setCreateDate(LocalDateTime.now());
		answer.setQuestion(quest1);
		
		arpo.save(answer);
	}

}
