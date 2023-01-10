package com.example.demo.test;


import org.bson.codecs.ObjectIdGenerator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

/**
 * https://kim-jong-hyun.tistory.com/95
 * https://blog.seulgi.kim/2014/09/mongodb-objectid.html
 * ObjectId는 3개의 영역으로 나뉘어져 있다
 * <p>
 * 첫번째 4byte는 Unix epoch 이후 초 단위로 측정된 ObjectId의 생성을 나타내는 4바이트 타임스탬프 값
 * 두번째 5byte는 프로세스당 한 번 생성 되는 5바이트 임의 값이며 이 임의 값은 기계와 프로세스에 고유
 * 세번째 3byte는 임의의 값으로 초기화 되는 3바이트 증분 카운터
 * build.gradle 추가 implementation 'org.springframework.boot:spring-boot-starter-data-mongodb'
 */
public class ObjectIdGen {

    public static void objectIdGenerator() {
        ObjectIdGenerator objectIdGenerator = new ObjectIdGenerator();
//        System.out.println(objectIdGenerator.generate().toString());
//        System.out.println(objectIdGenerator.generate().toString().length());
        List<String> objectIdList = new ArrayList<>();

        int tps = 100000; // 더 올라가면 간헐적으로 정렬이 안됨.
        IntStream.rangeClosed(1, tps).forEach(value -> {
            String str = objectIdGenerator.generate().toString();
            objectIdList.add(str);
            System.out.println(str);
        });
        List<String> objectIdSortIdList = new ArrayList<>(objectIdList.stream().toList());
        // 오름차순 정렬해서 비교해 봤음
        objectIdSortIdList.sort(Comparator.naturalOrder());
        for (int i = 0; i < objectIdList.size(); i++) {
            if (!objectIdList.get(i).equals(objectIdSortIdList.get(i))) {
                System.out.println(i + " 찍히면 안됨. " + objectIdList.get(i) + " " + objectIdSortIdList.get(i));
            }
        }
        // 63bd08ef3cb84452b57ebbb8
        // 63bd08ef 3cb84452b5 7ebbb8
    }

    public static void main(String[] args) {
        objectIdGenerator();
    }
}
