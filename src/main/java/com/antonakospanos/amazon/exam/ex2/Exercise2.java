package com.antonakospanos.amazon.exam.ex2;

import java.util.Arrays;

import com.antonakospanos.amazon.practice.PowerSum;

public class Exercise2 implements Runnable {

	public static void main(String[] args) {
		System.out.print("Args: " + Arrays.asList(args));
		new PowerSum().run();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}
}
