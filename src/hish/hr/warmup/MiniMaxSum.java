package hish.hr.warmup;

import java.util.Arrays;
import java.util.Scanner;

public class MiniMaxSum {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long a = in.nextLong();
        long b = in.nextLong();
        long c = in.nextLong();
        long d = in.nextLong();
        long e = in.nextLong();
        long[] arr = {a,b,c,d,e};
        Arrays.sort(arr);
        
        long minsum = 0;
        int i = 0;
        while(i < 4) {
        	minsum += arr[i++];
        }
        
        long maxsum = 0;
        int j = arr.length;
        while(--i >= 0) {
        	maxsum += arr[--j];
        }
        
        System.out.println(minsum + " " + maxsum);
    }

}
