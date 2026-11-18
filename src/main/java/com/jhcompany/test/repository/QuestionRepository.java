package com.jhcompany.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jhcompany.test.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer> { //T:관리할 entity 이름, ID:기본키의 데이터 타입

	//제목과 일치하는 글 찾기 메서드
	List<Question> findBySubject(String subject);
	
	//특정 키워드를 갖는 제목의 글 찾기 메서드
	List<Question> findBySubjectLike(String subject); //like를 삽입한 메서드
	List<Question> findBySubjectContaining(String subject);
	
	//특정 키워드를 갖는 제목 또는 내용 찾기
	List<Question> findBySubjectLikeOrContentLike(String subject, String content);
	
	//특정 키워드를 갖는 제목 또는 내용을 작성일 오름차순으로 정리
	List<Question> findBySubjectLikeOrContentLikeOrderByCreateDateAsc(String subject, String content);
	
	void deletebySubjectLike(String keyword);
}
