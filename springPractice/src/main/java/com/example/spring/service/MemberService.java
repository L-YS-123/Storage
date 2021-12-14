package com.example.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.domain.Member;
import com.example.spring.repository.MemberRepository;
import com.example.spring.repository.MemoryMemberRepository;

@Service
public class MemberService {
	
	private final MemberRepository memberRepository;
	
	@Autowired //연결 DI    memberRepository연결
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	/*
	 * 회원가입
	 */
	public long join(Member member) {
		validateDuplicateMember(member); // 중복 체크
		memberRepository.save(member);
		return member.getId();
	}

	// 전체 회원 조회
	public List<Member> findMembers() {
		return memberRepository.findAll();
	}

	public Optional<Member> findOne(Long memberId) {
		return memberRepository.findById(memberId);
	}

	// 같은 이름이 있는 중복 회원은 안 된다.
	public void validateDuplicateMember(Member member) {
		/*
		 * Optional<Member> result = memberRepository.findByName(member.getName());
		 * result.ifPresent(m -> { throw new IllegalStateException("이미 존재하는 회원입니다.");
		 * });
		 */
		memberRepository.findByName(member.getName()).ifPresent(m -> {
			throw new IllegalStateException("이미 존재하는 회원입니다.");
		});

	}

}
