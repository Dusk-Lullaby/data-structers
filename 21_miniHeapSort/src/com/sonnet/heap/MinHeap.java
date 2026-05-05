package com.sonnet.heap;

public class MinHeap<T extends Comparable<T>> {

    private final T[] data;               // 数据域

    private final int capacity;           // 容量

    private int len;                // 数据域

    @SuppressWarnings("unchecked")
    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.len = 0;
        this.data = (T[])new Comparable[capacity + 1];
    }

    public void insertMiniHeap(T e) {
        if (this.len >= this.capacity) {
            throw new IllegalStateException("Heap is full");
        }
        this.data[++this.len] = e;
        siftUp(this.len);
    }

    private void siftUp(int index) {
        while (index > 1 && this.data[index].compareTo(this.data[index / 2]) < 0) {
            T tmp = this.data[index];
            this.data[index] = this.data[index / 2];
            this.data[index / 2] = tmp;
            index /= 2;
        }
    }

    public T extractMinHeap() {
        T ret = this.data[1];
        this.data[1] = this.data[this.len--];
        siftDown(1);
        return ret;
    }

    private void siftDown(int index) {
        while (2 * index < this.len) {
            int swapIndex = 2 * index;
            if (swapIndex + 1 <= this.len && this.data[swapIndex].compareTo(this.data[swapIndex + 1]) > 0) {
                swapIndex++;
            }
            if (this.data[swapIndex].compareTo(this.data[index]) > 0) {
                break;
            }
            T tmp = this.data[index];
            this.data[index] = this.data[swapIndex];
            this.data[swapIndex] = tmp;
            index = swapIndex;
        }
    }
}
