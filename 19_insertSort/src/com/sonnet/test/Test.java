package com.sonnet.test;

import com.sonnet.sort_util.MyUtil;

import java.util.Random;

public class Test {

    public static void main(String[] args) {
        Random random = new Random();
        int n = 10;
        int[] table1 = new int[n];
        for (int i = 0; i < n; i++) {
            table1[i] = random.nextInt(1, 100);
            System.out.print(table1[i] + "\t");
        }
        System.out.println();
        MyUtil.insertSort1(table1, n);
        for (int i : table1) {
            System.out.print(i + "\t");
        }
        System.out.println();

        int[] table2 = new int[n];
        for (int i = 0; i < n; i++) {
            table2[i] = random.nextInt(1, 100);
            System.out.print(table2[i] + "\t");
        }
        System.out.println();
        MyUtil.insertSort2(table2, n);
        for (int i : table2) {
            System.out.print(i + "\t");
        }
        System.out.println();

        int[] table3 = new int[n];
        for (int i = 0; i < n; i++) {
            table3[i] = random.nextInt(1, 100);
            System.out.print(table3[i] + "\t");
        }
        System.out.println();
        MyUtil.shellSort(table3, n);
        for (int i : table3) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }
}
