package com.KonstantinZhee.ShortUrlService2.util;

import org.apache.commons.text.RandomStringGenerator;

public class CodeGenerator {
    private final RandomStringGenerator randomStringGenerator;

    public CodeGenerator() {
        this.randomStringGenerator = new RandomStringGenerator
                .Builder().filteredBy(c -> isLatinLetterOrDigit(c))
                .build();
    }

    //проверяем
    private static boolean isLatinLetterOrDigit(int codePoint) {
        return ('a' <= codePoint && codePoint <= 'z')
                || ('A' <= codePoint && codePoint <= 'Z')
                || ('0' <= codePoint && codePoint <= '9')
                || ('+' == codePoint)
                || ('_' == codePoint)
                || ('-' == codePoint);

    }

    public String generate(int length) {
        return randomStringGenerator.generate(length);
    }

}
