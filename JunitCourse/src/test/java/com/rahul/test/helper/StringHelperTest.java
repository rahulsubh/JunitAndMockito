package com.rahul.test.helper;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringHelperTest {

    StringHelper helper;

    @Before
    public void before(){
        helper = new StringHelper();
    }

    // absence of fail is success

    @Test
    public void testTruncateAInFirst2Positions_AInFirst2Positions(){
        assertEquals("CD", helper.truncateAInFirst2Positions("AACD"));
    }

    @Test
    public void testTruncateAInFirst2Positions_AInFirstPosition(){
        assertEquals("CD", helper.truncateAInFirst2Positions("ACD"));
    }

    @Test
    public void testTruncateAInFirst2Positions_AIsNotPresent(){
        assertEquals("CDEF", helper.truncateAInFirst2Positions("CDEF"));
    }

    @Test
    public void testTruncateAInFirst2Positions_AInLast2Positions(){
        assertEquals("CDAA", helper.truncateAInFirst2Positions("CDAA"));
    }

    @Test
    public void testAreFirstAndLastTwoCharactersTheSame_BasicNegativeScenario(){
        assertFalse(helper.areFirstAndLastTwoCharactersTheSame("ABCD"));
        assertFalse(helper.areFirstAndLastTwoCharactersTheSame("A"));
    }

    @Test
    public void testAreFirstAndLastTwoCharactersTheSame_BasicPositiveScenario(){
        assertTrue(helper.areFirstAndLastTwoCharactersTheSame("ABAB"));
        assertTrue(helper.areFirstAndLastTwoCharactersTheSame("AB"));
    }
}
