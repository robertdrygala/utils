package com.robomonix.tools;


import org.apache.commons.lang3.StringUtils;

public class ByteToHexConverter {

    private static final String hexFormat = "0x%02X";
    private static final String DEFAULT_DELIMITER = "|";

    public static String convertSpecialCharactersToAsciiRepresentationString(byte[] byteArray, String delimiter) {
        return convert(byteArray, delimiter);
    }

    public static byte[] convertSpecialCharactersToAsciiRepresentationByte(byte[] byteArray, String delimiter) {
        return convertSpecialCharactersToAsciiRepresentationString(byteArray, delimiter).getBytes();
    }

    public static String convertByteToString(byte val){
        return String.format(hexFormat, val);
    }

    private static String convert(byte[] byteArray, String delimiter) {

        if (byteArray.length < 1) {
            return "";
        }

        if (StringUtils.isEmpty(delimiter)) {
            delimiter = DEFAULT_DELIMITER;
        }

        StringBuilder byteSb = new StringBuilder();

        for (byte b : byteArray
        ) {
            byteSb.append(String.format(hexFormat, b));
            byteSb.append(delimiter);
        }

        return byteSb.toString();
    }

}

