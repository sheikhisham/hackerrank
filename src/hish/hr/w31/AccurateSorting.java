/**
 * 
 */
package hish.hr.w31;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/contests/w31/challenges/accurate-sorting
 * [Solved]
 * @author shisham
 *
 */
public class AccurateSorting {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		boolean res[] = new boolean[q];
		for (int a0 = 0; a0 < q; a0++) {
			int n = in.nextInt();
			int[] a = new int[n];
			for (int a_i = 0; a_i < n; a_i++) {
				a[a_i] = in.nextInt();
			}
			res[a0] = isAccurateSortable(a);
		}

		for (boolean r : res) {
			System.out.println(r ? "Yes" : "No");
		}
		
		in.close();
	}

	private static boolean isAccurateSortable(int[] a) {

		for (int i = 0; i < a.length - 1; i++) {
			if (a[i] > a[i + 1]) {
				if (Math.abs(a[i + 1] - a[i]) != 1) {
					return false;
				}
				int t = a[i + 1];
				a[i + 1] = a[i];
				a[i] = t;
			}
		}

		return true;
	}
}
