package com.example.springPractice.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.example.spring.domain.Member;
import com.example.spring.repository.MemberRepository;
import com.example.spring.repository.MemoryMemberRepository;

public class MemoryMemberRepositoryTest {

	MemberRepository repository = new MemoryMemberRepository();
	
	@Test
	public void save() {
		Member member = new Member();
		member.setName("spring");
		
		repository.save(member);
		
		Member result = repository.findById(member.getId()).get();
		org.assertj.core.api.Assertions.assertThat(member).isEqualTo(result);
		
	}
	
}
