package com.example.spring.service;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.spring.repository.JdbcMemberRepository;
import com.example.spring.repository.MemberRepository;
import com.example.spring.repository.MemoryMemberRepository;


//어노테이션을 쓰지 않고 직접 스프링 컨테이너에 bean객체를 등록
@Configuration
public class SpringConfig {
	
	@Autowired
	private DataSource dataSource;

	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository());
	}
	
	@Bean
	public MemberRepository memberRepository() {
//		return new MemoryMemberRepository();
		return new JdbcMemberRepository(dataSource);
	}

	
}
