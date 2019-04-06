package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.UserDto;
import com.example.demo.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping("/login")
	public String goToLoginPage() {
		return "login";
	}
	
	@RequestMapping(value="/validateUser",method=RequestMethod.POST)
	public String validateUser(@RequestParam("username") String username,@RequestParam("password") String password) {
		
		UserDto userDto = loginService.findUserByUsernameAndPassword(username,password);
		
		
		if(userDto == null) {
			return "redirect:login";
		}else {
			return "dashboard";
		}
		
		
		
	}
	
	

}
