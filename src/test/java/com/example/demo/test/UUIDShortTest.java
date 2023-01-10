package com.example.demo.test;

import com.fasterxml.uuid.Generators;

import java.nio.ByteBuffer;
import java.util.*;
import java.util.stream.IntStream;

//https://developer111.tistory.com/83
// https://hoing.io/archives/5248
public class UUIDShortTest {

    final static char[] digits = {
            '0', '1', '2', '3', '4', '5', '6', '7',
            '8', '9', 'a', 'b', 'c', 'd', 'e', 'f',
            'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
            'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D',
            'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
            'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
            'U', 'V', 'W', 'X', 'Y', 'Z', '_', '*' // '.', '-'
    };

    public static String toUnsignedString(long i, int shift) {
        char[] buf = new char[64];
        int charPos = 64;
        int radix = 1 << shift;
        long mask = radix - 1;
        long number = i;
        do {
            buf[--charPos] = digits[(int) (number & mask)];
            number >>>= shift;
        } while (number != 0);
        return new String(buf, charPos, (64 - charPos));
    }

    public static String compressBase64UUID() {
        // Create random UUID
        UUID uuid = Generators.timeBasedGenerator().generate();

        // Create byte[] for base64 from uuid
        byte[] src = ByteBuffer.wrap(new byte[16])
                .putLong(uuid.getMostSignificantBits())
                .putLong(uuid.getLeastSignificantBits())
                .array();

        // Encode to Base64 and remove trailing ==
        return Base64.getEncoder().encodeToString(src).substring(0, 22);
    }

    public static String compressSequencialUUID() {
        UUID uuid = Generators.timeBasedGenerator().generate();
        return toUnsignedString(uuid.getMostSignificantBits(), 6) +
                toUnsignedString(uuid.getLeastSignificantBits(), 6);
    }

    // https://qh5944.tistory.com/152
    public static void listDeepCopy() {
        List<String> list1 = new ArrayList<>(Arrays.asList("A", "C", "B"));
        List<String> list2 = new ArrayList<>(list1.stream().toList());
        System.out.println(list1);
        System.out.println(list2);
        list1.add("D");
        System.out.println(list1);
        System.out.println(list2);
        list1.sort(Comparator.reverseOrder());
        System.out.println(list1);
        list1.sort(Comparator.naturalOrder());
        System.out.println(list1);
        list2.sort(Comparator.naturalOrder());
        System.out.println(list2);
    }

    public static void compareSequencialUUID() {
        ArrayList<String> uuids = new ArrayList<>();
        IntStream.rangeClosed(1, 100).forEach(value -> {
            uuids.add(compressSequencialUUID());
        });
        List<String> deepCopyList = new ArrayList<>(uuids.stream().toList());
        deepCopyList.sort(Comparator.naturalOrder());
        System.out.println(uuids);
        System.out.println(deepCopyList);
    }

    public static void main(String[] args) {
//        UUID uuid = UUID.randomUUID();
//        System.out.println(uuid.toString());
//        System.out.println(toUnsignedString(uuid.getMostSignificantBits(), 6) +
//                toUnsignedString(uuid.getLeastSignificantBits(), 6));

//        System.out.println(compressBase64UUID());
//        listDeepCopy();
        compareSequencialUUID();
    }
}
