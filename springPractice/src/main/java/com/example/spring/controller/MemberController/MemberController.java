package com.example.spring.controller.MemberController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.spring.service.MemberService;

@Controller
public class MemberController {
	
	private final MemberService memberService;

	
	@Autowired //연결 DI     autowired는 스프링 컨테이너에 있는 매개변수의, 객체를 연결시켜준다. 여기서는 memberService가 연결되었다
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	
	
}
