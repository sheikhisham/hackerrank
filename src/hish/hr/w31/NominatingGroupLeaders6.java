package hish.hr.w31;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/contests/w31/challenges/nominating-group-leaders
 * [My Best]
 * @author shisham
 *
 */
public class NominatingGroupLeaders6 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		List<Integer[]> resL = new ArrayList<>();
		for (int a0 = 0; a0 < t; a0++) {
			int n = in.nextInt();
			int[] v = new int[n];
			int[] vFromClass = new int[n];
			for (int v_i = 0; v_i < n; v_i++) {
				v[v_i] = in.nextInt();
				vFromClass[v[v_i]]++;
			}
			int g = in.nextInt();
			Integer[] res = new Integer[g];
			int lastl = 0;
			int lastr = v.length-1;
//			System.out.println("\n> "+Arrays.toString(vFromClass));
			for (int a1 = 0; a1 < g; a1++) {
				int l = in.nextInt();
				int r = in.nextInt();
				int x = in.nextInt();
				res[a1] = findWinner2(v, vFromClass, l, r, x, lastl, lastr);
//				System.out.println(Arrays.toString(vFromClass));
				lastl = l;
				lastr = r;
			}
			resL.add(res);
		}

		for (Integer[] res : resL) {
			for (int w : res) {
				System.out.println(w);
			}
		}

		in.close();
	}
	
	public static Integer findWinner2(int[] v, int[] vFromGroup, int l, int r, int x, int lastl, int lastr) {
		
//		if(l > lastr || r < lastl) {
//			return findFreshWinner(v, vFromGroupOrig, l, r, x);
//		}
		
		if(lastl == l) {
			
		}
		else if(l > lastl) {
			for (int i = lastl; i < l; i++) {
				vFromGroup[v[i]]--;
			}
		} else {
			for (int i = l; i < lastl; i++) {
				vFromGroup[v[i]]++;
			}
		}
		
		if(lastr == r) {
			
		}
		else if(r < lastr) {
			for (int i = r+1; i <= lastr; i++) {
				vFromGroup[v[i]]--;
			}
		} else {
			for (int i = lastr+1; i <= r; i++) {
				vFromGroup[v[i]]++;
			}
		}
		
		// finding winner with x votes
		for (int i = 0; i < vFromGroup.length; i++) {
			if (vFromGroup[i] == x) {
				return i;
			}
		}
		
		return -1;
	}
	
	private static Integer findFreshWinner(int[] v, int[] vFromGroupOrig, int l, int r, int x) {
//		System.out.println("Used fresh winner for" + x);
		int[] vFromGroup = null;

		int gpCount = r - l;
		int nonGpCount = v.length - gpCount;

		if (nonGpCount > gpCount) {
			// adds votes from group
			vFromGroup = new int[v.length];
			addVotesBy(v, vFromGroup, l, r);
		} else {
			vFromGroup = vFromGroupOrig.clone();
			// removes votes from the non group before l
			removeVotesBy(v, vFromGroup, 0, l - 1);
			// removes votes from the non group members after r
			removeVotesBy(v, vFromGroup, r + 1, vFromGroup.length - 1);
		}
		
		// finding winner with x votes
		for (int i = 0; i < vFromGroup.length; i++) {
			if (vFromGroup[i] == x) {
				return i;
			}
		}

		return -1;
	}

	public static Integer findWinner(int[] v, int[] voteFromClass, int l, int r, int x) {
		int[] vFromGroup = voteFromClass.clone();
		
		if(l-1>=0) {
			for (int i = 0; i <= l-1; i++) {
				vFromGroup[v[i]]--;
			}
		}
		
		if(r+1 <= voteFromClass.length-1) {
			for (int i = r+1; i < voteFromClass.length; i++) {
				vFromGroup[v[i]]--;
			}
		}
		
		// finding winner with x votes
		for (int i = 0; i < voteFromClass.length; i++) {
			if (vFromGroup[i] == x) {
				return i;
			}
		}
		
		return -1;
	}
	
	private static void addVotesBy(int[] v, int[] votesReceived, int l, int r) {
		// adds votes from l to r
		for (int i = l; i <= r; i++) {
			votesReceived[v[i]]++;
		}
	}

	private static void removeVotesBy(int[] v, int[] votesReceived, int l, int r) {
		// removes votes from l to r
		for (int i = l; i <= r; i++) {
			votesReceived[v[i]]--;
		}
	}
}
