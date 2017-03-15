package hish.hr.alg.impl;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * https://www.hackerrank.com/challenges/cut-the-sticks
 * 
 * @author shisham
 *
 */
public class CutTheSticks {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int arr[] = new int[n];
		for (int arr_i = 0; arr_i < n; arr_i++) {
			arr[arr_i] = in.nextInt();
		}

		List<Integer> sticks = new LinkedList<>();
		for (int a : arr) {
			sticks.add(a);
		}

		Collections.sort(sticks);
		System.out.println(sticks.size());
//		printSticks(sticks);
		
		while(sticks.size() > 1) {
			Integer smallest = sticks.remove(0);
			
			if(sticks.get(sticks.size()-1) <= smallest) {
				break;
			}
			
			sticks = cutSticks(sticks, smallest);
//			printSticks(sticks);
			System.out.println(sticks.size());
		}
	}

	private static List<Integer> cutSticks(List<Integer> sticks, int cutlen) {
		return sticks.stream().map(s -> {return (s - cutlen);}).filter(e -> e > 0).collect(Collectors.toList());
	}

	private static void printSticks(List<Integer> sticks) {
		String s = sticks.stream().map(n -> n.toString()).collect(Collectors.joining(" "));
		System.out.println(s);
	}

}
