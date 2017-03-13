package com.antonakospanos.amazon.exam.ex2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.antonakospanos.amazon.practice.Equilibrium;

public class Exercise2a {

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
		int maxAscSliceIndex = 0;
		
		List<Integer> numbers = new ArrayList<Integer>();
		for (int i = 0; i < A.length; i++) {
			numbers.add(A[i]);
		}
		System.out.println("Searching ASC slices in the passed input: "+numbers);
		System.out.println("===========================================");
		
		List<List<Integer>> slices = getAscendingSlices(numbers);
		System.out.println(slices);
		Map<Integer, Integer> sliceMap = getSliceSizeMap(slices);
		System.out.println(sliceMap);
		
		Map.Entry<Integer, Integer> maxSlice = getMaxSlice(sliceMap);
		System.out.println(maxSlice);
		maxAscSliceIndex = maxSlice.getKey();

		return maxAscSliceIndex;
	}
	
	/**
	 * Returns a map with key=slice's index and value=slice's size
	 * 
	 * @param slices
	 * @return A map with key=slice's index and value=slice's size
	 */
	private Map<Integer, Integer> getSliceSizeMap(List<List<Integer>> slices) {
		Map<Integer, Integer> sliceMap = new HashMap<>();
		
		int index =0;
		for (List<Integer> slice : slices) {
			sliceMap.put(index, slice.size());
			index += slice.size();
		}
		
		return sliceMap;
	}
	
	private Map.Entry<Integer, Integer> getMaxSlice(Map<Integer, Integer> sliceMap) {
		Map.Entry<Integer, Integer> maxEntry = null;
		for (Map.Entry<Integer, Integer> entry : sliceMap.entrySet()) {
			if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
				maxEntry = entry;
			}
		}
		
		return maxEntry;
	}
	
	private List<List<Integer>> getAscendingSlices(List<Integer> numbers) {
		List<List<Integer>> sliceList = new ArrayList<>();

		List<Integer> slice = new ArrayList<Integer>();
		for (int i = 0; i < numbers.size(); i++) {
			if (numbers.size()-1 < i+1) {
			    slice.add(numbers.get(i));
				sliceList.add(slice);
				break;
			} else if (numbers.get(i+1) > numbers.get(i)) {
				slice.add(numbers.get(i));
			} else {
			    slice.add(numbers.get(i));
				sliceList.add(slice);
				slice = new ArrayList<Integer>(); // initialize list for next slice
			}
		}
		
		return sliceList;
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
