package com.jmf.palindrome;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.jmf.palindrome.config.PalindromeConfig;
import com.jmf.palindrome.exception.NotAPalindromeExcetption;
import com.jmf.palindrome.service.PalindromeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PalindromeConfig.class, loader=AnnotationConfigContextLoader.class)
public class PalindromeServiceTest {

	@Autowired
	private PalindromeService palindromeService;
	
	@Test(expected = NotAPalindromeExcetption.class)
    public void notAPalindrome2(){
        palindromeService.check("hello");
    }
	
	@Test
	public void palindromeAManAPlanACanalPanama() {
		palindromeService.check("A MAN A PLAN A CANAL PANAMA");
	}
	
	@Test
	public void palindromeAManAPlanACanalPanamaWithSpecialChars() {
		palindromeService.check("A%MAN*A@PLAN-A/CANAL-PANAMA");
	}
	
	@Test(expected = NotAPalindromeExcetption.class)
	public void sendEmptyWord() {
		palindromeService.check("");
	}
}
