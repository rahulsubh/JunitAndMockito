package com.rahul.test.helper;

import org.junit.*;

public class QuickBeforeAfterTest {

    // usually for db connection
    @BeforeClass
    public static void beforeClass(){
        System.out.println("Before Class");
    }


    @Before
    public void setup(){
        System.out.println("Before Test");
    }

    @Test
    public void test1(){
        System.out.println("test1 executed");
    }
    @Test
    public void test2(){
        System.out.println("test2 executed");
    }
    @After
    public void teardown(){
        System.out.println("After Test");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("After Class");
    }
}
