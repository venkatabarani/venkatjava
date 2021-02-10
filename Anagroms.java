package com.java8.ooad.workouts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Program to output the anagrams
 * 
 * @author Venkat
 *
 */
public class Anagroms {

	public static void main(String[] args) {
		String[] wordArray = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Ïnput");
			wordArray =br.readLine().split(",");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HashMap<Integer, List<String>> wordIntMap = new HashMap<Integer, List<String>>();
		for(int i=0;i<wordArray.length;i++) {
			int wordCharTotal = 0;
			char[] charArray = wordArray[i].toCharArray();
			for(int k=0;k<charArray.length;k++) {
				wordCharTotal+=(int)charArray[k];
			}
			if(wordIntMap.get(wordCharTotal) == null) {
				List<String> stringList = new ArrayList<String>();
				stringList.add(wordArray[i]);
				wordIntMap.put(wordCharTotal, stringList);
			} else{
				List<String> list = wordIntMap.get(wordCharTotal);
				list.add(wordArray[i]);
			}
		}
		System.out.println(wordIntMap.values());
	}
}
