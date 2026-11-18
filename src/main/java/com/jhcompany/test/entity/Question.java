package com.jhcompany.test.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; //entity클래스에서 필드 선언시 null값을 받기 위해 wrapper클래스로 선언 
	
	@Column(length = 200, nullable = false)
	private String subject;
	
	@Column(columnDefinition = "text", nullable = false) //255자 이상을 입력할 때 columnDefinition을 사용
	private String content;
	
	@CreatedDate
	private LocalDateTime createDate;
	
	//answer클래스와 question클래스의 1:n 관계 선언
	@OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE) 
	//cascade = CascadeType.REMOVE: 원글이 삭제될 때 댓글도 삭제하는 기능
	//mappedBy = "question": answer클래스의 question 객체를 관리
	private List<Answer> answerList;
	//질문 1개에 여러 답변이 저장될 수 있도록 설정 -> arraylist 이용
}
