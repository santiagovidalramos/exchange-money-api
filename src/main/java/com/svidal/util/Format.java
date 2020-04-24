package com.svidal.util;

public class Format {
    public static Double decimal(Double number) {
        return Math.round(number * 100) / 100.0;
    }
}
