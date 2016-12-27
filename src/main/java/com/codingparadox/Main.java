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
		String word = "pardx";
		int threshold = 3;
		SpellChecker spellChecker = new SpellChecker();

		Map<String, Integer> words = spellChecker.getCostMap(word);
		List<String> sortedWords = spellChecker.match(word, 0.2);
		//List<String> matches = spellChecker.match(words, threshold);

		System.out.println("Matching to all the words in dictionary : ");
		System.out.println(words);
		System.out.println(sortedWords);
		
	}

}
