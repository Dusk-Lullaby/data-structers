package com.Sonnet.element;

public class Element {
    public int element;

    public Element(int e) {
        this.element = e;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(element);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (this.getClass() != obj.getClass()) return false;
        Element other = (Element) obj;
        return other.element == this.element;
    }
}
