package hish.hr.w31;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * https://www.hackerrank.com/contests/w31/challenges/nominating-group-leaders
 * 
 * @author shisham
 *
 */
public class NominatingGroupLeaders5 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		List<Integer[]> resL = new ArrayList<>();
		for (int a0 = 0; a0 < t; a0++) {
			int n = in.nextInt();
			int[] v = new int[n];
			List<Vote> votes = new ArrayList<>(n);
			for (int v_i = 0; v_i < n; v_i++) {
				int vFor = in.nextInt();
				v[v_i] = vFor;
				votes.add(new Vote(v_i, vFor));
			}
//			System.out.println("\n"+votes);
			int g = in.nextInt();
			Integer[] res = new Integer[g];
			for (int a1 = 0; a1 < g; a1++) {
				int l = in.nextInt();
				int r = in.nextInt();
				int x = in.nextInt();
				List<Vote> votesByGrp = votes.stream().filter(e->e.id >=l).filter(e->e.id <= r).collect(Collectors.toList());
//				System.out.println(votesByGrp);
				Map<Vote, Long> counted = votesByGrp.stream()
			            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//				System.out.println(counted);
				Optional<Map.Entry<Vote, Long>> w = counted.entrySet().stream().filter(e -> e.getValue().intValue()== x).findFirst();
				if(w.isPresent()) {
					res[a1] = w.get().getKey().forId;
				} else {
					res[a1] = -1;
				}
//				System.out.println("winner : " + res[a1]);
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
	
	static class Vote {
		int id;
		int forId;
		
		Vote(int id, int forId) {
			this.id = id;
			this.forId = forId;
		}
		
		@Override
		public int hashCode() {
			return this.forId;
		}
		
		@Override
		public boolean equals(Object obj) {
			return ((Vote)obj).forId == this.forId;
		}
		
		@Override
		public String toString() {
			return String.valueOf(this.forId);
		}
	}
}
