package hish.hr.w31;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class Test {
//	public static void main(String[] args) {
//		int[] last = { 1, 5 };
//		int l = 14;
//		int r = 15;
//
//		System.out.println(findPosition(last, l, r));
//
//		int[][] lrs = { { 1, 5 }, { 2, 3 }, { 1, 6 }, { 1, 3 } };
//		for (int[] t : lrs) {
//			System.out.format("{%d,%d}", t[0], t[1]);
//		}
//		System.out.println();
//		order(lrs, true);
//		for (int[] t : lrs) {
//			System.out.format("{%d,%d}", t[0], t[1]);
//		}
//	}
	
	public static void main(String[] args) {
		int[] llr = { 1, 5 };
		int l = 1;
		int r = 7;
		char p = findPosition(llr, l, r);
		if(p == 'l') {
			System.out.format("Add from %d-%d\n", l, llr[0]-1);
		} else if(p == 'e') {
			System.out.println("Do nothing");
		} else if(p == 'r') {
			System.out.format("Add from %d-%d\n", llr[1]+1, r);
		} else if(p == 'o')  {
			// careful here
			System.out.format("Add from %d-%d\n", l, llr[0]-1);
			System.out.format("Add from %d-%d\n", llr[1]+1, r);
		} else if(p == 'O') {
			// no way. from the beginning pls
			l = l;
			r = r;
			System.out.format("Add from first %d-%d\n", l, r);
		} else if(p == 'w') {
			System.out.format("Remove %d-%d and %d-%d\n", llr[0], l, r, llr[1]);
		}
		
		System.out.print(l+"-");
		System.out.println(r);
	}

	private static void order(int[][] lrs, boolean isDesc) {
		int[] d = new int[lrs.length];
		TreeMap<Integer, Object> m = null;
		if (isDesc) {
			m = new TreeMap<>(Collections.reverseOrder());
		} else {
			m = new TreeMap<>();
		}

		for (int i = 0; i < lrs.length; i++) {
			d[i] = lrs[i][1] - lrs[i][0];
			m.put(d[i], lrs[i]);
		}
		int[][] lrs2 = new int[lrs.length][2];
		List<Object> values = new ArrayList(m.values());
		for (int i = 0; i < values.size(); i++) {
			lrs2[i] = (int[]) values.get(i);
		}
		
		System.arraycopy(lrs2, 0, lrs, 0, lrs.length);
	}

	private static char findPosition(int[] last, int l, int r) {
		if (l == last[0] && r == last[1]) {
			// equal
			System.out.format("equal: %d == %d, %d == %d\n", last[0], l, r, last[1]);
			return 'e';
		} else if (l >= last[0] && l <= last[1] && r >= last[0] && r <= last[1]) {
			// within
			System.out.format("within: %d <= %d <= %d <= %d\n", last[0], l, r, last[1]);
			return 'w';
		} else if (l <= last[0] && l <= last[1] && r >= last[0] && r <= last[1]) {
			// left overflow
			System.out.format("left overflow: %d >= %d <= %d <= %d\n", last[0], l, r, last[1]);
			return 'l';
		} else if (l >= last[0] && l <= last[1] && r >= last[0] && r >= last[1]) {
			// right overflow
			System.out.format("right overflow: %d >= %d <= %d <= %d\n", last[0], l, r, last[1]);
			return 'r';
		} else if (l <= last[0] && l <= last[1] && r >= last[0] && r >= last[1]) {
			// overflow
			System.out.format("overflow: %d >= %d <= %d <= %d\n", last[0], l, r, last[1]);
			return 'o';
		} else {
			// outside
			System.out.format("outside: %d <= %d, %d <= %d\n", last[0], last[1], l, r);
			return 'O';
		}
	}
}
