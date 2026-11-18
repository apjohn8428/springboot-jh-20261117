package com.jhcompany.test.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Answer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(columnDefinition = "text", nullable = false) //255자 이상을 입력할 때 columnDefinition을 사용
	private String content;
	
	@CreatedDate
	private LocalDateTime createDate;
	
	//답변이 달릴 질문(부모 글) 정보가 필요
	@ManyToOne // answer클래스와 question클래스의 n:1 관계 선언
	private Question question; //Question클래스의 객체 선언 -> 자동적으로 테이블 간 관계 연결
}
