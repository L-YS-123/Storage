package com.example.springPractice.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.assertj.core.api.Assertions;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.example.spring.SpringPracticeApplication;
import com.example.spring.domain.Member;
import com.example.spring.repository.MemberRepository;
import com.example.spring.service.MemberService;

@SpringBootTest
@Transactional
@ContextConfiguration(classes = SpringPracticeApplication.class)
public class MemberServiceIntegrationTest {
	
	@Autowired MemberService memberService;
	@Autowired MemberRepository memberRepository;
	
	@Test
	void 회원가입() {
		//given 뭔가가 주어졌는데
		Member member = new Member();
		member.setName("spring");
		
		//when 실행했을 때
		Long saveId = memberService.join(member);
		
		//then 결과가 이게 나와야 함
		Member findMember = memberService.findOne(saveId).get();
		Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
	}
	
	@Test
	public void 중복회원예외() {
		//given
		Member member1 = new Member();
		member1.setName("spring");
		
		Member member2 = new Member();
		member2.setName("spring");
		
		//when
		memberService.join(member1);
		IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
		
		assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
		
		
		/*
		 * try { memberService.join(member2); fail("테스트 예외가 발생해야 합니다."); }
		 * catch(IllegalStateException e) {
		 * assertThat(e.getLocalizedMessage()).isEqualTo("이미 존재하는 회원입니다"); }
		 */
		
		//then
		
		
	}
	
	
}
