package hish.hr.alg.impl;

import java.util.Scanner;

/**
 * 
 * [SOLVED]
 * @author shisham
 *
 */
public class SherlockAndSquares {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int[] r = new int[t];
		for (int j = 0; j < t; j++) {
			double start = in.nextDouble();
			double end = in.nextDouble();
			int count = 0;
			double thisSqrt = -1;
			double i = start;
			for (i = start; i <= end;) {
				if(thisSqrt != -1) {
					thisSqrt++;
					i = Math.pow(thisSqrt, 2);
					if(i <= end) {
						count++;
//						System.out.println(i);
					}
					continue;
				}
				if (isSquareNumber(i)) {
					thisSqrt = Math.sqrt(i);
					count++;
//					System.out.println(i);
				}
				i++;
			}
			r[j] = count;
		}
		for (int j = 0; j < t; j++) {
			System.out.println(r[j]);
		}
	}

	static boolean isSquareNumber(double n) {
		double s = Math.sqrt(n);
		double c = Math.ceil(s);
		return s == c;
	}
}
