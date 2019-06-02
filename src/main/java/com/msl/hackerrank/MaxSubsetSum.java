package com.msl.hackerrank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MaxSubsetSum {

	    // Complete the maxSubsetSum function below.
	    static int maxSubsetSum(int[] arr) {
	    	List<Integer> sums = new ArrayList<Integer>();
	    	for (int i = 0; i < arr.length; i++) {
				for (int j = 2; j < arr.length; j++) {
					List<Integer> subset = new ArrayList<Integer>();
		    		for (int k = i; k <= arr.length - i; k += j) {
						subset.add(arr[k]);
			    		sums.add(sum(subset));
					}
				}
			}
	    	return max(sums);
	    }
	    static int sum(List<Integer> list) {
	    	int sum = 0;
	    	for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext();) {
				int object = (int) iterator.next();
				sum += object;
			}
	    	return sum;
	    }
	    
	    static int max(List<Integer> list) {
	    	int max = Integer.MIN_VALUE;
	    	for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext();) {
				Integer integer = (Integer) iterator.next();
				if(integer > max) {
					max = integer;
				}
			}
	    	return max;
	    }

		private static final BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));

	    public static void main(String[] args) throws IOException {
	        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("c:\\temp\\test.txt"));
			int n = Integer.parseInt(scanner.readLine());
	        int[] arr = new int[n];
	        String[] arrItems = scanner.readLine().split(" ");
	        for (int i = 0; i < n; i++) {
	            int arrItem = Integer.parseInt(arrItems[i]);
	            arr[i] = arrItem;
	        }
	        int res = maxSubsetSum(arr);
	        bufferedWriter.write(String.valueOf(res));
	        bufferedWriter.newLine();
	        bufferedWriter.close();
	        scanner.close();
	    }
	}
