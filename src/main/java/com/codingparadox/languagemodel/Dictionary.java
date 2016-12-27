package com.codingparadox.languagemodel;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
		//this.correctWords.clear();
		this.loadManually();
		//this.loadFromFile("data/dictionary");
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
	public void loadManually(){
		//this.correctWords.add("kitten");
		this.correctWords.add("kathmandu");
		this.correctWords.add("cat");
		this.correctWords.add("dog");
		this.correctWords.add("litter");
		this.correctWords.add("sitting");
	}
	
	public void clear(){
		this.correctWords.clear();
	}
	
	public void loadFromFile(String filename){
		ClassLoader classLoader = getClass().getClassLoader();
		String absolutePath = classLoader.getResource(filename).getPath();
		Set<String> set = new HashSet<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(absolutePath) );
			String line;
			while( (line=br.readLine()) != null){
				line = line.toLowerCase().trim();
				if(line.isEmpty()){
					continue;
				}
				line = line.replaceAll("([!,.']+)", "");
				String[] splitted = line.split("\\s+");
				//this.correctWords.addAll(Arrays.asList(splitted));
				set.addAll(Arrays.asList(splitted));
				System.out.println(line);
			}
			br.close();
			this.correctWords.addAll(set);
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
		}
		
	}
}
