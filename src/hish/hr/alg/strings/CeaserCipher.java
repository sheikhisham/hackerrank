package hish.hr.alg.strings;

import java.util.Scanner;

public class CeaserCipher {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		short len = sc.nextShort();
		String istr = sc.next();
		int key = sc.nextShort(); // to rotate
		sc.close();

		key = key % 26;
		char[] arr = istr.toCharArray();
		for (short i = 0; i < len; i++) {
			int k = arr[i];
			if ((k >= 65 && k <= 90)) {
				k += key;
				if (k > 90)
					k = k - 26;
			}
			else if (k >= 97 && k <= 122) {
				k += key;
				if (k > 122)
					k = k - 26;
			}
			arr[i] = (char) k;
		}

		System.out.println(String.valueOf(arr));
	}

}
