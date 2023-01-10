package com.example.demo.util;


import org.bson.codecs.ObjectIdGenerator;

/**
 * https://kim-jong-hyun.tistory.com/95
 * https://blog.seulgi.kim/2014/09/mongodb-objectid.html
 * ObjectId는 3개의 영역으로 나뉘어져 있다
 * <p>
 * 첫번째 4byte는 Unix epoch 이후 초 단위로 측정된 ObjectId의 생성을 나타내는 4바이트 타임스탬프 값
 * 두번째 5byte는 프로세스당 한 번 생성 되는 5바이트 임의 값이며 이 임의 값은 기계와 프로세스에 고유
 * 세번째 3byte는 임의의 값으로 초기화 되는 3바이트 증분 카운터
 * build.gradle 추가 implementation 'org.springframework.boot:spring-boot-starter-data-mongodb'
 * <p>
 * final 이 붙은 class 는 더이상 확장할 수 없다. 즉 상속받아서 사용할 수 없다
 */
public final class ObjectId {
    public static String generator() {
        return new ObjectIdGenerator().generate().toString();
    }
}
