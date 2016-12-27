package com.codingparadox;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.codingparadox.languagemodel.Dictionary;
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
		Main.testSpelling(word);
	}
	
	public static void testSpelling(String word){
		Dictionary dictionary = new Dictionary();
		dictionary.loadFromFile("data/dictionary");

		SpellChecker spellChecker = new SpellChecker(dictionary);

		Map<String, Integer> words = spellChecker.getCostMap(word);
		List<String> sortedWords = spellChecker.match(word, 0.2);
		//List<String> matches = spellChecker.match(words, threshold);

		System.out.println("Matching to all the words in dictionary :  ");
		System.out.println(words);
		System.out.println(sortedWords);
		
	}

}
