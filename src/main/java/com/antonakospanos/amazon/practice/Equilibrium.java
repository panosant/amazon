package com.antonakospanos.amazon.practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Equilibrium {
	
	public static void main(String[] args) {
		if (args == null || args.length == 0) {
			args = new String[] { "-1", "3", "-4", "5", "1", "-6", "2", "1" };
		}
		System.out.print("Args: "  +Arrays.asList(args) + "\n\n");
		
		List<Integer> numbers = Arrays.asList(args)
				.stream().map(s -> Integer.valueOf(s)).collect(Collectors.toList());
		
		int[] primitives = new int[numbers.size()];
		for (int i=0; i<numbers.size(); i++) {
			primitives[i] = numbers.get(i);
		}
		
		System.out.println(new Equilibrium().run(primitives));
	}
	
	public int run(int[] A) {
		int euilibriumIndex = -1;

		for (int i = 0; i < A.length; i++) {
			// System.out.println("Euilibrium test for index: "+i);
			// System.out.println("============================");

			long before = sumBeforeIndex(A, i);
			long after = sumAfterIndex(A, i);

			if (isEquilibriumIndex(before, after)) {
				euilibriumIndex = i;
				break;
			}
		}

		return euilibriumIndex;
	}

	private long sumBeforeIndex(int[] A, int index) {
		long sum = 0;

		for (int i = 0; i < index; i++) {
			sum += A[i];
			// System.out.println("Sum Before:" + sum + ". A["+i+"]:"+A[i]);
		}

		return sum;
	}

	private long sumAfterIndex(int[] A, int index) {
		long sum = 0;

		for (int i = index + 1; i < A.length; i++) {
			sum += A[i];
			// System.out.println("Sum After:" + sum + ". A["+i+"]:"+A[i]);
		}

		return sum;
	}

	private boolean isEquilibriumIndex(long before, long after) {
		// System.out.println("Before:" + before + ". After:"+after);

		return before == after;
	}
}
