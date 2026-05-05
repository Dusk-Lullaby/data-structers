package com.Sonnet.ArrayStack;

public class Element {
    private int e;

    public Element() {};
    public Element(int e) {
        this.e = e;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(this.e);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (this.getClass() != obj.getClass())
            return false;
        Element other = (Element)obj;
        return other.e == this.e;
    }

    @Override
    public String toString() {
        return String.valueOf(this.e);
    }

}
