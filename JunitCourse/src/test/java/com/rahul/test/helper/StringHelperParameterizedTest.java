package com.rahul.test.helper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class StringHelperParameterizedTest {

    StringHelper helper = new StringHelper();

    private String input;
    private String expectedOutput;

    public StringHelperParameterizedTest(String input, String expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Parameterized.Parameters
    public static Collection<String[]> testConditions(){
        String[][] expectedOutputs = {
                {"AACD", "CD"},
                {"ACD", "CD"}
        };
        return Arrays.asList(expectedOutputs);
    }

    // absence of fail is success

    @Test
    public void testTruncateAInFirst2Positions_AInFirst2Positions(){
        assertEquals(expectedOutput,
                helper.truncateAInFirst2Positions(input));
    }

    @Test
    public void testTruncateAInFirst2Positions_AInFirstPosition(){
        assertEquals(expectedOutput, helper.truncateAInFirst2Positions(input));
    }
}
