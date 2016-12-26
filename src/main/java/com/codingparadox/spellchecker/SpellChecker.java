package com.codingparadox.spellchecker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.codingparadox.languagemodel.Dictionary;
import com.codingparadox.spellchecker.LevenshteinDistance;

/**
 * This class checks the spelling of the inputword
 * 
 * @author paradox
 *
 */
public class SpellChecker {
	// Dictionary with correct words
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
	
	/**
	 * This function is used to generate
	 * words and corresponding cost for matching
	 * the input word
	 * 
	 * @param word This is the input word
	 * @return Map 
	 */
	public Map<String, Integer> checkSpelling(String word){
		Map<String, Integer> result = new HashMap<String, Integer>();
		for(String s : this.dictionary.getCorrectWords()){
			LevenshteinDistance ld = new LevenshteinDistance();
			int cost = ld.calculateDistance(word, s);
			result.put(s, cost);
		}
		return  result;
	}
	
	/**
	 * This function returns the list of strings using threshold for
	 * the cost of levenstein distance
	 * 
	 * @param map
	 * @param thresholdCost
	 * @return
	 */
	public List<String> match(Map<String, Integer> map, int thresholdCost){
		List<String> list = new ArrayList<String>();
		for(String s : map.keySet()){
			if(map.get(s) <= thresholdCost){
				list.add(s);
			}
		}
		return list;
	}
	
	/**
	 * This function returns a single string with minimum cost value
	 * of Levenstein distance
	 * 
	 * @param map
	 * @param thresholdCost
	 * @return
	 */
	public String matchOnly(Map<String, Integer> map, int thresholdCost){
		int min = thresholdCost;
		String word = null;
		for(String s : map.keySet()){
			int val = map.get(s);
			if(val < min){
				min = val;
				word = s;
			}
		}
		return word;
	}
}
