package com.rahul.test.mockito;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

public class ListTest {

    @Test
    public void letsMockListSizeMethod(){
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(2);
        assertEquals(2,listMock.size());
    }
    @Test
    public void letsMockListSize_ReturnMultipleValues(){
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(2).thenReturn(3);
        assertEquals(2,listMock.size());
        assertEquals(3,listMock.size());
    }
    @Test
    public void letsMockListGet(){
        List listMock = mock(List.class);
        //Argument matchers(anyInt())
        when(listMock.get(anyInt())).thenReturn("rahul");
        assertEquals("rahul",listMock.get(0));
        assertEquals("rahul",listMock.get(1));
    }
    @Test(expected = RuntimeException.class)
    public void letsMockListGet_throwAnException(){
        List listMock = mock(List.class);
        //Argument matchers(anyInt())
        when(listMock.get(anyInt())).thenThrow(new RuntimeException("Something"));
        listMock.get(0);
    }
    @Test
    public void letsMockListGet_UsingBDD(){

        //Given
        List<String> listMock = mock(List.class);
        //Argument matchers(anyInt())
        given(listMock.get(anyInt())).willReturn("rahul");

        //When
        String string = listMock.get(0);

        //Then
        assertThat(string, is("rahul"));
    }
}
