package hish.hr.alg.impl;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/cavity-map
 * 
 * @author shisham
 *
 */
public class CavityMap {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[][] grid = new int[n][n];

		for (int grid_i = 0; grid_i < n; grid_i++) {
			String s = in.next();
			grid[grid_i] = toIntArray(s);
		}

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (i == 0 || j == 0 || i == grid.length - 1 || j == grid[i].length - 1) {
					System.out.print(grid[i][j]);
				} else {
					int depth = grid[i][j];
					int abovePit = grid[i - 1][j];
					int b4Pit = grid[i][j - 1];
					int nextPit = grid[i][j + 1];
					int belowPit = grid[i + 1][j];
					if (depth > b4Pit && depth > nextPit && depth > abovePit && depth > belowPit)
						System.out.print("X");
					else
						System.out.print(grid[i][j]);
				}
			}
			System.out.println();
		}
		
		in.close();
	}

	private static int[] toIntArray(String s) {
		char[] carray = s.toCharArray();
		int[] array = new int[s.length()];
		for (int i = 0; i < carray.length; i++) {
			array[i] = Character.getNumericValue(carray[i]);
		}
		return array;
	}
}
