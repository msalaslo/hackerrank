package com.msl.hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RotateArray {
	// Complete the rotLeft function below.
	static int[] rotLeft(int[] a, int d) {
		int[] c  = a;
		for (int i = 0; i < d; i++) {
			c = rotLeft(c);
		}
		return c;
	}
	
	static int[] rotLeft(int[] a) {
		int[] b = new int[a.length];
		b[a.length - 1] = a[0];
		for (int i = 0; i < a.length - 1; i++) {
			b[i] = a[i+1];
		}
		return b;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("c:\\temp\\test.txt"));

		String[] nd = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nd[0]);

		int d = Integer.parseInt(nd[1]);

		int[] a = new int[n];

		String[] aItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int aItem = Integer.parseInt(aItems[i]);
			a[i] = aItem;
		}

		int[] result = rotLeft(a, d);

		for (int i = 0; i < result.length; i++) {
			bufferedWriter.write(String.valueOf(result[i]));

			if (i != result.length - 1) {
				bufferedWriter.write(" ");
			}
		}

		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}

}
