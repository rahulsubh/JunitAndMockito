package com.rahul.test.helper;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//to run specific test classes(organising your tests)

@RunWith(Suite.class)
@Suite.SuiteClasses({QuickBeforeAfterTest.class, StringHelperTest.class})
public class AllTests {
}
