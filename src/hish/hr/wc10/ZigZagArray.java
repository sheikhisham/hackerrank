/**
 * 
 */
package hish.hr.wc10;

import java.util.Scanner;

/**
 * @author shisham
 *
 */
public class ZigZagArray {

	static int minimumDeletions(int[] a) {
		return 0;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		// int n = in.nextInt();
		// int[] a = new int[n];
		// for (int a_i = 0; a_i < n; a_i++) {
		// a[a_i] = in.nextInt();
		// }
		int[] a = { 4, 2, 6, 3, 10, 1 };
		// Return the minimum number of elements to delete to make the array
		// zigzag
		int result = minimumDeletions(a);
		System.out.println(isZigZag(a));
	}

	static boolean isZigZag(int[] a) {
		int stat = stat(a[0], a[1]);
		for (int i = 1; i < a.length - 1; i++) {
			int cs = stat(a[i], a[i + 1]);
			if (cs != stat) {
		
			} else {
				
			}
			stat = cs;
		}
		return false;
	}

	static int stat(int a, int b) {
		return a - b > 0 ? 1 : -1;
	}

}
