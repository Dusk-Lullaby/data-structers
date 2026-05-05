package com.Sonnet.element;

public class Element {
    private int data;

    public Element() {}
    public Element(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return String.valueOf(this.data);
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(this.data);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (this.getClass() != obj.getClass()) return false;
        Element other = (Element)obj;
        return this.data == ((Element) obj).data;
    }

    public int getData() {
        return data;
    }
}
