package com.jmf.palindrome.exception;

public class NotAPalindromeExcetption extends RuntimeException{

	private static final long serialVersionUID = -7895838153611124965L;
	public static final String MSG_THIS_IS_NOT_A_PALINDROME = "This is not a palindrome";
	
	public NotAPalindromeExcetption(String msg) {
		super(msg);
	}
}
