package com.codingparadox.languagemodel;

import java.util.ArrayList;
import java.util.List;

public class Dictionary {
	private List<String> correctWords;
	
	public Dictionary(){
		correctWords = new ArrayList<String>();
		this.init();
	}
	
	public List<String> getCorrectWords(){
		return this.correctWords;
	}
	
	public void init(){
		//this.correctWords.add("kitten");
		this.correctWords.add("kathmandu");
		this.correctWords.add("cat");
		this.correctWords.add("dog");
		this.correctWords.add("litter");
		this.correctWords.add("sitting");
	}
}
