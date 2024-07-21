package com.rahul.test.mockito;

import org.junit.Test;

import java.util.ArrayList;
import static org.mockito.BDDMockito.*;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class SpyTest {

    //spy gets all logic from the class or to override specific methods
    // spy is also called partial mock.
    //avoid spy in projects

    @Test
    public void test(){
        List arrayListSpy = spy(ArrayList.class);
        assertEquals(0, arrayListSpy.size());
        // mock return default values

//        arrayListSpy.add("Dummy");
//        assertEquals(1, arrayListSpy.size());
//        arrayListSpy.remove("Dummy");
//        assertEquals(0, arrayListSpy.size());

        given(arrayListSpy.size()).willReturn(5);
        assertEquals(5, arrayListSpy.size());

        arrayListSpy.add("Dummy");
        then(arrayListSpy).should().add("Dummy");
        verify(arrayListSpy, never()).clear();


    }
}
