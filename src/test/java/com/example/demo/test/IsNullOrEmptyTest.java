package com.example.demo.test;

import com.example.demo.enums.test.PackageTypeEnum;
import com.google.common.base.Strings;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
public class IsNullOrEmptyTest {

    @Test
    @DisplayName("Using String.isEmpty() method")
    void usingIsEmptyTest() {
        String str = "";
        System.out.println(str == null || str.isEmpty()); // true
    }

    @Test
    @DisplayName(("Using String.length() method"))
    void usingLengthTest() {
        String str = "";
        System.out.println(str == null || str.length() == 0);    // true
    }

    private static String EMPTY = "";

    @Test
    @DisplayName("Using String.equals() method")
    void usingEqualsTest() {
        String str = "";
        System.out.println(str == null || str.equals(EMPTY));    // true
        System.out.println(str == null || EMPTY.equals(str));    // true
    }

    @Test
    @DisplayName("Using Guava Library")
    void usingGuavaTest() {
        System.out.println(Strings.isNullOrEmpty(""));      // true
        System.out.println(Strings.isNullOrEmpty(null));    // true
        System.out.println(Strings.isNullOrEmpty("Java"));  // false
    }

    @Test
    @DisplayName("Using Apache Commons Lang")
    void usingApacheCommonLang() {
        System.out.println(StringUtils.isEmpty(""));        // true
        System.out.println(StringUtils.isEmpty(null));      // true
        System.out.println(StringUtils.isEmpty("Java"));    // false
        System.out.println(StringUtils.isBlank(" "));        // true
        System.out.println("==========");
        System.out.println(StringUtils.isNotBlank(null));
        System.out.println(StringUtils.isNotBlank(""));
        System.out.println(StringUtils.isNotBlank(" "));
        System.out.println(StringUtils.isNotBlank("java")); // <= 사용하면 됨.
    }

    String packageTypeCode = "REA";

    public String getPackageTypeName() {
        if (this.packageTypeCode == null || StringUtils.isEmpty(this.packageTypeCode))
            return "empty";
        return PackageTypeEnum.valueOf(this.packageTypeCode).getValue();
    }

    public String getPackageTypeName2() {
        return PackageTypeEnum.valueOf(this.packageTypeCode).getValue();
    }

    @Test
    void getPackageTypeNameTest() {
//        String packageTypeName = "";
//        var result = Optional.ofNullable(packageTypeName).orElse("other");
//        System.out.println("==========");
//        System.out.println(result);
//        System.out.println("==========");
//
//        String packageTypeCode = "REAL";
//        System.out.println(PackageTypeEnum.valueOf(packageTypeCode).getValue());
        System.out.println("1");
        System.out.println(getPackageTypeName2());

        System.out.println("2");

//        PackageTypeEnum.valueOf(packageTypeCode).getValue();
    }
}
