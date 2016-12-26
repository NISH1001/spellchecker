package com.codingparadox;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.codingparadox.spellchecker.LevenshteinDistance;
import com.codingparadox.spellchecker.SpellChecker;
import com.codingparadox.utilities.Math;

public class Main {
	
	public static void main(String[] args){
/*		LevenshteinDistance ld = new LevenshteinDistance();
		System.out.println(ld.calculateDistance("kitten", "sitting"));
		ld.display();
*/	
		String word = "kitten";
		int threshold = 3;
		SpellChecker spellChecker = new SpellChecker();

		Map<String, Integer> words = spellChecker.checkSpelling(word);
		List<String> matches = spellChecker.match(words, threshold);

		System.out.println(words);
		System.out.println("Nearest matches to " + word);
		System.out.println(matches);
		
		String matchOnly = spellChecker.matchOnly(words, threshold);
		System.out.println(matchOnly);
	}

}
