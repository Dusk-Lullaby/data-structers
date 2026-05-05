package com.sonnet.util;

public class MyUtil {

    private MyUtil() {
        throw new AssertionError("Utility class cannot be instantiated");
    }

    // 闭区间[0 ... n - 1]
    public static <T extends Comparable<T>> int BinarySearchV1(T[] table, int n, T target) {
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (table[mid].compareTo(target) == 0) {
                return mid;
            } else if (table[mid].compareTo(target) > 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    // 开区间[0 ... n)
    public static <T extends Comparable<T>> int BinarySearchV2(T[] table, int n, T target) {
        int left = 0;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (table[mid].compareTo(target) == 0) {
                return mid;
            } else if (table[mid].compareTo(target) > 0) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
