package com.codingparadox;

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
		SpellChecker spellChecker = new SpellChecker();
		Map<String, Integer> matches = spellChecker.checkSpelling("kitten");
		System.out.println(matches);
	}

}
