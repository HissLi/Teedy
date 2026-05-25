package com.sismics.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test of the environment utilities.
 */
public class TestEnvironmentUtil {

    @Test
    public void isUnitTestTest() {
        Assert.assertTrue(EnvironmentUtil.isUnitTest());
    }

    @Test
    public void setWebappContextTest() {
        EnvironmentUtil.setWebappContext(true);
        Assert.assertTrue(EnvironmentUtil.isWebappContext());
        Assert.assertFalse(EnvironmentUtil.isUnitTest());

        // Reset for other tests
        EnvironmentUtil.setWebappContext(false);
    }

    @Test
    public void isWebappContextDefaultTest() {
        Assert.assertFalse(EnvironmentUtil.isWebappContext());
    }

    @Test
    public void isDevModeTest() {
        // In test environment, application.mode may not be set
        // Just verify the method returns a boolean
        boolean result = EnvironmentUtil.isDevMode();
        Assert.assertFalse(result);
    }

    @Test
    public void osDetectionTest() {
        // Verify we're running on some OS
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")) {
            Assert.assertTrue(EnvironmentUtil.isWindows());
        } else if (os.contains("mac")) {
            Assert.assertTrue(EnvironmentUtil.isMacOs());
        } else {
            Assert.assertTrue(EnvironmentUtil.isUnix());
        }
    }
}
