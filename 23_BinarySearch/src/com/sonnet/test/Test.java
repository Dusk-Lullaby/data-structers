package com.sonnet.test;

import com.sonnet.util.MyUtil;

public class Test {

    public static void main(String[] args) {
        int n = 10;
        Integer[] table = new Integer[n];
        for (int i = 0; i < n; i++) {
            table[i] = 90 + i;
            System.out.print(table[i] + "\t");
        }
        System.out.println();

        for (Integer i : table) {
            System.out.print(MyUtil.BinarySearchV1(table, n, i) + "\t");
        }
        System.out.println();

        for (Integer i : table) {
            System.out.print(MyUtil.BinarySearchV2(table, n, i) + "\t");
        }
        System.out.println();
    }
}
