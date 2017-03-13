package com.antonakospanos.amazon.sample;

public class StairCase {
	
	public StairCase(int n) {
		if (n > 100 || n < 1) {
			throw new IllegalArgumentException("Invalid input. You should enter an integer from [1, 100] set");
		}

		for (int i = 1; i <= n; i++) {
			printMessage(i, n);
		}
	}

	static void printMessage(int currentSize, int maxSize) {

		for (int i = 0; i < maxSize - currentSize; i++) {
			System.out.print(" ");
		}
		for (int i = 0; i < currentSize; i++) {
			System.out.print("#");
		}
		System.out.println();
	}

}
