package com.example.demo.test;

import com.fasterxml.uuid.Generators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

//https://developer111.tistory.com/83
// https://hoing.io/archives/5248
public class UUIDTest {

    public static void main(String[] args) {
        List<UUID> uuidList = new ArrayList<>();
        IntStream.rangeClosed(1, 5).forEach(value -> {
            UUID uuid = Generators.timeBasedGenerator().generate();
            System.out.println(uuid);
            uuidList.add(uuid);
        });

        System.out.println("================");
        Collections.sort(uuidList);
        uuidList.forEach(System.out::println);

        System.out.println("================");
        IntStream.rangeClosed(1, 5).forEach(value -> {
            UUID uuid = UUID.randomUUID();
            System.out.println(uuid);
//            uuidList.add(uuid);
        });

//        @Id
//        @Column(columnDefinition = "BINARY(16)")
//        private UUID userUniqId;

        UUID uuid = Generators.timeBasedGenerator().generate();
        String[] uuidArr = uuid.toString().split("-");
        String uuidStr = uuidArr[2] + uuidArr[1] + uuidArr[0] + uuidArr[3] + uuidArr[4];
        StringBuffer sb = new StringBuffer(uuidStr);
        sb.insert(8, "-");
        sb.insert(13, "-");
        sb.insert(18, "-");
        sb.insert(23, "-");
        uuid = UUID.fromString(sb.toString());
//        this.userUniqId = uuid;
        System.out.println(uuid);
        System.out.println(uuidStr);


        int intVal = 100;
        String uuidString = String.format("%032d", intVal);
//        String uuidString = "0123456789ABCEF00FECBA9876543210";
        long mostSig = Long.parseLong(uuidString.substring(0, 16), 16);
        long leastSig = Long.parseLong(uuidString.substring(16, 32), 16);
        UUID uuid2 = new UUID(mostSig, leastSig);
        System.out.println(uuid2);
    }
}
