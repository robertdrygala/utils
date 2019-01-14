package com.robomonix.tools;


public class AsciiConverter {

    private static String hexFormat = "0x%02X";
    private static String hexFormatThreeDig = "0x%03X";

    public static String convertSpecialCharactersToAsciiRepresentationString(byte[] byteArray, String delimiter) {

        StringBuffer byteSb = new StringBuffer();

        for (byte b : byteArray
        ) {
            if (b < 256) {
                byteSb.append(String.format(hexFormat, b));
            } else {
                byteSb.append(String.format(hexFormatThreeDig, b));
            }
            byteSb.append(delimiter);
        }

        return byteSb.toString();
    }

    public static byte[] convertSpecialCharactersToAsciiRepresentationByte(byte[] byteArray, String delimiter) {

        return convertSpecialCharactersToAsciiRepresentationString(byteArray, delimiter).getBytes();
    }


}

