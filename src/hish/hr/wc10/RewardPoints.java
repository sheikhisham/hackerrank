/**
 * 
 */
package hish.hr.wc10;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/contests/world-codesprint-10/challenges/reward-points
 * 
 * @author shisham
 *
 */
public class RewardPoints {

	static int getPoints(int month1, int month2, int month3) {
		return getRewardPoints(month1) + getRewardPoints(month2) + getRewardPoints(month3);
	}

	static int getRewardPoints(int swipes) {
		if (swipes > 10) {
			swipes = 10;
		}
		return swipes * 10;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int month1 = in.nextInt();
		int month2 = in.nextInt();
		int month3 = in.nextInt();
		int pointsEarned = getPoints(month1, month2, month3);
		System.out.println(pointsEarned);
	}

}
