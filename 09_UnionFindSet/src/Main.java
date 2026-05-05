import com.Sonnet.element.Element;
import com.Sonnet.quickFind.QuickFindSet;
import com.Sonnet.quickUnion.QuickUnionSet;

public class Main {
    public static void main(String[] args) {
        test01();
        test02();
    }

    private static void test01() {
        Element[] data = new Element[9];
        for (int i = 0; i < data.length; i++) {
            data[i] = new Element(i);
        }
        QuickFindSet setQF = new QuickFindSet(9);
        setQF.initQuickFindSet(data);
        setQF.unionQuickFindSet(new Element(3), new Element(4));
        setQF.unionQuickFindSet(new Element(8), new Element(0));
        setQF.unionQuickFindSet(new Element(2), new Element(3));
        setQF.unionQuickFindSet(new Element(5), new Element(6));
        if (setQF.findSetQuickFind(new Element(0), new Element(2))) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        if (setQF.findSetQuickFind(new Element(2), new Element(4))) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        setQF.unionQuickFindSet(new Element(5), new Element(1));
        setQF.unionQuickFindSet(new Element(7), new Element(3));
        setQF.unionQuickFindSet(new Element(1), new Element(4));
        setQF.unionQuickFindSet(new Element(4), new Element(8));
        if (setQF.findSetQuickFind(new Element(0), new Element(2))) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        if (setQF.findSetQuickFind(new Element(2), new Element(4))) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        setQF.releaseQuickFindSet();
    }

    private static void test02() {
        Element[] data = new Element[9];
        for (int i = 0; i < data.length; i++) {
            data[i] = new Element(i);
        }
        QuickUnionSet setQU = new QuickUnionSet(9);
        setQU.initQuickUnionSet(data);
        setQU.unionQuickUnionSet(new Element(3), new Element(4));
        setQU.unionQuickUnionSet(new Element(8), new Element(0));
        setQU.unionQuickUnionSet(new Element(2), new Element(3));
        setQU.unionQuickUnionSet(new Element(5), new Element(6));
        if (setQU.findQuickUnionSet(new Element(0), new Element(2))) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        if (setQU.findQuickUnionSet(new Element(2), new Element(4))) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        setQU.unionQuickUnionSet(new Element(5), new Element(1));
        setQU.unionQuickUnionSet(new Element(7), new Element(3));
        setQU.unionQuickUnionSet(new Element(1), new Element(4));
        setQU.unionQuickUnionSet(new Element(4), new Element(8));
        if (setQU.findQuickUnionSet(new Element(0), new Element(2))) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        if (setQU.findQuickUnionSet(new Element(2), new Element(4))) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        setQU.releaseQuickUnionSet();
    }

}