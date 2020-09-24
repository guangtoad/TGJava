package com.toad.java.test.tuils;

import com.toad.java.utils.TGStringUtils;
import junit.framework.TestCase;
import org.junit.Test;

public class TGStringUtils_test extends TestCase {
    @Test
    public void test1() {
        assertEquals(TGStringUtils.booleanValue(null), false);
    }
}
