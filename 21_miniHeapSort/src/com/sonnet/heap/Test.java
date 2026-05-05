package com.sonnet.heap;

import java.util.Random;

public class Test {

    public static void main(String[] args) {
        int n = 10;
        Random random = new Random();
        MinHeap<Integer> table = new MinHeap<>(n);
        for (int i = 0; i < n; i++) {
            int e = random.nextInt(1, 100);
            System.out.print(e + "\t");
            table.insertMiniHeap(e);
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print(table.extractMinHeap() + "\t");
        }
        System.out.println();
    }
}
