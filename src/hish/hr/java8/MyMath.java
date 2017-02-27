package hish.hr.java8;

class MyMath {
	public static boolean checker(PerformOperation p, int num) {
		return p.check(num);
	}

	public PerformOperation is_odd() {
		return (int a) -> {
			return a % 2 != 0;
		};
	}

	public PerformOperation is_prime() {
		return (int num) -> {
			if (num < 2)
				return false;
			if (num == 2)
				return true;
			if (num % 2 == 0)
				return false;
			for (int i = 3; i * i <= num; i += 2)
				if (num % i == 0)
					return false;
			return true;
		};
	}

	public PerformOperation is_palindrome() {
		return (int num) -> {
			String strn = String.valueOf(num);
			StringBuilder strnb = new StringBuilder(strn);
			return strnb.reverse().toString().equals(strn);
		};
	}
}
