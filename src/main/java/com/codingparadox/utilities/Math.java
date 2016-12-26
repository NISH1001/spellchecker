package com.codingparadox.utilities;

public class Math {
	
	public static int min(int...nums){
		int min = nums[0];
		for(int i=1; i<nums.length; ++i){
			if(nums[i] < min){
				min = nums[i];
			}
		}
		return min;
	}
}
