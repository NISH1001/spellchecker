package com.codingparadox.languagemodel;

import java.util.ArrayList;
import java.util.List;

/**
 * This is a placeholder Dictionary class.
 * In later version, this will be replaced by ngram models
 * 
 * @author paradox
 *
 */
public class Dictionary {
	private List<String> correctWords;
	
	public Dictionary(){
		correctWords = new ArrayList<String>();
		this.init();
	}
	
	/**
	 * 
	 * @return List List of correct words
	 */
	public List<String> getCorrectWords(){
		return this.correctWords;
	}
	
	/**
	 * This is a function to to initialize the
	 * dictionary manually with correct words
	 */
	public void init(){
		//this.correctWords.add("kitten");
		this.correctWords.add("kathmandu");
		this.correctWords.add("cat");
		this.correctWords.add("dog");
		this.correctWords.add("litter");
		this.correctWords.add("sitting");
	}
}
