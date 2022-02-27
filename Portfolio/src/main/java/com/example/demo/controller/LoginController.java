package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.domain.IdAndPw;
import com.example.demo.mapper.LoginMapper;


@Controller
public class LoginController {
	
	@Autowired
	private LoginMapper loginMapper;
	
	//로그인x
	@GetMapping("login")
	public String loginPage() {
		return "loginPage";
	}
	
	//로그인o
	@PostMapping("login")
	public int doLogin(@ModelAttribute IdAndPw idpw, ModelAndView mav) {
		return loginMapper.selectLoginInfo(idpw);
//		return "index";
	}
	
}
