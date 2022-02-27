package com.example.demo.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


import com.example.demo.domain.IdAndPw;



//repository에는 DB에 접근하는 코드가 모여있다

@Mapper
public interface LoginMapper {

	//로그인
	@Select("SELECT (USERID, USERPW) FROM MEMBER_INFO WHERE (USERID = {#iap.userId} AND USERPW = {#iap.userPw})")
	int selectLoginInfo(@Param("iap") IdAndPw idAndPw);
	
}
