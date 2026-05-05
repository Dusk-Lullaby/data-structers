package com.Sonnet.Threaded;

public class Element {
    private char data;

    public Element() {}
    public Element(char data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(data);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (this.getClass() != obj.getClass()) return false;
        Element other = (Element)obj;
        return this.data == other.data;
    }
}
