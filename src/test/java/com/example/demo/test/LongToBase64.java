package com.example.demo.test;

import java.util.HashSet;
import java.util.Set;

public class LongToBase64 {

    public static String longToBase64(long v) {
        final char[] digits = {
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
                'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
                'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D',
                'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
                'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
                'Y', 'Z', '#', '$'
        };
        int shift = 6;
        char[] buf = new char[64];
        int charPos = 64;
        int radix = 1 << shift;
        long mask = radix - 1;
        long number = v;
        do {
            buf[--charPos] = digits[(int) (number & mask)];
            number >>>= shift;
        } while (number != 0);
        return new String(buf, charPos, (64 - charPos));
    }

    public static void main(String[] args) {
        Set<Long> longSet1 = new HashSet<>();
        Set<String> longSet2 = new HashSet<>();
        for (int i = 0; i < 1000; i++) {
            long time = System.nanoTime();
            String strTime = longToBase64(time);
            System.out.println(time + " -> " + strTime);
            longSet1.add(time);
            longSet2.add(strTime);

        }
        System.out.println(longSet1.size());
        System.out.println(longSet2.size());

    }
}
