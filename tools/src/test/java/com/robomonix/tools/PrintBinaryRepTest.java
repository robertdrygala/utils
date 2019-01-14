package com.robomonix.tools;

import org.junit.Test;

public class PrintBinaryRepTest {

    @Test
    public void testShiftOpertators(){

        int  i = PrintBinaryRep.countAllActiveBitsForNumbersToN(1);
        System.out.println(i);
        i = PrintBinaryRep.countAllActiveBitsForNumbersToN(2);
        System.out.println(i);
        i = PrintBinaryRep.countAllActiveBitsForNumbersToN(3);
        System.out.println(i);
        i = PrintBinaryRep.countAllActiveBitsForNumbersToN(4);
        System.out.println(i);
        i = PrintBinaryRep.countAllActiveBitsForNumbersToN(5);
        System.out.println(i);


    }

    @Test
    public void testNumberOfPath(){
        int numOfPath = numberOfPath(4,5);
        System.out.println(numOfPath);
    }


    private int numberOfPath(int m,int n){
        if(m == 1 || n == 1){
            return 1;
        }
        return numberOfPath(m-1,n) + numberOfPath(m,n-1);
    }




}
