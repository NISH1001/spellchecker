package com.codingparadox.utilities;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Sorter {

	public static Map<String, Integer> sort(Map<String, Integer> unsortedMap){
		boolean asc = true;
		List<Entry<String, Integer>> list = new LinkedList<Entry<String, Integer>>(unsortedMap.entrySet());
		Collections.sort(list, new Comparator<Entry<String, Integer>>() {

			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				if(asc){
					return o1.getValue().compareTo(o2.getValue());
				}
				else{
					return o2.getValue().compareTo(o1.getValue());
				}
			}
		});
		Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
		for (Entry<String, Integer> entry : list)
		{
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		return sortedMap;
	}

	public static List<Entry<String, Integer>> sortAsList(Map<String, Integer> unsortedMap){
		boolean asc = true;
		List<Entry<String, Integer>> list = new LinkedList<Entry<String, Integer>>(unsortedMap.entrySet());
		Collections.sort(list, new Comparator<Entry<String, Integer>>() {

			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				if(asc){
					return o1.getValue().compareTo(o2.getValue());
				}
				else{
					return o2.getValue().compareTo(o1.getValue());
				}
			}
		});
		return list;
	}
}
