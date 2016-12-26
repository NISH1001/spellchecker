package com.codingparadox.spellchecker;

import java.util.HashMap;
import java.util.Map;

import com.codingparadox.languagemodel.Dictionary;

public class SpellChecker {
	private Dictionary dictionary;
	
	public SpellChecker(){
		this.dictionary = new Dictionary();
	}

	public SpellChecker(Dictionary dictionary){
		this.dictionary = dictionary;
	}
	
	public void setDictionary(Dictionary dictionary){
		this.dictionary = dictionary;
	}
	
	public Map<String, Integer> checkSpelling(String word){
		Map<String, Integer> result = new HashMap<String, Integer>();
		
		for(String s : this.dictionary.getCorrectWords()){
			LevenshteinDistance ld = new LevenshteinDistance();
			int cost = ld.calculateDistance(word, s);
			result.put(s, cost);
		}
		return  result;
	}
}
