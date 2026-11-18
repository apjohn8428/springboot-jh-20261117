package com.jhcompany.test.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jhcompany.test.entity.Question;
import com.jhcompany.test.repository.QuestionRepository;
import com.jhcompany.test.service.QuestionService;

@Controller
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	@GetMapping("/") //root 요청 -> index.html로 반드시 처리
	public String root() {
		return "index";
	}
	
	@GetMapping("/question/list") //질문 목록 요청
	public String list(Model model) {
		//모든 질문 리스트 출력
		List<Question> questionlist = questionService.getQuestionList();
		//model 객체에 질문 리스트 객체 전송
		model.addAttribute("questionlist", questionlist);
		
		return "question_list";
	}
	
	@GetMapping("/test")
	public String test(Model model) {
		
		model.addAttribute("name", "홍길동");
		model.addAttribute("age", 25);
		model.addAttribute("loginId", "tiger");
		
		ArrayList<String> strs = new ArrayList<>();
		strs.add("이순신");
		strs.add("김유신");
		strs.add("강감찬");
		
		model.addAttribute("strs", strs);
		
		return "test";
	}
	
}
