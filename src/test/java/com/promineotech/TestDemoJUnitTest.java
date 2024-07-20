package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import org.junit.jupiter.api.Test;

class TestDemoJUnitTest {
	
	private TestDemo testDemo;

	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly
		(int a, int b, int expected, boolean expectException) {
		
		if (!expectException) {
	        assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
	    } else {
	        assertThatThrownBy(() -> testDemo.addPositive(a, b))
	            .isInstanceOf(IllegalArgumentException.class);
	    }
	}

	static Stream<Arguments> argumentsForAddPositive() {
		// @formatter:off
		return Stream.of(
            arguments(2, 3, 5, false),
            arguments(1, 1, 2, false),
            arguments(-1, 2, 1, true),
            arguments(0, 0, 0, true),
            arguments(3, 10, 13, false),
            arguments(0, 0, 0, true),
            arguments(3, -3, 0, true)
        );
		// @formatter:on
    }
		
	@Test
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly () {
		assertThat(testDemo.addPositive(2, 2)).isEqualTo(4);
		assertThat(testDemo.addPositive(5, 3)).isEqualTo(8);
		assertThat(testDemo.addPositive(25, 60)).isEqualTo(85);
		assertThat(testDemo.addPositive(3, 65)).isEqualTo(68);
	}
	
	//My test 
	@Test
	void assertThatFinalGradeIsLabeledCorrectly () {
		assertThat(testDemo.finalGrade(88)).isEqualTo('B');
		assertThat(testDemo.finalGrade(71)).isEqualTo('C');
		assertThat(testDemo.finalGrade(99)).isEqualTo('A');
		assertThat(testDemo.finalGrade(68)).isEqualTo('F');
	}
	
	//Random number
	@Test
    void assertThatNumberSquaredIsCorrect() {
        // Create an instance of TestDemo
        TestDemo testDemo = new TestDemo();
        
        // Spy the TestDemo instance
        TestDemo mockDemo = spy(testDemo);
        
        // Mock getRandomInt to return 5
        doReturn(5).when(mockDemo).getRandomInt();
        
        // Call the randomNumberSquared method on the mocked object
        int fiveSquared = mockDemo.randomNumberSquared();
        
        // Assert that the result is 25 (5 squared)
        assertThat(fiveSquared).isEqualTo(25);
    }
}
