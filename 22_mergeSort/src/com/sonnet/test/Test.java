package com.sonnet.test;

import com.sonnet.util_merge.MyUtil;

import java.util.Random;

public class Test {

    public static void main(String[] args) {

        int n = 10;
        Integer[] table = new Integer[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            int e = random.nextInt(1, 100);
            System.out.print(e + "\t");
            table[i] = e;
        }
        System.out.println();
        MyUtil.mergeSort(table);
        for (int i : table) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }
}
