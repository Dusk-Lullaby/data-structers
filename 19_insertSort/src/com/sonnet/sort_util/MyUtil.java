package com.sonnet.sort_util;

public class MyUtil {

    public static void insertSort1(int[] table, int n) {
          for (int i = 1; i < n; i++) {
              if (table[i] < table[i - 1]) {
                  int tmp = table[i];
                  int j = i - 1;
                  while (j >= 0 && tmp < table[j]) {
                      table[j + 1] = table[j];
                      j--;
                  }
                  table[++j] = tmp;
              }
          }
    }

    public static void insertSort2(int[] table, int n) {
        for (int i = 1; i < n; i++) {
            int temp = table[i];
            int j;
            for (j = i; j > 0 && temp < table[j - 1]; j--) {
                table[j] = table[j - 1];
            }
            table[j] = temp;
        }
    }

    public static void shellSort(int[] table, int n) {
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = table[i];
                int j;
                for (j = i; j >= gap && temp < table[j - gap]; j -= gap) {
                    table[j] = table[j - gap];
                }
                table[j] = temp;
            }
        }
    }
}
