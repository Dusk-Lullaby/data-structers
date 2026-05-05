import com.Sonnet.AVLTree.AVLTree;
import com.Sonnet.element.Element;

public class Main {
    public static void main(String[] args) {
        Element[] data = {new Element(40), new Element(60), new Element(20),
                        new Element(10), new Element(30), new Element(50),
                        new Element(80), new Element(7), new Element(25),
                        new Element(55), new Element(68), new Element(90)};
        AVLTree tree = new AVLTree();
        for (int i = 0; i < data.length; i++) {
            tree.insertAVLTreeNode(data[i]);
        }
        tree.inOrderAVLTree(tree.getRoot());
        System.out.println();
        System.out.println("tree height:" + tree.getHeight(tree.getRoot()));
        System.out.println("tree height:" + tree.getRoot().getHeight());

        tree.deleteAVLTreeNode(new Element(60));
        tree.deleteAVLTreeNode(new Element(55));
        tree.inOrderAVLTree(tree.getRoot());
        System.out.println();

        tree.releaseAVLTree();
    }
}