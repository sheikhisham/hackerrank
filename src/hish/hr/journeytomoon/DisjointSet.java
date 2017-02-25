package hish.hr.journeytomoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DisjointSet {
	static class Node {
		long data;
		long rank;
		Node parent;

		@Override
		public String toString() {
			return this.data + "-" + this.rank;
		}
	}

	private static void makeSet(long data) {
		Node node = new Node();
		node.data = data;
		node.parent = node;

		nodes.put(data, node);
	}

	/**
	 * find the root given node
	 */
	private static Node findSet(Node node) {
		Node parent = node.parent;

		if (parent.parent == parent) {
			return parent;
		}

		return findSet(parent);
	}

	/**
	 * Finds the representative of this data node
	 * 
	 * @param data
	 * @return
	 */
	private static long findSet(long data) {
		return findSet(nodes.get(data)).data;
	}

	/**
	 * Combines two sets to one, does by rank
	 * 
	 * @param data1
	 * @param data2
	 */
	private static void unionSet(long data1, long data2) {
		Node node1 = nodes.get(data1);
		Node node2 = nodes.get(data2);

		Node parent1 = findSet(node1);
		Node parent2 = findSet(node2);

		if (parent1.data == parent2.data) {
			return;
		}

		if (parent1.rank >= parent2.rank) {
			parent1.rank = parent1.rank == parent2.rank ? parent1.rank + 1
					: parent1.rank;
			parent2.parent = parent1;
		} else {
			parent1.parent = parent2;
		}
	}

	static Map<Long, Node> nodes = new HashMap<Long, Node>();

	public static void main(String[] args) throws Exception {

		BufferedReader bfr = new BufferedReader(
				new InputStreamReader(System.in));
		String[] temp = bfr.readLine().split(" ");
		long N = Integer.parseInt(temp[0]);
		long I = Integer.parseInt(temp[1]);

		for (long i = 0; i < N; i++) {
			makeSet(i);
		}

		for (long i = 0; i < I; i++) {
			temp = bfr.readLine().split(" ");
			long a = Integer.parseInt(temp[0]);
			long b = Integer.parseInt(temp[1]);
			unionSet(a, b);
		}

		HashMap<Long, List<Long>> headMap = prepareHeadMap(N);
		// for(Map.Entry<Long, List<Long>> e : headMap.entrySet()) {
		// System.out.println(e.getKey() + ":" + e.getValue());
		// }
		// System.out.println("Set Size : " + headMap.size());

		Collection<List<Long>> list = headMap.values();
		int[] listSizes = new int[list.size()];
		int i = 0;
		for (List l : list) {
			listSizes[i++] = l.size();
		}

		long[] rightElemsCount = new long[listSizes.length];
		for (int o = listSizes.length - 1, b=0; o >= 0; o--) {
			rightElemsCount[o] = b;
			b += listSizes[o]; 
		}
		
		long cmb = 0;
		for(int o=0;o<listSizes.length;o++) {
			cmb += listSizes[o] * rightElemsCount[o];
		}
//		System.out.println(Arrays.toString(rightElemsCount));
		System.out.println(cmb);
	}

	/**
	 * builds a map with rootNode as key and all nodes as values(list)
	 * 
	 * @param N
	 * @return
	 */
	private static HashMap<Long, List<Long>> prepareHeadMap(long N) {
		HashMap<Long, List<Long>> headMap = new HashMap<Long, List<Long>>();
		for (long i = 0; i < N; i++) {
			long root = findSet(i);

			List<Long> c = headMap.get(root);
			if (c == null) {
				c = new ArrayList<Long>();
				headMap.put(root, c);
			}

			c.add(i);
		}
		return headMap;
	}
}
