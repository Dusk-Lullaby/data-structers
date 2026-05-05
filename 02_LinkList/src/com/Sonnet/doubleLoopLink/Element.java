package com.Sonnet.doubleLoopLink;

public class Element {
    int val;

    public Element() {}

    public Element(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return String.valueOf(this.val);
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(this.val);
    }

    @Override
    public boolean equals(Object obj) {
        //地址相同直接返回true
        if (this == obj)
            return true;
        //类型不同返回false
        if (this.getClass() != obj) {
            return false;
        }
        //一旦类型相等就可以进行强换
        Element other = (Element)obj;
        return other.val == other.val;
    }
}
