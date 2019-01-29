package org.hwyl.sexytopo.control.util;

import org.junit.Assert;
import org.junit.Test;


public class TextToolsTest {

    @Test
    public void testAdvanceLastNumber() {
        String advanced = TextTools.advanceLastNumber("S1");
        Assert.assertEquals("S2", advanced);
    }

    @Test
    public void testAdvanceLastNumber2() {
        String advanced = TextTools.advanceLastNumber("S2-1.1");
        Assert.assertEquals("S2-1.2", advanced);
    }

    @Test
    public void testAdvanceLastNumber3() {
        String advanced = TextTools.advanceLastNumber("1");
        Assert.assertEquals("2", advanced);
    }

    @Test
    public void testAdvanceLastNumber4() {
        String advanced = TextTools.advanceLastNumber("foo");
        Assert.assertEquals("foo1", advanced);
    }

    @Test
    public void testAdvanceLastNumber5() {
        String advanced = TextTools.advanceLastNumber("a99f");
        Assert.assertEquals("a100f", advanced);
    }

    @Test
    public void testAdvanceLastNumberWithZeroPadding1() {
        String advanced = TextTools.advanceLastNumber("a01f");
        Assert.assertEquals("a02f", advanced);
    }

    @Test
    public void testAdvanceLastNumberWithZeroPadding2() {
        String advanced = TextTools.advanceLastNumber("a09f");
        Assert.assertEquals("a10f", advanced);
    }
}
