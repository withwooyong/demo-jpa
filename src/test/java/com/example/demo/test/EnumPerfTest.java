package com.example.demo.test;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.junit.jupiter.api.Test;
import org.springframework.util.StopWatch;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EnumPerfTest {

    @Getter
    @AllArgsConstructor
    public enum AccountStatus {
        INUSE("사용중", "INUSE"),
        UNUSED("미사용", "UNUSED"),
        DELETED("삭제", "DELETED"),
        UNKNOWN("알수없음", "UNKNOWN");
        private final String description;
        private final String eng;

        // Arrays.stream Elapsed Time (Arrays.stream 이용) : 5.5588168s
        public static AccountStatus findArray(String description) {
            return Arrays.stream(values())
                    .filter(accountStatus -> accountStatus.description.equals(description))
                    .findAny()
                    .orElse(UNKNOWN);
        }

        // Stream.of Elapsed Time (Stream.of 이용) : 5.3540138s
        public static AccountStatus findStream(String description) {
            return Stream.of(values())
                    .filter(accountStatus -> accountStatus.description.equals(description))
                    .findAny()
                    .orElse(UNKNOWN);
        }

        // HashMap 이용 Elapsed Time (HashMap 이용) : 0.284138s
        private static final Map<String, AccountStatus> descriptions =
                Collections.unmodifiableMap(Stream.of(values())
                        .collect(Collectors.toMap(AccountStatus::getDescription, Function.identity())));

        public static AccountStatus findMap(String description) {
            return Optional.ofNullable(descriptions.get(description)).orElse(UNKNOWN);
        }

        private static final Map<String, AccountStatus> engs =
                Collections.unmodifiableMap(Stream.of(values())
                        .collect(Collectors.toMap(AccountStatus::getEng, Function.identity())));

        public static AccountStatus findEng(String eng) {
            return Optional.ofNullable(engs.get(eng)).orElse(UNKNOWN);
        }

    }

    @Test
    void enumTest() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        System.out.println(AccountStatus.valueOf("INUSE").name());
        System.out.println(AccountStatus.valueOf("INUSE").getDescription());
//        for (int i = 0; i < 100000000; i++) {
//            AccountStatus.valueOf("INUSE");
//        }
//        for (int i = 0; i < 100000000; i++) {
//            AccountStatus.valueOf("unexpected value");
//        }
        stopWatch.stop();
        System.out.println("Elapsed Time (Stream.of 이용) : " + stopWatch.getTotalTimeSeconds() + "s");
    }

    @Test
    void enum_속도_측정_stream_of_이용() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i = 0; i < 100000000; i++) {
            AccountStatus.findStream("사용중");
        }
        for (int i = 0; i < 100000000; i++) {
            AccountStatus.findStream("unexpected value");
        }
        stopWatch.stop();
        System.out.println("Elapsed Time (Stream.of 이용) : " + stopWatch.getTotalTimeSeconds() + "s");
    }

    @Test
    void enum_속도_측정_map_이용() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i = 0; i < 100000000; i++) {
            AccountStatus.findMap("사용중");
        }
        for (int i = 0; i < 100000000; i++) {
            AccountStatus.findMap("unexpected value");
        }
        stopWatch.stop();
        System.out.println("Elapsed Time (HashMap 이용) : " + stopWatch.getTotalTimeSeconds() + "s");
    }

    @Test
    void engs_enum_속도_측정_map_이용() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i = 0; i < 2; i++) {
            System.out.println(AccountStatus.findEng("INUSE"));

        }
        for (int i = 0; i < 2; i++) {
            System.out.println(AccountStatus.findEng("unexpected value"));
        }
        stopWatch.stop();
        System.out.println("Elapsed Time (HashMap 이용) : " + stopWatch.getTotalTimeSeconds() + "s");
    }

    @Test
    void enum_속도_측정_arrays_stream_이용() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i = 0; i < 100000000; i++) {
            AccountStatus.findArray("사용중");
        }
        for (int i = 0; i < 100000000; i++) {
            AccountStatus.findArray("unexpected value");
        }
        stopWatch.stop();
        System.out.println("Elapsed Time (Arrays.stream 이용) : " + stopWatch.getTotalTimeSeconds() + "s");
    }


}
