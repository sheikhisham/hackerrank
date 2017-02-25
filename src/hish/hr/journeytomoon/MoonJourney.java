package hish.hr.journeytomoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * https://www.hackerrank.com/challenges/journey-to-the-moon
 * 
 * @author shisham
 * 
 */
public class MoonJourney {

	static boolean[][] m;
	static int countrylen = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(
				new InputStreamReader(System.in));
		String[] temp = bfr.readLine().split(" ");
		int N = Integer.parseInt(temp[0]);
		int I = Integer.parseInt(temp[1]);

		m = new boolean[N][I];
		int avlCountry = -1;
		for (int i = 0; i < I; i++) {
			temp = bfr.readLine().split(" ");
			int a = Integer.parseInt(temp[0]);
			int b = Integer.parseInt(temp[1]);

			// System.out.println("processing " + a + ", " + b);

			if (a == 4 && b == 95) {
				int o = 0;
			}

			// find country index
			int ca = findCountryIndex(a);
			int cb = findCountryIndex(b);
			int ci = -1;
			if (ca == cb && cb == -1) {
				// add them to a new country

				if (avlCountry == -1) {
					ci = countrylen++;
					avlCountry = -1;
				} else
					ci = avlCountry;
			} else if (ca == -1) {
				// add them to b's country
				ci = cb;
			} else if (cb == -1) {
				// add them to a's country
				ci = ca;
			} else if (ca == cb) {
				ci = ca;
			} else {
				if (cb < ca) {
					int tmp = ca;
					ca = cb;
					cb = tmp;
				}
				// System.out.println("move all " + cb + " members to " + ca);
				// merge both countries ie. move all b members to a country
				shiftAllBCountryMembersToACountry(cb, ca);
				avlCountry = cb;
				ci = ca;
			}
			m[a][ci] = true;
			m[b][ci] = true;
			// Store a and b in an appropriate data structure of your choice

			// for(int u = 0 ; u < N;u++) {
			// System.out.print(m[2][u] ? "Y":"");
			// }
			// System.out.println();
		}
		// add each unknown astronauts to a new country each
		int unKnownAstroCount = createNewCountriesForUnknownAstros();
		printM();
//		System.out.println("UnknownAstroCount: " + unKnownAstroCount);

		// groupThem();
		long combinations = groupThem2(N, unKnownAstroCount);

		// Compute the final answer - the number of combinations

		System.out.println(combinations);
	}

	private static int createNewCountriesForUnknownAstros() {
		int unKnownAstroCount = 0;
		for (int i = 0; i < m.length; i++) {
			boolean hasCountryTag = false;
			for (int j = 0; j < countrylen; j++) {
				if (m[i][j]) {
					// System.out.println(String.format("Astronaut(%d) belongs to country %d",
					// i, j));
					hasCountryTag = true;
					break;
				}
			}
			if (!hasCountryTag) {
				unKnownAstroCount++;
				// System.out.println(String.format("Adding astronaut(%d) to new country %d",
				// i, countrylen));
			}
		}

		return unKnownAstroCount;
	}

	private static long groupThem(int N, int unKnownAstroCount) {
		int[] countryPop = new int[countrylen];

		int totalCount = 0;
		for (int i = 0; i < countrylen; i++) {
			int count = 0;
			for (int j = 0; j < m.length; j++) {
				if (m[j][i]) {
					count++;
				}
			}
			countryPop[i] = count;
			// System.out.println(String.format("Population of country(%d) is %d",
			// i, count));
			totalCount += count;
		}

		// System.out.println("Total Population of "+ countrylen + " countries"
		// +": " + totalCount);

		int possibilities = 0;
		for (int i = 0; i <= countrylen - 1; i++) {
			if (countryPop[i] == 0) {
				continue;
			}
			int otherCountriesTotalPopulation = unKnownAstroCount;
			for (int j = i + 1; j < countrylen; j++) {
				otherCountriesTotalPopulation += countryPop[j];
			}
			possibilities += (countryPop[i] * otherCountriesTotalPopulation);

			System.out
					.println(String
							.format("%d astronauts of country(%d) are going to be paired with %d",
									countryPop[i], i,
									otherCountriesTotalPopulation));
		}

		int unknownAmongThemselves = 0;
		for (int u = unKnownAstroCount - 1; u > 0; u--) {
			unknownAmongThemselves += u;
		}
		// System.out.println(unknownAmongThemselves);
		possibilities += unknownAmongThemselves;

		return possibilities;
	}

	private static long groupThem2(int N, int unKnownAstroCount) {
		List<Integer> pop = new ArrayList<Integer>();

		for (int i = 0; i < countrylen; i++) {
			int count = 0;
			for (int j = 0; j < m.length; j++) {
				if (m[j][i]) {
					count++;
				}
			}
			if(count > 0) {
				pop.add(count);
			}
		}
		
		for(int k = 0;k<unKnownAstroCount;k++) {
			pop.add(1);
		}
		
//		int t = 0;
//		for(int i = 0;i<pop.size();i++) {
//			System.out.println(i + ": "+pop.get(i));
//			t+=pop.get(i);
//		}
//		System.out.println("Final count " + t);

		long possibilities = 0;
		long leftPop = 0;
		for (int i = 0; i < pop.size() - 1; i++) {
			long otherCountriesTotalPopulation = N - leftPop - pop.get(i);
//			for (int j = i + 1; j < pop.size(); j++) {
//				otherCountriesTotalPopulation += pop.get(j);
//			}
			possibilities += (pop.get(i) * otherCountriesTotalPopulation);
			leftPop = leftPop + pop.get(i);

		/*	System.out
					.println(String
							.format("%d astronauts of country(%d) are going to be paired with %d",
									pop.get(i), i,
									otherCountriesTotalPopulation));*/
		}

		return possibilities;
	}

	private static void shiftAllBCountryMembersToACountry(int cb, int ca) {
		for (int i = 0; i < m.length; i++) {
			if (m[i][cb]) {
				m[i][ca] = m[i][cb];
				m[i][cb] = false;
			}
		}
	}

	private static void printM() {
		int count = 0;
		for (int i = 0; i < m.length; i++) {
			System.out.print(i + "| ");
			for (int j = 0; j < countrylen; j++) {
				System.out.print((m[i][j] ? "y" : "-"));
				if (m[i][j]) {
					count++;
				}
			}
			System.out.println();
		}

		System.out.println(countrylen + "------------------------" + count);
	}

	private static int findCountryIndex(int a) {
		for (int i = 0; i < m[a].length; i++) {
			if (m[a][i]) {
				return i;
			}
		}

		return -1;
	}
}
