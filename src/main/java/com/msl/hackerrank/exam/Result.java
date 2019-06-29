package com.msl.hackerrank.exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Result {

	/*
	 * Complete the 'cutBamboo' function below.
	 *
	 * The function is expected to return an INTEGER_ARRAY. The function accepts
	 * INTEGER_ARRAY lengths as parameter.
	 */

	public static List<Integer> cutBamboo(List<Integer> lengths) {
		// Write your code here
		List<Integer> ret = new ArrayList<Integer>();
		ret.add(lengths.size());
		List<Integer> modifiedList = getModifiedList(lengths);
		while (!modifiedList.isEmpty()) {
			ret.add(lengths.size());
			modifiedList = getModifiedList(lengths);
		}
		return ret;
	}

	static List<Integer> getModifiedList(List<Integer> list) {
		int min = getMin(list);
		list = removeAll(list, new Integer(min));
		return restarMin(list, min);
	}
	
	static List<Integer> removeAll (List<Integer> list, Integer o) {
		boolean todos = false;
		while(!todos) {
			todos = list.remove(o);
		}
		return list;
	}

	public static int getMin(List<Integer> list) {
		int min = Integer.MAX_VALUE;
		for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext();) {
			Integer corte = (Integer) iterator.next();
			if (corte < min) {
				min = corte;
			}
		}
		return min;
	}

	public static List<Integer> restarMin(List<Integer> list, int min) {
		List<Integer> ret = new ArrayList<Integer>();
		for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext();) {
			Integer corte = (Integer) iterator.next();
			ret.add(corte - min);
		}
		return ret;
	}
	
	private static final BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		List<Integer> a = new ArrayList<Integer>();
		String[] aItems = scanner.readLine().split(" ");
		for (int i = 0; i < aItems.length; i++) {
			Integer aItem = Integer.parseInt(aItems[i]);
			a.add(aItem);
		}
		cutBamboo(a);
		scanner.close();
	}

}
