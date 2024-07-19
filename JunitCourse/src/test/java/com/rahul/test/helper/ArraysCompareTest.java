package com.rahul.test.helper;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.Arrays;

public class ArraysCompareTest {

    @Test
    public void testArraySort_RandomArray(){
        int[] numbers = {12,3,4,1};
        int[] expected = {1,3,4,12};
        Arrays.sort(numbers);
        assertArrayEquals(expected,numbers);
    }

    // testing handling exceptions
    @Test(expected = NullPointerException.class)
    public void testArraySort_NullArray(){
        int [] numbers = null;
        Arrays.sort(numbers);
    }

    //testing performance
    @Test(timeout = 100)
    public void testSort_Performance(){
        int array[] = {12,13,14};
        for (int i = 1; i <= 1000000 ; i++){
            array[0] = i;
            Arrays.sort(array);
        }
    }
}
