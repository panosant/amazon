package com.antonakospanos.amazon.sample;

public class IntegerSum {
	
	public static int getSum(int[] numbers) {
		int sum = 0;
		for (int i = 0; i < numbers.length; i++) {
			sum = sum + numbers[i];
		}
		System.out.println(sum);

		return sum;
	}
}
