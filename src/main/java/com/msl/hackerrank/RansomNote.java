package com.msl.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class RansomNote {

	// Complete the checkMagazine function below.
	static void checkMagazine(String[] magazine, String[] note) {
		String yesWeCan = "Yes";
		List<String> magazineList = new LinkedList<String>(Arrays.asList(magazine));
		for (int i = 0; i < note.length; i++) {
			String word = note[i];
			if(magazineList.contains(word)) {
				magazineList.remove(word);
			}else {
				yesWeCan = "No";
				break;
			}
		}
		System.out.println(yesWeCan);
	}

	private static final BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		String[] mn = scanner.readLine().split(" ");
		int m = Integer.parseInt(mn[0]);
		int n = Integer.parseInt(mn[1]);
		String[] magazine = new String[m];
		String[] magazineItems = scanner.readLine().split(" ");
//		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		for (int i = 0; i < m; i++) {
			String magazineItem = magazineItems[i];
			magazine[i] = magazineItem;
		}
		String[] note = new String[n];
		String[] noteItems = scanner.readLine().split(" ");
//		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		for (int i = 0; i < n; i++) {
			String noteItem = noteItems[i];
			note[i] = noteItem;
		}
		checkMagazine(magazine, note);
		scanner.close();
	}
}
