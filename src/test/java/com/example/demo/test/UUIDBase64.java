package com.example.demo.test;

import java.nio.ByteBuffer;
import java.util.Base64;
import java.util.UUID;

// https://sakthipriyan.com/2017/04/02/creating-base64-uuid-in-java.html
public class UUIDBase64 {

    public static String randomId() {
        // Create random UUID
        UUID uuid = UUID.randomUUID();

        // Create byte[] for base64 from uuid
        byte[] src = ByteBuffer.wrap(new byte[16])
                .putLong(uuid.getMostSignificantBits())
                .putLong(uuid.getLeastSignificantBits())
                .array();

        // Encode to Base64 and remove trailing ==
        return Base64.getEncoder().encodeToString(src).substring(0, 22);
    }

    public static void main(String[] args) {
//        IntStream.rangeClosed(1, 100).forEach(value -> {
//            System.out.println(randomId()); // 22 자리
//        });
        System.out.println(System.nanoTime());
    }
}
