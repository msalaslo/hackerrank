package com.msl.hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TwoDArray {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int[][] arraySumas = new int[4][4];
        for(int i = 0; i< 4; i++){
            for(int j=0; j< 4; j++){
                int[][] singleHourglass = new int[3][3];
                singleHourglass[0][0] = arr[i+0][j+0]; 
                singleHourglass[0][1] = arr[i+0][j+1]; 
                singleHourglass[0][2] = arr[i+0][j+2]; 
                singleHourglass[1][0] = 0;
                singleHourglass[1][1] = arr[i+1][j+1];
                singleHourglass[1][2] = 0;
                singleHourglass[2][0] = arr[i+2][j+0]; 
                singleHourglass[2][1] = arr[i+2][j+1]; 
                singleHourglass[2][2] = arr[i+2][j+2]; 
                arraySumas[i][j] = singleHourglassSum(singleHourglass);
            }
        }
        return max(arraySumas);
    }

    static int max(int[][] arraySumas){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i< arraySumas.length; i++){
        	for(int j = 0; j< arraySumas[0].length; j++){
	            if(arraySumas[i][j] > max){
	                max = arraySumas[i][j];
	            }
        	}
        }
        return max;
    }

    static int singleHourglassSum(int[][] arr){
        int result = sumaFila(getRow(arr, 0));
        result +=arr[1][1];
        result += sumaFila(getRow(arr, 2));
        return result;
    }

    static int[] getRow(int[][] arr, int pos){
        int[] row = new int[arr.length];
        for(int j=0; j<arr[0].length; j++){
            row[j] = arr[pos][j];
        }
        return row;
    }

    static int sumaFila(int[] arr){
        int result = 0;
        for(int i=0;i < arr.length; i++){
            result += arr[i];
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("c:\\temp\\test.txt"));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
