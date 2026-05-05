package com.sonnet.test;

import com.sonnet.util.MyUtil;

import java.util.Random;

public class Test {

    public static void main(String[] args) {
        int n = 10;

        int[] bubbleTable1 = createTable("bubbleSort1", n);
        MyUtil.bubbleSort1(bubbleTable1, n);
        showTable(bubbleTable1);

        int[] bubbleTable2 = createTable("bubbleSort2", n);
        MyUtil.bubbleSort2(bubbleTable2, n);
        showTable(bubbleTable2);

        int[] bubbleTable3 = createTable("bubbleSort3", n);
        MyUtil.bubbleSort3(bubbleTable3, n);
        showTable(bubbleTable3);

        int[] quickTable1 = createTable("quickSort1", n);
        MyUtil.quickSort1(quickTable1, n);
        showTable(quickTable1);

        int[] quickTable2 = createTable("quickSort2", n);
        MyUtil.quickSort2(quickTable2, n);
        showTable(quickTable2);

    }

    public static int[] createTable(String name, int n) {
        Random random = new Random();
        int[] table = new int[n];
        System.out.println(name + " :");
        for (int i = 0; i < n; i++) {
            table[i] = random.nextInt(1, 100);
            System.out.print(table[i] + "\t");
        }
        System.out.println();
        return table;
    }

    public static void showTable(int[] table) {
        for (int i : table) {
            System.out.print(i + "\t");
        }
        System.out.println();
        System.out.println();
    }
}
