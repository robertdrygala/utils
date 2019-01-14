package com.robomonix.tools;

import org.junit.Assert;
import org.junit.Test;

public class AsciiConverterTest {

    @Test
    public void testConvertString(){

        String input = "this is my string \n with some new line and \r carriage return";

        String s = AsciiConverter.convertSpecialCharactersToAsciiRepresentationString(input.getBytes(),"|");

        Assert.assertEquals(s,"0x74|0x68|0x69|0x73|0x20|0x69|0x73|0x20|0x6D|0x79|0x20|0x73|0x74|0x72|0x69|0x6E|0x67|0x20|0x0A|0x20|0x77|0x69|0x74|0x68|0x20|0x73|0x6F|0x6D|0x65|0x20|0x6E|0x65|0x77|0x20|0x6C|0x69|0x6E|0x65|0x20|0x61|0x6E|0x64|0x20|0x0D|0x20|0x63|0x61|0x72|0x72|0x69|0x61|0x67|0x65|0x20|0x72|0x65|0x74|0x75|0x72|0x6E|");
    }

    @Test
    public void testShiftOpertators(){
        String a = Integer.toBinaryString('A');
        System.out.println("Binary rep. of 'A' : " + a);

        a = Integer.toBinaryString('A' << 2);
        Integer value = 'A' << 2;
        System.out.println("Decimal rep. of 'A' << 2 : " + value);
        System.out.println("Binary rep. of 'A' << 2 : " + a);


        a = Integer.toBinaryString('A' >> 2);
        value = 'A' >> 2;
        System.out.println("Decimal rep. of 'A' >> 2 : " + value);
        System.out.println("Binary rep. of 'A' >> 2 : " + a);
    }

}
