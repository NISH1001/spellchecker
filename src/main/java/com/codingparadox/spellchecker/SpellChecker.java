package com.codingparadox.spellchecker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.codingparadox.languagemodel.Dictionary;
import com.codingparadox.spellchecker.LevenshteinDistance;
import com.codingparadox.utilities.Sorter;

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
		this.dictionary.clear();
		this.dictionary.loadFromFile("data/dictionary");
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
	public Map<String, Integer> getCostMap(String word){
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
	 * the cost of levenstein distance.
	 * It uses pre-generated HashMap with (word,cost) combo to
	 * filter out the result based on threshold.
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
	 * of Levenstein distance.
	 * It uses HashMap to filter out the result based on threshold cost.
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
	
	/**
	 * This function returns the list of words that are close
	 * to the input word. The list actually contains first 'n' words
	 * arranged in ascending order by edit distance/cost;
	 * 
	 * 
	 * @param word This is the input word
	 * @param percentile This is the value to slice the list
	 * @return List
	 */
	public List<String> match(String word, double percentile){
		//percentile = 1-percentile;
		List<String> words = new ArrayList<String>();
		Map<String, Integer> map = this.getCostMap(word);

		List<Entry<String, Integer>> entries = Sorter.sortAsList(map);
		for(int i=0; i<(int)map.size()*percentile; ++i){
			words.add(entries.get(i).getKey());
		}
		return words;
	}
}
