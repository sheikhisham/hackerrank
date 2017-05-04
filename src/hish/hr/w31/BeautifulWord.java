package hish.hr.w31;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/contests/w31/challenges/beautiful-word
 * [Solved]
 * 
 * @author shisham
 *
 */
public class BeautifulWord {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String w = in.next();
		System.out.println(isBeautiful(w.toCharArray()) ? "Yes" : "No");
	}

	private static boolean isBeautiful(char[] w) {

		List<Character> vowels = Arrays.asList('a', 'e', 'í', 'o', 'u', 'y');

		for (int i = 1; i < w.length; i++) {
			if (w[i] == w[i - 1]) {
				return false;
			}

			if (vowels.contains(w[i]) && vowels.contains(w[i - 1])) {
				return false;
			}
		}

		return true;
	}

}
