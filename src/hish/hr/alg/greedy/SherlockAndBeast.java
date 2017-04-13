package hish.hr.alg.greedy;

import java.util.Scanner;

public class SherlockAndBeast {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		String dn[] = new String[t];
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			dn[i] = findDecentNumber(n);
		}

		for (String d : dn) {
			System.out.println(d);
		}

		sc.close();
	}

	private static String getNumber(int digit, int repeat) {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < repeat; i++) {
			s.append(digit);
		}

		return s.toString();
	}

	private static String findDecentNumber(int y) {
		int z = y;
		while (z % 3 != 0) {
			z -= 5;
		}
		if (z < 0) {
			return "-1";
		} else {
			String res = getNumber(5, z) + getNumber(3, (y - z));
			return res;
		}
	}
}
