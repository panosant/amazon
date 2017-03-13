package com.antonakospanos.amazon.exam.ex2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exercise2b {

	public static void main(String[] args) {
		String first = "adasd3fd";
		String second = "adasdaaafd";
		if (args != null && args.length > 2) {
			first = args[0];
			second = args[1];
		}
		System.out.print("Args: "  +Arrays.asList(args) + "\n\n");

		System.out.println(new Exercise2b().run(first, second));
	}
	
	public boolean run(String S, String T) {
		boolean match = false;
		
		System.out.println("Comapring the provided passages.\n1st passage: "+S + "\n2nd passage: " + T);
		System.out.println("==================================================");
		
    // replace number with sequntial '?'
    String first = fixString(S);
    String second = fixString(T);
    
    char[] firstCharset = first.toCharArray();
    char[] secondCharset = second.toCharArray();
    
		// check sizes for early exit
		if (firstCharset.length == secondCharset.length) {
			
			// compare character by character
			for (int index = 0; index < firstCharset.length; index++) {
				if (firstCharset[index] == firstCharset[index] ) {
					match = true;
				} else {
					match = false;
					break;
				}
			}
		}
		
		return match;
	}
	
  private String fixString(String s) {
  	StringBuffer sb = new StringBuffer();
  	
    char[] characters = s.toCharArray();
    for (char character : characters) {
      if (character >= '0' && character <= '9') {
      	int missedCharacters = Character.getNumericValue(character);
      	for (int i=0; i<missedCharacters; i++) {
        	sb.append("?");
      	}
      } else {
      	sb.append(character);
      }
    }
    
    return sb.toString();
  }
	
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
