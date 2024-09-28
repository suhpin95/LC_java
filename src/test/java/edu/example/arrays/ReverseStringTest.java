package edu.example.arrays;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ReverseStringTest {
    String input;
    @Before
    public void setUp(){
        input = new String("I live in a House");
    }
    @Test
    public void testReverseString(){
        ReverseString reverseString = new ReverseString();
        String solution = reverseString.getReverseString(input);
        Assert.assertTrue(solution.equals("House a in live I"));

    }
    @Test
    public void testEmptyString(){
        ReverseString reverseString = new ReverseString();
        String emptyString = reverseString.getReverseString("");
        Assert.assertTrue(emptyString.equals(""));
    }
    @Test
    public void testSingleCharString(){
        ReverseString reverseString = new ReverseString();
        String singleCharString = reverseString.getReverseString("a");
        Assert.assertTrue(singleCharString.equals("a"));
    }

}