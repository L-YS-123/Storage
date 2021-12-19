package com.example.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.spring.domain.Member;
import com.example.spring.service.MemberService;

@Controller
public class MemberController {
	
	private final MemberService memberService;

	
	@Autowired //연결 DI     autowired는 스프링 컨테이너에 있는 매개변수의, 객체를 연결시켜준다. 여기서는 memberService가 연결되었다
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@GetMapping("/members/new")
	public String createForm() {
		return "members/createMemberForm";
	}
	
	@PostMapping("/members/new")
	public String create(MemberForm memberForm) {
		Member member = new Member();
		member.setName(memberForm.getName());
		
		memberService.join(member);
		
		System.out.println(memberForm.getName());
		
		return "redirect:/";
	}
	
	@GetMapping("members")
	public String list(Model model) {
		List<Member> members = memberService.findMembers();
		model.addAttribute("members",members);
		return "members/memberList";
	}
}
