package com.promineotech;

import java.util.Random;

public class TestDemo {

	public int addPositive(int a, int b) {
		
		if(a > 0 && b > 0) {
			return a + b;
		} else {
			throw new IllegalArgumentException
			("Both parameters must be positive!");
		}
	}
	
	// My test
	public char finalGrade (int numGrade) {
		if (numGrade > 90) {
			return 'A';
		} else if (numGrade > 80) {
			return 'B';
		} else if (numGrade > 70) {
			return 'C';
		} else {
			return 'F';
		}
	}
	
	//random Number Squared
	int getRandomInt() {
		Random random = new Random(); 
		return random.nextInt(5) + 1;
	}
	
    public int randomNumberSquared() {
        int result = getRandomInt();
        return result * result;
    }

    public static void main(String[] args) {
        TestDemo demo = new TestDemo();
        System.out.println("Random Number Squared is: " 
        + demo.randomNumberSquared());
    }
}
