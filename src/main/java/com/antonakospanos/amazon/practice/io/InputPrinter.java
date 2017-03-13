package com.antonakospanos.amazon.practice.io;

import java.io.InputStream;
import java.util.Scanner;

public class InputPrinter {

	public InputPrinter() throws Exception {
		System.out.println("Type some numbers and press <ENTER>");

		InputStream inputStream = System.in;
		Scanner scanner = new Scanner(inputStream);
		
		int n = scanner.nextInt(); // parse the first line: It's shall be an integer of the remaining lines
		for (int t = 0; t < n; t++) {
			int a = scanner.nextInt();	// parse the first integer
			int b = scanner.nextInt();	// parse the second integer
			System.out.println(a + b);	// sum a+b
		}
	}
}
