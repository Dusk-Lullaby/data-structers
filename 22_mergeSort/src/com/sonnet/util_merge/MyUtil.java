package com.sonnet.util_merge;

public class MyUtil {

    private MyUtil() {
        throw new AssertionError("Utility class cannot be instantiated");
    }

    public static <T extends Comparable<T>> void mergeSort(T[] table) {
        mergeLoop(table, 0, table.length - 1);
    }

    private static <T extends Comparable<T>> void mergeLoop(T[] table, int left, int right) {
        if (left >= right) return;
        // 计算中间值
        int mid = (left + right) / 2;
        mergeLoop(table, left, mid);
        mergeLoop(table, mid + 1, right);
        // 分开完之后开始合并
        merge(table,  left, right, mid);
    }

    private static <T extends Comparable<T>> void merge(T[] table, int left, int right, int mid) {
        // 计算表中的数据
        int n1 = mid - left  +1;
        int n2 = right - mid - 1 + 1;
        @SuppressWarnings("unchecked")
        T[] aux1 = (T[]) new Comparable[n1];
        @SuppressWarnings("unchecked")
        T[] aux2 = (T[]) new Comparable[n2];
        // 数组拷贝
        System.arraycopy(table, left, aux1, 0, n1);
        System.arraycopy(table, mid + 1, aux2, 0, n2);
        int i = 0;          // 指向aux1待查找位置
        int j = 0;          // 指向aux2待查找位置
        while (i < n1 && j < n2) {
            if (aux1[i].compareTo(aux2[j]) <= 0) {
                table[left + i + j] = aux1[i++];
            } else {
                table[left + i + j] = aux2[j++];
            }
        }
        while (i < n1) {
            table[left + i + j] = aux1[i++];
        }
        while (j < n2) {
            table[left + i + j] = aux2[j++];
        }
    }
}
