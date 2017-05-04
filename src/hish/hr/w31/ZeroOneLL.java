package hish.hr.w31;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/contests/w31/challenges/zero-one-game
 * [SOLVED]
 * @author shisham
 *
 */
public class ZeroOneLL {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int g = in.nextInt();
		List<String> res = new ArrayList<>();
		for (int a0 = 0; a0 < g; a0++) {
			int n = in.nextInt();
			Node root = new Node(in.nextInt());
			Node prev = root;
			for (int sequence_i = 1; sequence_i < n; sequence_i++) {
				Node node = new Node(in.nextInt());
				prev.next = node;
				node.prev = prev;
				prev = node;
			}
			String winner = play(root);
			res.add(winner);
		}

		for (String w : res) {
			System.out.println(w);
		}

		in.close();
	}

	private static String play(Node root) {
		int lastMove = -1;
		Node curr = root.next;
		while (curr != null) {
			Node next = curr.next;
			Node prev = curr.prev;
			if (next != null && prev != null && prev.data == 0 && next.data == 0) {
				lastMove++;
				prev.next = curr.next;
				next.prev = curr.prev;
				curr = prev;
				continue;
			}
			curr = curr.next;
		}

		return getWinner(lastMove);
	}

	public static String getWinner(int lastMove) {
		return lastMove % 2 == 0 ? "Alice" : "Bob";
	}

	static class Node {
		Node prev;
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	public static String play(int[] s) {
		Node root = new Node(s[0]);
		Node n = null;
		root.next = n;
		Node prev = root;
		for (int i = 1; i < s.length; i++) {
			Node node = new Node(s[i]);
			prev.next = node;
			node.prev = prev;
			prev = node;
		}

		return play(root);
	}

}
