package com.sonnet.util;

import java.util.Random;

public class MyUtil {

    private static void swap(int[] table, int index1, int index2) {
        int temp = table[index1];
        table[index1] = table[index2];
        table[index2] = temp;
    }

    public static void bubbleSort1(int[] table, int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (table[j] > table[j + 1]) {
                    swap(table, j, j + 1);
                }
            }
        }
    }

    public static void bubbleSort2(int[] table, int n) {
        for (int i = 0; i < n - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < n - i - 1; j++) {
                if (table[j] > table[j + 1]) {
                    swap(table, j, j + 1);
                    flag = false;
                }
            }
            if (flag) return;
        }
    }

    public static void bubbleSort3(int[] table, int n) {
        int newIndex;
        do {
            newIndex = 0;
            for (int i = 0; i < n - 1; i++) {
                if (table[i] > table[i + 1]) {
                    swap(table, i, i + 1);
                    newIndex = i + 1;
                }
            }
            n = newIndex;
        } while (newIndex != 0);
    }

    public static void quickSort1(int[] table, int n) {
        quickSortTable1(table, 0, n - 1);
    }

    private static void quickSortTable1(int[] table, int start, int end) {
        if (start >= end) return;
        int pivotIndex = partitionDouble(table, start, end);
        quickSortTable1(table, start, pivotIndex - 1);
        quickSortTable1(table, pivotIndex + 1, end);
    }

    private static int partitionDouble(int[] table, int start, int end) {
        Random random = new Random();
        swap(table, start, random.nextInt(start, end));
        int pivot = table[start];
        int left = start;
        int right = end;
        while (left < right) {
            while (left < right && pivot <= table[right]) {
                right--;
            }
            while (left < right && pivot >= table[left]) {
                left++;
            }
            if (left < right) {
                swap(table, left, right);
            }
        }
        swap(table, start, left);
        return left;
    }

    public static void quickSort2(int[] table, int n) {
        quickSortTable2(table, 0, n - 1);
    }

    private static void quickSortTable2(int[] table, int start, int end) {
        if (start >= end) return;
        int pivotIndex = partitionSingle(table, start, end);
        quickSortTable2(table, start, pivotIndex - 1);
        quickSortTable2(table, pivotIndex + 1, end);
    }

    private static int partitionSingle(int[] table, int start, int end) {
        Random random = new Random();
        swap(table, start, random.nextInt(start, end));
        int pivot = table[start];
        int mark = start;
        for (int i = start + 1; i <= end; i++) {
            if (table[i] <= pivot) {
                swap(table, ++mark, i);
            }
        }
        swap(table, start, mark);
        return mark;
    }
}
