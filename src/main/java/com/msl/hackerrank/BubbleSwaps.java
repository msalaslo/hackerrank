package com.msl.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BubbleSwaps {

	// Complete the countSwaps function below.
	static void countSwaps(Integer[] a) {
		List<Integer> list = new LinkedList<Integer>(Arrays.asList(a));
		boolean sorted = false;
		int lastSorted = list.size() - 1;
		int numSwaps = 0;
		while (!sorted) {
			sorted = true;
			for (int j = 0; j < lastSorted; j++) {
				// Swap adjacent elements if they are in decreasing order
				if (list.get(j) > list.get(j + 1)) {
					swap(list, j);
					numSwaps += 1;
					sorted = false;
				}
			}
			lastSorted--;
		}
		System.out.println("Array is sorted in " + numSwaps + " swaps.");
		System.out.println("First Element: " + list.get(0));
		System.out.println("Last Element: " + list.get(list.size() - 1));
	}

	static void swap(List<Integer> list, int index) {
		Integer aux = list.get(index);
		list.set(index, list.get(index + 1));
		list.set(index + 1, aux);
	}

	private static final BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		int n = Integer.parseInt(scanner.readLine());
		Integer[] a = new Integer[n];
		String[] aItems = scanner.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			Integer aItem = Integer.parseInt(aItems[i]);
			a[i] = aItem;
		}
		countSwaps(a);
		scanner.close();
	}
}
