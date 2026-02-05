package com.ontariotechu.sofe3980U;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for Binary class.
 */
public class BinaryTest 
{
    /**
     * Test The constructor with a valid binary vallue
     */
    @Test
    public void normalConstructor()
    {
		Binary binary=new Binary("1001001");
        assertTrue( binary.getValue().equals("1001001"));
    }
    /**
     * Test The constructor with an invalid binary value of out-of-range digits
     */
    @Test
    public void constructorWithInvalidDigits()
    {
		Binary binary=new Binary("1001001211");
        assertTrue( binary.getValue().equals("0"));
    }
    /**
     * Test The constructor with an invalid binary value of alphabetic characters
     */
    @Test
    public void constructorWithInvalidChars()
    {
		Binary binary=new Binary("1001001A");
        assertTrue( binary.getValue().equals("0"));
    }
    /**
     * Test The constructor with an invalid binary value that has a sign
     */
    @Test
    public void constructorWithNegativeSign()
    {
		Binary binary=new Binary("-1001001");
        assertTrue( binary.getValue().equals("0"));
    }
    /**
     * T	est The constructor with a zero tailing valid binary value
     */
    @Test
    public void constructorWithZeroTailing()
    {
		Binary binary=new Binary("00001001");
        assertTrue( binary.getValue().equals("1001"));
    }
    /**
     * Test The constructor with an empty string
     */
    @Test
    public void constructorEmptyString()
    {
		Binary binary=new Binary("");
        assertTrue( binary.getValue().equals("0"));
    }
	/**
     * Test The add functions with two binary numbers of the same length
     */
    @Test
    public void add()
    {
		Binary binary1=new Binary("1000");
		Binary binary2=new Binary("1111");
		Binary binary3=Binary.add(binary1,binary2);
        assertTrue( binary3.getValue().equals("10111"));
    }
	/**
     * Test The add functions with two binary numbers, the length of the first argument is less than the second
     */
    @Test
    public void add2()
    {
		Binary binary1=new Binary("1010");
		Binary binary2=new Binary("11");
		Binary binary3=Binary.add(binary1,binary2);
        assertTrue( binary3.getValue().equals("1101"));
    }
	/**
     * Test The add functions with two binary numbers, the length of the first argument is greater than the second
     */
    @Test
    public void add3()
    {
		Binary binary1=new Binary("11");
		Binary binary2=new Binary("1010");
		Binary binary3=Binary.add(binary1,binary2);
        assertTrue( binary3.getValue().equals("1101"));
    }
	/**
     * Test The add functions with a binary numbers with zero
     */
    @Test
    public void add4()
    {
		Binary binary1=new Binary("0");
		Binary binary2=new Binary("1010");
		Binary binary3=Binary.add(binary1,binary2);
        assertTrue( binary3.getValue().equals("1010"));
    }
	/**
     * Test The add functions with two zeros
     */
    @Test
    public void add5()
    {
		Binary binary1=new Binary("0");
		Binary binary2=new Binary("0");
		Binary binary3=Binary.add(binary1,binary2);
        assertTrue( binary3.getValue().equals("0"));
    }

    /*Unit testing for the AND function*/

    @org.junit.Test
    public void test_and_v1() {
        Binary a = new Binary("1");
        Binary b = new Binary("0");
        org.junit.Assert.assertEquals("0", Binary.and(a, b).getValue());
    }

    @org.junit.Test
    public void test_and_v2() {
        Binary a = new Binary("1111");
        Binary b = new Binary("1111");
        org.junit.Assert.assertEquals("1111", Binary.and(a, b).getValue());
    }

    @org.junit.Test
    public void test_and_v3() {
        Binary a = new Binary("101");
        Binary b = new Binary("11"); // treated as 011
        org.junit.Assert.assertEquals("1", Binary.and(a, b).getValue()); // 101 & 011 = 001 → "1"
    }

    /*Unit testing for the OR function*/
    @org.junit.Test
    public void test_or_v1() {
        Binary a = new Binary("0");
        Binary b = new Binary("0");
        org.junit.Assert.assertEquals("0", Binary.or(a, b).getValue());
    }

    @org.junit.Test
    public void test_or_v2() {
        Binary a = new Binary("0");
        Binary b = new Binary("1");
        org.junit.Assert.assertEquals("1", Binary.or(a, b).getValue());
    }

    @org.junit.Test
    public void test_or_v3() {
        Binary a = new Binary("101");
        Binary b = new Binary("11"); // treated as 011
        org.junit.Assert.assertEquals("111", Binary.or(a, b).getValue());
    }
    /*testing for multiplication*/
    @org.junit.Test
    public void test_multi_v1() {
        Binary a = new Binary("10101");
        Binary b = new Binary("0");
        org.junit.Assert.assertEquals("0", Binary.multiply(a, b).getValue());
    }

    @org.junit.Test
    public void test_multi_v2() {
        Binary a = new Binary("1101");
        Binary b = new Binary("1");
        org.junit.Assert.assertEquals("1101", Binary.multiply(a, b).getValue());
    }

    @org.junit.Test
    public void test_multi_v3() {
        Binary a = new Binary("101");  // 5
        Binary b = new Binary("11");   // 3
        org.junit.Assert.assertEquals("1111", Binary.multiply(a, b).getValue()); // 15
    }

}
