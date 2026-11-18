package com.jhcompany.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jhcompany.test.entity.Question;
import com.jhcompany.test.repository.QuestionRepository;

@SpringBootTest
class SbbProjectJh20261117ApplicationTests {

	@Autowired //의존성 주입 -> 객체를 보내줌
	private QuestionRepository qrpo;
	
	//질문 저장 테스트
	@Test
	@DisplayName("question테이블 insert 테스트")
	void testJpa1() {
		Question q3 = new Question();
		q3.setSubject("3번 테스트입니다");
		q3.setContent("질문 테스트 3의 내용입니다");
		q3.setCreateDate(LocalDateTime.now()); //LocalDateTime.now(): 현재 시간 추출
		// sql문을 사용했을 경우 insert를 사용했을 것이나 여기서는 repository를 활용 
		
		qrpo.save(q3);
	}
	
	@Test
	@DisplayName("question테이블 select 테스트")
	void testJpa2() {
		//테이블 전체 조회
		List<Question> queslist = qrpo.findAll(); //객체 묶음으로 오기 때문에 list로 받아야 한다
	
		System.out.println(queslist.get(0).getSubject());
		//1번 레코드의 제목 출력
	}
	
	@Test
	@DisplayName("번호로 글 찾기")
	void testJpa3() {
		Optional<Question> opquest = qrpo.findById(2); //optional클래스를 이용하여 null값이 올 경우를 대비
		if(opquest.isPresent()) { //객체 내 값을 확인, 참 -> 검색한 질문 존재
			Question quest = opquest.get(); //optional 객체 안에서 question 객체 꺼내기
			System.out.println(quest.getSubject());
		}
	}
	
	@Test
	@DisplayName("제목으로 글 찾기")
	void testJpa4() {
		List<Question> sublist = qrpo.findBySubject("3번 테스트입니다");
		System.out.println(sublist.get(0).getId()); //찾은 글의 번호 출력
	}
	
	@Test
	@DisplayName("특정 키워드를 갖는 제목의 글 찾기")
	void testJpa5() {
		List<Question> sublist1 = qrpo.findBySubjectLike("%3번%");
		System.out.println(sublist1.get(0).getId()); //찾은 글의 번호 출력
		
		List<Question> sublist2 = qrpo.findBySubjectContaining("3번");
		System.out.println(sublist2.get(0).getId());
		
		//containing은 %없이 사용 가능
		
		List<Question> sublist3 = qrpo.findBySubjectLikeOrContentLike("%안녕%", "%안녕%");
	}
	
	@Test
	@DisplayName("글 삭제 테스트")
	void testJpa6() {
		Optional<Question> qoptinal = qrpo.findById(2); //해당 번호에 해당하는 글의 유뮤 판단 
		if(qoptinal.isPresent()) { 
			qrpo.deleteById(2); //2번글 삭제
		}
	}
	
	@Test
	@DisplayName("제목과 내용 수정 테스트")
	void testJpa7() {
		//update 기능이 없기 때문에 가져온 후(findbyid) 수정(setter) 및 저장(save)
		Optional<Question> questionOp = qrpo.findById(2);
		if(questionOp.isPresent()) {
			Question question = questionOp.get();
			
			question.setSubject("수정한 제목");
			question.setContent("수정한 내용");
			
			qrpo.save(question);
		}
	}

}
