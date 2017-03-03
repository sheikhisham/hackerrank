/**
 * 
 */
package hish.hr.componentgraph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * https://www.hackerrank.com/challenges/components-in-graph
 * 
 * @author shisham
 *
 */
public class DisjointSet {

	private static Map<Long, Node> nodeMap = new HashMap();

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			String[] tmp = br.readLine().split(" ");
			long data1 = Long.parseLong(tmp[0]);
			long data2 = Long.parseLong(tmp[1]);
			makeSet(data1);
			makeSet(data2);
			joinSets(data1, data2);
		}

		Collection<List<Long>> list = prepareHeadMap().values();
//		System.out.println(list);
		int[] listSizes = new int[list.size()];
		int i = 0;
		for (List l : list) {
			listSizes[i++] = l.size();
		}

		Arrays.sort(listSizes);

		System.out.println(listSizes[0] + " " + listSizes[listSizes.length-1]);
	}

	/**
	 * builds a map with rootNode as key and all nodes as values(list)
	 * 
	 * @param N
	 * @return
	 */
	private static HashMap<Long, List<Long>> prepareHeadMap() {
		HashMap<Long, List<Long>> headMap = new HashMap<Long, List<Long>>();
		for (long i : nodeMap.keySet()) {
			long root = findRoot(i).data;

			List<Long> c = headMap.get(root);
			if (c == null) {
				c = new ArrayList<Long>();
				headMap.put(root, c);
			}

			c.add(i);
		}
		return headMap;
	}

	private static Node makeSet(long data) {
		Node node = nodeMap.get(data);
		if (null == node) {
			node = new Node();
			node.data = data;
			node.parent = node;
			nodeMap.put(data, node);
		}

		return node;
	}

	/**
	 * Finds the root node representing this data
	 * 
	 * @param data
	 * @return
	 */
	private static Node findRoot(long data) {
		Node node = nodeMap.get(data);
		Node parent = node.parent;

		if (parent == parent.parent) {
			return parent;
		}

		return findRoot(parent.data);
	}

	/**
	 * Joins two sets
	 * 
	 * @param data1
	 * @param data2
	 */
	private static void joinSets(long data1, long data2) {
		Node root1 = findRoot(data1);
		Node root2 = findRoot(data2);

		if (root1.data == root2.data) {
			return;
		}

		if (root1.rank >= root2.rank) {
			root1.rank = (root1.rank == root2.rank) ? root1.rank + 1 : root1.rank;
			root2.parent = root1;
		} else {
			root1.parent = root2;
		}

	}

	static class Node {
		long data;
		Node parent;
		int rank;

		@Override
		public String toString() {
			return String.valueOf(this.data);
		}
	}
}
