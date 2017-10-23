package com.jmf.palindrome;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.jmf.palindrome.checker.PalindromeCheckerComponent;
import com.jmf.palindrome.config.PalindromeConfig;
import com.jmf.palindrome.exception.NotAPalindromeExcetption;
import com.jmf.palindrome.service.PalindromeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PalindromeConfig.class, loader=AnnotationConfigContextLoader.class)
public class PalindromeComponentTest{
    
	@Autowired
	private PalindromeCheckerComponent palindromeCheckerComponent;

	@Test(expected = NotAPalindromeExcetption.class)
    public void notAPalindrome(){
        palindromeCheckerComponent.check("hello");
    }
	
	@Test
	public void palindromeAManAPlanACanalPanama() {
		palindromeCheckerComponent.check("A MAN A PLAN A CANAL PANAMA");
	}
	
	@Test
	public void palindromeAManAPlanACanalPanamaWithSpecialChars() {
		palindromeCheckerComponent.check("A%MAN*A@PLAN-A/CANAL-PANAMA");
	}
	
	@Test(expected = NotAPalindromeExcetption.class)
	public void sendEmptyWord() {
		palindromeCheckerComponent.check("");
	}
	
}
