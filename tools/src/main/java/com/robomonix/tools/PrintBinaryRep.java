package com.robomonix.tools;

public class PrintBinaryRep {

    public static final String convertToTheBinary(Integer value) {

        StringBuilder stringBuilder = new StringBuilder();

        while (value > 0) {
            stringBuilder.append(value % 2 == 0 ? "0" : "1");
            value = value / 2;
        }

        return stringBuilder.toString();
    }

    public static int countAllActiveBitsForNumbersToN(int n){

        // nlogn
        int numberOfBits = 0;

        for (int i = 1;i <=n;i++){
            int t = i;
            while (t > 0) {
                if(t % 2 == 1) {
                    numberOfBits++;
                }
                t = t/2;
            }
        }

        return numberOfBits;
    }
}
