package com.antonakospanos.amazon.practice;

import java.io.InputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PowerSum implements Runnable {
	
	public static void main(String[] args) {
		System.out.print("Args: "  +Arrays.asList(args) + "\n\n");
		new PowerSum().run();
	}
	
	@Override
	public void run() {
		InputStream inputStream = System.in;
		Scanner scanner = new Scanner(inputStream);
		int numberToBeExpressedAsAPowerSum = getNumberToBeExpressedAsAPowerSum(scanner);
		int exponent = getExponent(scanner);

		int count = 0;
		Set<Integer> powers = new HashSet<>();
		Set<Integer> nums = new HashSet<>();
		for (int i = 1; i < numberToBeExpressedAsAPowerSum; i++) { // n>2, hence i<x. x>1
			if (pow(i, exponent) <= numberToBeExpressedAsAPowerSum) {
				nums.add(i);
				powers.add(pow(i, exponent));
			}
		}

		System.out.println("Numbers to be used: " + nums);
		System.out.println("Numbers' powers to be used: " + powers);
		System.out.println("Matched power combinations: ");
		count += findX(powers, new HashSet<>(), numberToBeExpressedAsAPowerSum);
		
		System.out.println();
		String suffix = count == 1 ? "" : "s";
		System.out.println("Result: " + count + " Power Sum"+suffix+" found!");
	}
	
	public int findX(Set<Integer> powers, Set<Set<Integer>> usedPowerSets, int x) {
		int count = 0;
		
		if (sum(powers) < x || (sum(powers) == x && usedPowerSets.contains(powers))) {
			return count;
		} else if (sum(powers) == x && !usedPowerSets.contains(powers)) {
			usedPowerSets.add(new HashSet<>(powers));
			System.out.println(powers);
			return ++count;
		} else {
			for (Integer power : powers) {
				Set<Integer> subsetOfPowers = new HashSet<>(powers);
				subsetOfPowers.remove(power);
				count += findX(subsetOfPowers, usedPowerSets, x);
			}
			
			return count;
		}
	}

	private int pow(int base, int exp) {
		if (exp == 0) {
			return 1;
		} else {
			return base * pow(base, exp - 1);
		}
	}
	
	private int sum(Set<Integer> integers) {
		int sum = 0;
		for (Integer integer : integers) {
			sum += integer;
		}

		return sum;
	}

	public int getNumberToBeExpressedAsAPowerSum(Scanner scanner) {
		System.out.println("Type the integer to be exprssed as a sum of other numbers and press <ENTER>");
		int n = scanner.nextInt(); // parse the first line: It's shall be an integer of the remaining lines

		System.out.println("Number to be expressed as a power sum: " + n + "\n");
		return n;
	}

	public int getExponent(Scanner scanner) {
		System.out.println("Type the exponent that shall be used on each number and press <ENTER>");
		int n = scanner.nextInt(); // parse the first line: It's shall be an integer of the remaining lines

		System.out.println("Exponent to be used: " + n + "\n");
		return n;
	}
}
