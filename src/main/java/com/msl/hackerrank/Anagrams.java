package com.msl.hackerrank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Anagrams {

	// Complete the makeAnagram function below.
	static int makeAnagram(String a, String b) {
    	String anagram = getAnagram(a,b);
    	int removedFromA = removedChars(a, anagram);
    	int removedFromB = removedChars(b, anagram);
    	int total = removedFromA + removedFromB;
    	return total;
    }
	
	static String removeRepetedChars(String a) {
		StringBuilder sb = new StringBuilder();
		a.chars().distinct().forEach(c -> sb.append((char) c));
		return sb.toString();
	}

	static String getAnagram(String a, String b) {
		String anagram = "";
		for (int i = 0; i < a.length(); i++) {
			String chara = a.substring(i, i + 1);
			if (b.contains(a.substring(i, i + 1))) {
				if(!anagram.contains(chara)) {
					anagram += chara;
				}
			}
		}
		return anagram;
	}

	static int removedChars(String a, String anagram) {
		int cont = 0;
		for (int i = 0; i < a.length(); i++) {
			String chara = a.substring(i, i + 1);
			if (!anagram.contains(chara)) {
				cont++;
			}else {
				anagram = anagram.replaceFirst(chara, "");
			}
		}
		return cont;
	}

	private static final BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("c:\\temp\\test.txt"));

        String a = scanner.readLine();
		String b = scanner.readLine();
		int res = makeAnagram(a, b);
		bufferedWriter.write(String.valueOf(res));
		bufferedWriter.newLine();
		bufferedWriter.close();
		scanner.close();
	}
}
