package com.example.demo.test;

import com.example.demo.dto.test.Item;
import com.example.demo.dto.test.Modem;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class OptionalTest {

    public static void main(String[] args) {

        // of는 인자로서 null값을 허용안함
        // ofNullable은 null값을 허용
        String name = "saelobi";
        Optional<String> opt = Optional.of(name);
        System.out.println(opt.toString());

        try {
            name = null;
            opt = Optional.of(name);
        } catch (NullPointerException e) {
            System.out.println("error: " + e.toString());
        }
    }

    @Test
    public void intTest() {
        Integer i = 1;

//        System.out.println(Optional.of(i));
        Integer result2 = Optional.ofNullable(i).orElseGet(() -> 0);
        System.out.println(result2);
    }

    @Test
    public void givenNonNull_whenCreatesNonNullable() {
        String name = "saelobi";
        Optional<String> opt = Optional.of(name);
        assertEquals("Optional[saelobi]", opt.toString());
    }

    //  assertThrows에 필요한 클래스를 등록하고 람다식으로 예외를 던질 실행문을 작성하면 된다.
    @Test
    public void givenNull_whenThrowsErrorOnCreate() {
        String name = null;
//        Optional<String> opt = Optional.of(name);
        assertThrows(NullPointerException.class, () -> Optional.of(name), "check");
    }

    @Test
    public void givenNonNull_whenCreatesNullable() {
        String name = "saelobi";
        Optional<String> opt = Optional.ofNullable(name);
        assertEquals("Optional[saelobi]", opt.toString());
    }

    @Test
    public void givenNull_whenCreatesNullable() {
        String name = null;
        Optional<String> opt = Optional.ofNullable(name);
        assertEquals("Optional.empty", opt.toString());
    }

    @Test
    public void givenOptional_whenIsPresentWorks() {
        Optional<String> opt = Optional.of("saelobi");
        assertTrue(opt.isPresent());
        opt = Optional.ofNullable(null);
        assertFalse(opt.isPresent());
    }

    @Test
    public void givenOptional_whenIfPresentWorks() {
        Optional<String> opt = Optional.of("saelobi");
        opt.ifPresent(name -> System.out.println(name.length()));
    }

    @Test
    public void whenOrElseWorks() {
        String nullName = null;
        String name = Optional.ofNullable(nullName).orElse("John");
        assertEquals("John", name);
        String name1 = Optional.ofNullable(nullName).orElseGet(() -> "John");
        assertEquals("John", name1);
    }

    @Test
    public void supplierTest() {
        Supplier<String> supplier = OptionalTest::getHelloWorld;
        String result = supplier.get();
        System.out.println(result);

        String hello = "hello";
        BooleanSupplier booleanSupplier = () -> hello.equals("hello");
        IntSupplier intSupplier = hello::length;
        LongSupplier longSupplier = hello::length;
        DoubleSupplier doubleSupplier = () -> 12.34 - hello.length();

        System.out.println(booleanSupplier.getAsBoolean());
        System.out.println(intSupplier.getAsInt());
        System.out.println(longSupplier.getAsLong());
        System.out.println(doubleSupplier.getAsDouble());

        System.out.println("===========");
        Supplier<Integer> randomNumbersSupplier = () -> new Random().nextInt(100);

        Stream.generate(randomNumbersSupplier)
                .limit(5)
                .forEach(System.out::println);
    }

    public static String getHelloWorld() {
        return "Hello World";
    }

    public String getMyDefault() {
        System.out.println("Getting Default Value");
        return "Default Value";
    }

    @Test
    public void whenOrElseGetAndOrElseOverLap() {
        String text = null;
        System.out.println("Using orElseGet:");
        String defaultText = Optional.ofNullable(text).orElseGet(this::getMyDefault);
        assertEquals("Default Value", defaultText);
        System.out.println("Using orElse:");
        defaultText = Optional.ofNullable(text).orElse(getMyDefault());
        assertEquals("Default Value", defaultText);
    }

    @Test
    public void whenOrElseGetAndOrElseDiff() {
        String text = "TEST";
        System.out.println("Using orElseGet:");
        String defaultText = Optional.ofNullable(text).orElseGet(this::getMyDefault);
        assertEquals("TEST", defaultText);
        System.out.println("Using orElse:");
        defaultText = Optional.ofNullable(text).orElse(getMyDefault());
        assertEquals("TEST", defaultText);
    }

    @Test
    public void whenOrElseWorks1() {
        String nullName = null;
//        String name = Optional.ofNullable(nullName).orElseThrow(IllegalArgumentException::new);
        assertThrows(IllegalArgumentException.class, () -> Optional.ofNullable(nullName).orElseThrow(IllegalArgumentException::new));
    }

    @Test
    public void givenOptional_whenGetsValue() {
        Optional<String> opt = Optional.of("saelobi");
        String name = opt.get();
        assertEquals("saelobi", name);
    }

    @Test
    public void givenOptionalWithNull_whenGetThrowsException() {
        Optional<String> opt = Optional.ofNullable(null);
//        String name = opt.get();
        assertThrows(NoSuchElementException.class, () -> opt.get());
    }

    public boolean priceIsInRange1(Modem modem) {
        boolean isInRange = false;
        if (modem != null && modem.getPrice() != null
                && (modem.getPrice() >= 10
                && modem.getPrice() <= 15)) {
            isInRange = true;
        }
        return isInRange;
    }

    @Test
    public void whenFiltersWithoutOptional() {
        assertTrue(priceIsInRange1(new Modem(10.0)));
        assertFalse(priceIsInRange1(new Modem(9.9)));
        assertFalse(priceIsInRange1(new Modem(null)));
        assertFalse(priceIsInRange1(new Modem(15.5)));
        assertFalse(priceIsInRange1(null));
    }

    public boolean priceIsInRange2(Modem modem) {
        return Optional.ofNullable(modem)
                .map(Modem::getPrice)
                .filter(p -> p >= 10)
                .filter(p -> p <= 15)
                .isPresent();
    }

    @Test
    public void whenFiltersWithoutOptional2() {
        assertTrue(priceIsInRange2(new Modem(10.0)));
        assertFalse(priceIsInRange2(new Modem(9.9)));
        assertFalse(priceIsInRange2(new Modem(null)));
        assertFalse(priceIsInRange2(new Modem(15.5)));
        assertFalse(priceIsInRange2(null));
    }

    @Test
    public void givenOptional_whenMapWorks() {
        List<String> companyNames = Arrays.asList("Samsung", "SK", "NAVER", "Daum");
        Optional<List<String>> listOptional = Optional.of(companyNames);
        int size = listOptional.map(List::size).orElse(0);
        assertEquals(4, size);
    }

    @Test
    public void givenOptional_whenMapWorks2() {
        String name = "saelobi";
        Optional<String> nameOptional = Optional.ofNullable(name);
        int len = nameOptional.map(String::length).orElse(0);
        assertEquals(7, len);
    }

    @Test
    public void givenOptional_whenMapWorksWithFilter() {
        String password = " password ";
        Optional<String> passOpt = Optional.of(password);
        boolean correctPassword = passOpt.filter(pass -> pass.equals("password")).isPresent();
        assertFalse(correctPassword);
        correctPassword = passOpt.map(String::trim).filter(pass -> pass.equals("password")).isPresent();
        assertTrue(correctPassword);
    }

//    출처: https://engkimbs.tistory.com/646 [새로비]

    @Test
    public void optionalIntTest() {
        System.out.println(Optional.ofNullable(null).orElseGet(() -> 0));
    }

    @Test
    void subStrTest() {
//        String beginDate = LocalDateTime.now().toString();
        String beginDate = null;
//        System.out.println(beginDate);
        beginDate = Optional.ofNullable(beginDate).map(s -> s.substring(0, 10)).orElseGet(() -> "");
        System.out.println("1");
        System.out.println(beginDate);
        System.out.println("2");
    }

    @Test
    void ifPresentTest() {
        List<Item> itemList = new ArrayList<>();
        itemList.add(Item.builder().a("a").b("b").c("c").packageTypeEnum(Item.PackageTypeEnum.APP).build());
        itemList.add(Item.builder().a("aa").b("bb").c("cc").packageTypeEnum(Item.PackageTypeEnum.REAL).build());

        Optional.of(itemList).ifPresent(l -> l.forEach(System.out::println));
        System.out.println("===========");
        Item item = null;
        Optional.ofNullable(item).ifPresent(System.out::println);
    }

}
