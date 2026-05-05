package com.Sonnet.element;

public class Element {
    private int data;

    public Element(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (this.getClass() != obj.getClass()) return false;
        Element other = (Element) obj;
        return other.data == this.data;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(data);
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }
}
