import com.Sonnet.BinarySearchTree.BinarySearchTree;
import com.Sonnet.element.Element;

public class Main {
    public static void main(String[] args) {
        test01();
        test02();
    }

    public static void test01() {
        BinarySearchTree tree = new BinarySearchTree();
        System.out.println("==============================");
        Element[] data = { new Element(55), new Element(33),
                            new Element(45), new Element(100),
                            new Element(22), new Element(88),
                            new Element(8), new Element(130) };
        for (int i = 0; i < data.length; i++) {
            tree.insertTreeNodeRecur(data[i]);
        }

        System.out.print("inOrder: ");
        tree.inOrderBinarySearchTree();
        System.out.println("tree height is " + tree.heightBinarySearchTree(tree.getRoot()));
        System.out.println("tree hava " + tree.getCount() + " node");

        System.out.print("release: ");
        tree.releaseBinarySearchTree();
    }

    public static void test02() {
        BinarySearchTree tree = new BinarySearchTree();
        System.out.println("==============================");
        Element[] data = { new Element(55), new Element(33),
                new Element(45), new Element(100),
                new Element(22), new Element(88),
                new Element(8), new Element(130),
                new Element(120), new Element(121),
                new Element(122)};
        for (int i = 0; i < data.length; i++) {
            tree.insertTreeNodeNoRecur(data[i]);
        }

        System.out.print("inOrder: ");
        tree.inOrderBinarySearchTree();
        System.out.println("tree height is " + tree.heightBinarySearchTree(tree.getRoot()));
        System.out.println("tree hava " + tree.getCount() + " node");

        tree.deleteBinarySearchTreeNodeRecur(new Element(100));
        tree.deleteBinarySearchTreeNodeNoRecur(new Element(33));
        System.out.print("inOrder: ");
        tree.inOrderBinarySearchTree();
        System.out.println("tree height is " + tree.heightBinarySearchTree(tree.getRoot()));
        System.out.println("tree hava " + tree.getCount() + " node");

        System.out.print("release: ");
        tree.releaseBinarySearchTree();

    }
}