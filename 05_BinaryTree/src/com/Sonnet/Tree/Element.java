package com.Sonnet.Tree;

public class Element {
    private char element;
    public Element() {}
    public Element(char element) {
        this.element = element;
    }

    @Override
    public String toString() {
        return String.valueOf(this.element);
    }

    @Override
    public int hashCode() {
        return Character.hashCode(this.element);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (this.getClass() != obj.getClass()) return false;
        Element other = (Element)obj;
        return other.element == this.element;
    }
}
