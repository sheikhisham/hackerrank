/**
 * 
 */
package hish.hr.alg.impl;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/the-grid-search
 * 
 * @author shisham
 *
 */
public class GridSearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		boolean[] res = new boolean[t];
		for (int a0 = 0; a0 < t; a0++) {
			int R = in.nextInt();
			int C = in.nextInt();
			String[] G = new String[R];
			for (int G_i = 0; G_i < R; G_i++) {
				G[G_i] = in.next();
			}
			int r = in.nextInt();
			int c = in.nextInt();
			String[] P = new String[r];
			for (int P_i = 0; P_i < r; P_i++) {
				P[P_i] = in.next();
			}
			res[a0] = isPatternFound(G, P);
		}

		for (boolean r : res) {
			System.out.println(r ? "YES" : "NO");
		}
	}

	private static boolean isPatternFound(String[] gd, String[] pd) {
		return false;
	}

}
