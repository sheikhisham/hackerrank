/**
 * 
 */
package hish.hr.alg.impl;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/encryption?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=7-day-campaign
 * 
 * @author shisham
 *
 */
public class Encryption {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		String inStr = in.nextLine();
		inStr = inStr.replaceAll("\\s", "");
		int len = inStr.length();
		int floor = (int) Math.floor(Math.sqrt(len));
		int ceil = (int) Math.ceil(Math.sqrt(len));
		
//		System.out.println(floor + " x " + ceil);

		char[][] m = new char[floor][ceil];

		int k = 0;
		char[] inc = inStr.toCharArray();
		for (int i = 0; i < floor && k < inc.length; i++) {
			for (int j = 0; j < ceil && k < inc.length; j++) {
				m[i][j] = inc[k++];
			}
		}

		StringBuilder s = new StringBuilder();
		for (int i = 0; i < ceil; i++) {
			for (int j = 0; j < floor; j++) {
//				System.out.print(m[j][i]);
				s.append(m[j][i]);
			}
			s.append(" ");
//			System.out.println();
		}

		System.out.println(s.toString().trim());
	}
}
