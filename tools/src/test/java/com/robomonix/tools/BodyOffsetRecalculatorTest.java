package com.robomonix.tools;

import org.junit.Assert;
import org.junit.Test;

public class BodyOffsetRecalculatorTest {

    private static final String TEST_INPUT = "one:67:5|two:72:5|three:77:13";

    @Test
    public void testRecalculate(){
        BodyOffsetRecalculator bodyOffsetRecalculator = new BodyOffsetRecalculator();

        String s = bodyOffsetRecalculator.recalculatePositionsDefaultDelim(TEST_INPUT);

        Assert.assertEquals(s,"one:1:5|two:6:5|three:11:13");
    }


}
