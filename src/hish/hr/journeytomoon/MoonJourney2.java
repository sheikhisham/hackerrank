package hish.hr.journeytomoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class MoonJourney2 {
	public static void main(String[] args) throws Exception {
		BufferedReader bfr = new BufferedReader(
				new InputStreamReader(System.in));
		String[] temp = bfr.readLine().split(" ");
		int N = Integer.parseInt(temp[0]);
		int I = Integer.parseInt(temp[1]);

		int[] astronauts = new int[N];
		for (int i = 0; i < astronauts.length; i++) {
			astronauts[i] = -1;
		}

		ArrayList<HashSet<Integer>> countries = new ArrayList<HashSet<Integer>>();

		for (int i = 0; i < I; i++) {
			temp = bfr.readLine().split(" ");
			int a = Integer.parseInt(temp[0]);
			int b = Integer.parseInt(temp[1]);

			// Store a and b in an appropriate data structure of your choice
			print("processing a=%d, b=%d", a, b);
			int aIndex = astronauts[a];
			int bIndex = astronauts[b];
			int index = -1;
			if (aIndex == -1 && bIndex == -1) {
				countries.add(createCountryFor(a, b));
				index = countries.size() - 1;
				print("Created new country(%d) for astronauts(%d, %d)", index,
						a, b);
			} else if (aIndex == -1) {
				index = bIndex;
				countries.get(index).add(a);
				// print("Adding astronaut(%d) to country(%d):%s  with bIndex",
				// a, index, countries.get(index));
			} else if (bIndex == -1) {
				index = aIndex;
				countries.get(index).add(b);
				// print("Adding astronaut(%d) to country(%d):%s with aIndex",
				// b, index, countries.get(index));
			} else if (aIndex == bIndex) {
				index = aIndex;
			} else {
				System.out.println("move: " + aIndex + " " + bIndex);
				index = aIndex;
				System.out
						.println("Size before shrinking: " + countries.size());
				HashSet<Integer> bAstronauts = countries.remove(bIndex);
//				countries.trimToSize();
				System.out.println("Size after shrinking: " + countries.size());
				countries.get(index).addAll(bAstronauts);
				for (Integer t : bAstronauts) {
					astronauts[t] = index;
				}
				print("Moved all astronauts of %d's country ie.%d%s to %d's country ie.%d ",
						b, bIndex, bAstronauts, a, aIndex);
			}

			astronauts[a] = index;
			astronauts[b] = index;
//			print("Country(%d): %s", index, countries.get(index));
//			System.out.println();
		}

		for (int i = 0; i < astronauts.length; i++) {
			if (astronauts[i] == -1) {
				print("%d belongs to no country", i);
				countries.add(createCountryFor(i));
				astronauts[i] = countries.size() - 1;
				print("Created new country(%d) for astronaut(%d)",
						astronauts[i], i);
			} else {
				print("%d belongs to country-%d", i, astronauts[i]);
			}
		}

		print("", countries);

		long combinations = 0;
		// Compute the final answer - the number of combinations
		for (int i = 0; i < countries.size() - 1; i++) {
			int otherAstroCount = 0;
			for (int j = i + 1; j < countries.size(); j++) {
				otherAstroCount += countries.get(j).size();
			}
			if (i == 0) {
				System.out.println(String.format("Country0-%d-%s", countries
						.get(i).size(), countries.get(i)));
				System.out.println(String.format(
						"Leaving country(%d) other countries astroCount is %d",
						i, otherAstroCount));
			}
		}

		System.out.println(combinations);

	}

	private static void print(String s, Object... objects) {
		if (true)
			System.out.println(String.format(s, objects));
	}

	private static HashSet<Integer> createCountryFor(Integer... a) {
		return new HashSet<Integer>(Arrays.asList(a));
	}
}