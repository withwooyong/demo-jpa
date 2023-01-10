package com.example.demo.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ListRetainContain {

    // 교집합
    public static void retainAllCase1() {
        ArrayList<String> list1 = new ArrayList<>(Arrays.asList("A", "B", "C"));
        ArrayList<String> list2 = new ArrayList<>(Arrays.asList("A", "B"));

        list1.retainAll(list2);
        System.out.println("list1: " + list1);
        System.out.println("list2: " + list2);
    }

    // 교집합
    public static void retainAllCase2() {
        ArrayList<String> list1 = new ArrayList<>(Arrays.asList("A", "B", "C"));
        HashSet<String> set1 = new HashSet<>();
        set1.add("A");
        set1.add("B");

        list1.retainAll(set1);

        System.out.println("list1: " + list1);
        System.out.println("set1: " + set1);
    }

    // 부분집합
    public static void containsAllCase() {
        ArrayList<String> list1 = new ArrayList<>(Arrays.asList("A", "B", "C"));
        ArrayList<String> list2 = new ArrayList<>(Arrays.asList("A", "B"));
        ArrayList<String> list3 = new ArrayList<>(Arrays.asList("A", "B", "D"));

        boolean b = list1.containsAll(list2);
        boolean b1 = list2.containsAll(list3);
        System.out.println(b);
        System.out.println(b1);
    }

    // 차집합
    public static void removeAllCase() {
        List<String> list1 = new ArrayList<>(Arrays.asList("A", "C", "B"));
        List<String> list2 = new ArrayList<>(Arrays.asList("A", "B", "C"));
        List<String> list3 = new ArrayList<>(Arrays.asList("A", "B"));

        boolean isRemoveAll = list1.removeAll(list2);
        System.out.println("list1=" + list1);
        boolean isRemoveAll2 = list2.removeAll(list3);
        System.out.println("list2=" + list2);
        System.out.println(isRemoveAll);
        System.out.println(isRemoveAll2);
    }


    public static void main(String[] args) {
//        retainAllCase1();
//        retainAllCase2();
//        containsAllCase();
        removeAllCase();
//        List<String> aa = new ArrayList<>(Arrays.asList("A", "B"));
//        List<String> bb = Arrays.asList("A", "B");
//        System.out.println(aa);
//        System.out.println(bb);


    }
}
