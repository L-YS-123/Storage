package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.domain.IdAndPw;


@Controller
public class LoginController {

	@GetMapping("login")
	public String loginPage() {
		return "loginPage";
	}
	
	@PostMapping("login")
	public String doLogin(@ModelAttribute IdAndPw idpw, ModelAndView mav) {
		
		return "index";
	}
	
}
