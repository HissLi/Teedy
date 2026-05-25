package com.sismics.util;

import jakarta.json.JsonValue;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test of the JSON utilities.
 */
public class TestJsonUtil {

    @Test
    public void nullableStringNullTest() {
        JsonValue value = JsonUtil.nullable((String) null);
        Assert.assertEquals(JsonValue.NULL, value);
    }

    @Test
    public void nullableStringNonNullTest() {
        JsonValue value = JsonUtil.nullable("test");
        Assert.assertEquals(JsonValue.ValueType.STRING, value.getValueType());
        Assert.assertEquals("test", value.toString().replace("\"", ""));
    }

    @Test
    public void nullableIntegerNullTest() {
        JsonValue value = JsonUtil.nullable((Integer) null);
        Assert.assertEquals(JsonValue.NULL, value);
    }

    @Test
    public void nullableIntegerNonNullTest() {
        JsonValue value = JsonUtil.nullable(42);
        Assert.assertEquals(JsonValue.ValueType.NUMBER, value.getValueType());
        Assert.assertEquals(42, Integer.parseInt(value.toString()));
    }

    @Test
    public void nullableLongNullTest() {
        JsonValue value = JsonUtil.nullable((Long) null);
        Assert.assertEquals(JsonValue.NULL, value);
    }

    @Test
    public void nullableLongNonNullTest() {
        JsonValue value = JsonUtil.nullable(100L);
        Assert.assertEquals(JsonValue.ValueType.NUMBER, value.getValueType());
        Assert.assertEquals(100L, Long.parseLong(value.toString()));
    }
}
