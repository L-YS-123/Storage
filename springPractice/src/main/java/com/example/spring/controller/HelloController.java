package com.example.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	@GetMapping("hello")
	public String hello(Model model) {
		model.addAttribute("data","spring!!!");
		return "hello";
	}
	
	@GetMapping("hello-mvc") // 페이지 소스 보기1 <-> html 소스가 있음
	public String helloMvc(@RequestParam("name") String name, Model model ) {
		model.addAttribute("name", name);
		return "hello-template"; //값을 넘겨줄 view의 파일명
	}
	
	@GetMapping("hello-string")
	@ResponseBody //html에 데이터를 직접 넣어주는 용도 -> 페이지 소스 보기 2 <-> html 소스가 없음 -> http body에 데이터를 그냥 던짐
	public String helloString(@RequestParam("name") String name) {
		return "hello " + name;
	}

	
	//*중요. JSON(KEY : VALUE)형식으로 출력(반환)됨  
	//객체가 반환되면 default로 데이터 형식을 JSON으로 반환
	@GetMapping("hello-api")
	@ResponseBody
	public Hello helloApi(@RequestParam("name") String name) {
		Hello hello = new Hello();
		hello.setName(name);
		return hello;
	}
	
	static class Hello {
		private String name;
		
		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name=name;
		}
		
	}
	
	
}
