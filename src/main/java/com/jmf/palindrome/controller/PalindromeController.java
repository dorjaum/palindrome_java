package com.jmf.palindrome.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jmf.palindrome.exception.NotAPalindromeExcetption;
import com.jmf.palindrome.service.PalindromeService;

@Controller
@RequestMapping("/palindrome")
public class PalindromeController {

	@Autowired
	private PalindromeService palindromeService;
	
	@RequestMapping(value = "/check", method = {RequestMethod.POST})
	@ResponseBody
	public void checkPalindrome(@RequestBody String word) {
		palindromeService.check(word);
	}
	
	
	@ExceptionHandler(NotAPalindromeExcetption.class)
	public void exceptionHandler(HttpServletRequest request, HttpServletResponse response) {
		response.setStatus(400);
	}
}
