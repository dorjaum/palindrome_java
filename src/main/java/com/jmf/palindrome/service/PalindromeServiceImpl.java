package com.jmf.palindrome.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmf.palindrome.checker.PalindromeCheckerComponent;

@Service
public class PalindromeServiceImpl implements PalindromeService{

	@Autowired
	private PalindromeCheckerComponent palindromeCheckerComponent;
	
	public void check(String word) {
		palindromeCheckerComponent.check(word);
	}

}
