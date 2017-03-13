package com.antonakospanos.amazon.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class HelloWorldPrinter {
	
	public HelloWorldPrinter() throws IOException {
		System.out.println("Type the number of 'Hello World' printing iterations and press <ENTER>");

		InputStream inputStream = System.in;
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		BufferedReader bufferReader = new BufferedReader(inputStreamReader);

		String line = bufferReader.readLine();
		int N = Integer.parseInt(line);
		for (int i = 0; i < N; i++) {
			System.out.println("hello world");
		}
	}
}
