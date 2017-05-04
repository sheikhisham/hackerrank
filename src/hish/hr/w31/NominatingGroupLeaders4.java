package hish.hr.w31;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/contests/w31/challenges/nominating-group-leaders
 * [My Best]
 * @author shisham
 *
 */
public class NominatingGroupLeaders4 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int[][] resa = new int[t][];
		for (int a0 = 0; a0 < t; a0++) {
			int n = in.nextInt();
			int[] v = new int[n];
			int[] vFromClass = new int[n];
			for (int v_i = 0; v_i < n; v_i++) {
				v[v_i] = in.nextInt();
				vFromClass[v[v_i]]++;
			}
			int g = in.nextInt();
			resa[a0] = new int[g];
			int lastl = 0;
			int lastr = v.length-1;
			int lastx = -1;
//			System.out.println("\n> "+Arrays.toString(vFromClass));
			for (int a1 = 0; a1 < g; a1++) {
				int l = in.nextInt();
				int r = in.nextInt();
				int x = in.nextInt();
				if(l == lastl && r == lastr && x == lastx) {
					resa[a0][a1] = resa[a0][a1-1];
					continue;
				}
				resa[a0][a1] = findWinner2(v, vFromClass, l, r, x, lastl, lastr, lastx);
//				System.out.println(Arrays.toString(vFromClass));
				lastl = l;
				lastr = r;
				lastx = x;
			}
		}

		for (int[] res : resa) {
			for (int w : res) {
				System.out.println(w);
			}
		}

		in.close();
	}
	
	public static Integer findWinner2(int[] v, int[] vFromGroup, int l, int r, int x, int lastl, int lastr, int lastx) {
		
		if(l > lastl) {
			for (int i = lastl; i < l; i++) {
				vFromGroup[v[i]]--;
			}
		} else if(lastl == l) {
			
		} else {
			for (int i = l; i < lastl; i++) {
				vFromGroup[v[i]]++;
			}
		}
		
		
		if(r < lastr) {
			for (int i = r+1; i <= lastr; i++) {
				vFromGroup[v[i]]--;
			}
		} else if(lastr == r) {
			
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
	
}
