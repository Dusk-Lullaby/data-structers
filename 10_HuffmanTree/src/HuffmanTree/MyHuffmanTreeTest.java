package HuffmanTree;

public class MyHuffmanTreeTest {

    public static void main(String[] args) {
        int w[] = { 5, 29, 7, 8, 14, 23, 3, 11 };
        char show[] = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H' };

        MyHuffmanTree tree = new MyHuffmanTree(w, w.length);
        System.out.println(tree);
        System.out.println("=======================");
        String[] codes = tree.createHuffmanCode(show.length);
        for (int i = 0; i < show.length; i++) {
            System.out.print(show[i] + ": " + codes[i] + "\n");
        }
    }
}
