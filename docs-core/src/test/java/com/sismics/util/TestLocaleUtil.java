package com.sismics.util;

import org.junit.Assert;
import org.junit.Test;

import java.util.Locale;

/**
 * Test of the locale utilities.
 */
public class TestLocaleUtil {

    @Test
    public void getLocaleNullTest() {
        Locale locale = LocaleUtil.getLocale(null);
        Assert.assertEquals(Locale.ENGLISH, locale);
    }

    @Test
    public void getLocaleEmptyTest() {
        Locale locale = LocaleUtil.getLocale("");
        Assert.assertEquals(Locale.ENGLISH, locale);
    }

    @Test
    public void getLocaleLanguageOnlyTest() {
        Locale locale = LocaleUtil.getLocale("fr");
        Assert.assertEquals("fr", locale.getLanguage());
        Assert.assertEquals("", locale.getCountry());
        Assert.assertEquals("", locale.getVariant());
    }

    @Test
    public void getLocaleLanguageCountryTest() {
        Locale locale = LocaleUtil.getLocale("fr_FR");
        Assert.assertEquals("fr", locale.getLanguage());
        Assert.assertEquals("FR", locale.getCountry());
        Assert.assertEquals("", locale.getVariant());
    }

    @Test
    public void getLocaleLanguageCountryVariantTest() {
        Locale locale = LocaleUtil.getLocale("zh_CN_HANS");
        Assert.assertEquals("zh", locale.getLanguage());
        Assert.assertEquals("CN", locale.getCountry());
        Assert.assertEquals("HANS", locale.getVariant());
    }

    @Test
    public void getLocaleChineseTest() {
        Locale locale = LocaleUtil.getLocale("zh_CN");
        Assert.assertEquals("zh", locale.getLanguage());
        Assert.assertEquals("CN", locale.getCountry());
    }
}
