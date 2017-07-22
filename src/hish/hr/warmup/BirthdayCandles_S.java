package hish.hr.warmup;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/birthday-cake-candles/problem
 * Created by shisham on 22-Jul-17.
 */
public class BirthdayCandles_S {
    static int birthdayCakeCandles(int n, int[] ar) {
        // Complete this function
        int tallest = -1;
        int noC = 0;
        for(int i=0;i<ar.length;i++) {
            if(ar[i] > tallest) {
                noC = 1;
                tallest = ar[i];
            } else if(ar[i] == tallest) {
                noC++;
            }
        }
        return noC;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = birthdayCakeCandles(n, ar);
        System.out.println(result);
    }
}
