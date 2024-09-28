package edu.example.backtrack;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PhoneNumberTest {

    String digits;
    PhoneNumber phoneNumber;
    @Before
    public void setUp() throws Exception {
        digits = "23";
        phoneNumber = new PhoneNumber();
    }
    @Test
    public void testTextGenerator(){
        phoneNumber.letterCombinations(digits);
    }
}