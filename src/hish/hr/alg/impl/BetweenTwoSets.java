package hish.hr.alg.impl;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/between-two-sets
 * @author shisham
 *
 */
public class BetweenTwoSets {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[] a = new int[n];
		for (int a_i = 0; a_i < n; a_i++) {
			a[a_i] = in.nextInt();
		}
		int[] b = new int[m];
		for (int b_i = 0; b_i < m; b_i++) {
			b[b_i] = in.nextInt();
		}

		int count = 0;
		for (int i = a[a.length - 1]; i <= b[0]; i++) {
			/* check all members of a is a factors of i
			*  and
			*  i is a factor if all members of b
			**/
			if(isFactorsOf(a, i) && isFactorofList(i, b)) {
				count++;
			}
		}
		
		System.out.println(count);
	}
	
	private static boolean isFactorofList(int factor, int[] nums) {
		for (int i : nums) {
			if (!isFactorOf(factor, i)) {
				return false;
			}
		}
		return true;
	}
	
	private static boolean isFactorsOf(int[] factors, int num) {
		for (int at : factors) {
			if (!isFactorOf(at, num)) {
				return false;
			}
		}
		return true;
	}

	private static boolean isFactorOf(int factor, int num) {
		return num % factor == 0;
	}
}
