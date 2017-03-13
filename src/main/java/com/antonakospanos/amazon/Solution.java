package com.antonakospanos.amazon;

import com.antonakospanos.amazon.exam.ex2.Exercise2;
import com.antonakospanos.amazon.practice.HelloWorldPrinter;
import com.antonakospanos.amazon.practice.InputPrinter;
import com.antonakospanos.amazon.practice.PowerSum;
import com.antonakospanos.amazon.practice.StateFileWriter;
import com.antonakospanos.amazon.sample.IntegerSum;
import com.antonakospanos.amazon.sample.StairCase;

public class Solution {

	/**
	 * Execute all implementations written in HackerRank platform
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		preExam();
		exam();
	}

	private static void preExam() throws Exception {
		new HelloWorldPrinter();
		//new InputPrinter();

		new StateFileWriter();
		
		IntegerSum.getSum(new int[] {1,2,3,4,5,6});
		new StairCase(5);
		
		new PowerSum().run();
	}

	// ************************************************ EXAM START ****************************************************
	private static void exam() {
		ex1();
		ex2();
	}
	
	private static void ex1() {
		logStart(1);
		// new Exercise1().run();
		logEnd(1);
	}
	
	private static void ex2() {
		logStart(2);
		new Exercise2().run();
		logEnd(2);
	}

	private static void logStart(int i) {
		System.out.println("------------------- Starting ex."+i+" -------------------");
	}
	
	private static void logEnd(int i) {
		System.out.println("------------------- Finishing ex."+i+" -------------------\n");
	}
}