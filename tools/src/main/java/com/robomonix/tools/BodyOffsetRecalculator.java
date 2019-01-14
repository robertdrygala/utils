package com.robomonix.tools;

import org.apache.commons.lang3.StringUtils;

/**
 *
 */
public class BodyOffsetRecalculator {

    private static final String SECTION_DELIMITER = ":";
    private static final String BODY_DELIMITER = "\\|";
    private static final String BODY_WRITE_DELIMITER = "|";


    private void validateOutput(String output, String input) {
        String[] outputSplitted = output.split(BODY_DELIMITER);
        String[] inputSplitted = input.split(BODY_DELIMITER);

        if (outputSplitted.length != inputSplitted.length) {
            throw new RuntimeException("Invalid output and input size , please check input corrections.");
        }

        for (int i = 0; i < inputSplitted.length; i++) {
            if (sectionsNotEqual(inputSplitted[i], outputSplitted[i])) {
                throw new RuntimeException("Invalid output , please check input corrections.");
            }
        }
    }

    private boolean sectionsNotEqual(String inputSection, String outputSection) {
        String[] splittedInput = inputSection.split(SECTION_DELIMITER);
        String[] splittedOutput = outputSection.split(SECTION_DELIMITER);

        if ((splittedInput[0].equals(splittedOutput[0])) && (splittedInput[2].equals(splittedOutput[2]))) {
            return false;
        }
        return true;
    }

    public String recalculatePositionsDefaultDelim(String body) {
        return recalculate(body, BODY_DELIMITER, BODY_WRITE_DELIMITER);
    }

    public String recalculatePositions(String body, String delimiter, String writeDelimiter) {
        return recalculate(body, delimiter, writeDelimiter);
    }

    private String recalculate(String body, String delimiter, String writeDelimiter) {

        if (StringUtils.isEmpty(body)) {
            throw new IllegalArgumentException("Body can't be null.");
        }

        String[] splittedString = body.split(delimiter);
        if (splittedString.length < 2) {
            throw new IllegalArgumentException("Too short string ");
        }

        int currentPosition = 1;
        StringBuilder stringBuilder = new StringBuilder();

        for (String section : splittedString
        ) {
            currentPosition = replaceStartPositionPositionAndReturnNextPosition(section, currentPosition, stringBuilder, writeDelimiter);
        }
        String result = stringBuilder.toString();
        String returnValue = result.substring(0, result.length() - 1);
        validateOutput(body,returnValue);
        return returnValue;
    }

    private int replaceStartPositionPositionAndReturnNextPosition(String section, int currentPosition, StringBuilder stringBuilder, String writeDelimiter) {
        String[] split = section.split(SECTION_DELIMITER);
        stringBuilder.append(split[0] + SECTION_DELIMITER + currentPosition + SECTION_DELIMITER + split[2] + writeDelimiter).toString();
        return currentPosition + Integer.valueOf(split[2]);
    }

}
