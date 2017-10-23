package com.jmf.palindrome.checker;

import static com.jmf.palindrome.exception.NotAPalindromeExcetption.MSG_THIS_IS_NOT_A_PALINDROME;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.jmf.palindrome.exception.NotAPalindromeExcetption;

@Component
public class PalindromeCheckerComponent {

	public void check(String word) {
		validate(word);
		
		String[] firstHalfArray = getFirstHalfAsArray(getWordWithouSpecialCharacters(word));
		String[] secondHalfReversedArray = getSecondHalfReversedAsArray(getWordWithouSpecialCharacters(word));
		
		for (int position = 0; position < firstHalfArray.length; position++) {
			if(!firstHalfArray[position].equals(secondHalfReversedArray[position])) {
				throw new NotAPalindromeExcetption(MSG_THIS_IS_NOT_A_PALINDROME);
			}
		}
	}

	private String[] getSecondHalfReversedAsArray(String word) {
		int wordLength = word.length();
		int cutPosition = 0;
		
		if(isPairLengthWord(wordLength)) {
			cutPosition = wordLength/2;
		}else {
			cutPosition = wordLength/2 + 1;
		}
		
		String secondHalf = word.substring(cutPosition, wordLength);
		String reversedWord = new StringBuilder(secondHalf).reverse().toString();
		String[] secondHalfArray = reversedWord.split("");
		
		return secondHalfArray;
	}

	private String[] getFirstHalfAsArray(String word) {
		int wordLength = word.length();
		String firstHalf = word.substring(0, wordLength/2);
		String[] firstHalfArray = firstHalf.split("");
		
		return firstHalfArray;
	}

	private boolean isPairLengthWord(int wordLength) {
		return Math.floorMod(wordLength, 2) == 0;
	}
	

	private void validate(String word) {
		wordIsEmptyOrNull(word);
	}

	private void wordIsEmptyOrNull(String word) {
		if(StringUtils.isEmpty(word)) {
			throw new NotAPalindromeExcetption(MSG_THIS_IS_NOT_A_PALINDROME);
		};
		
	}

	private String getWordWithouSpecialCharacters(String word) {
		return word.replaceAll("[^a-zA-Z]+","").toUpperCase();
	}

}
