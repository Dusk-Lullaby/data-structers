package HuffmanTree;

import java.util.Arrays;

public class MyHuffmanTree {

    private static class HuffmanNode {
        int weight;
        int lChild;
        int rChild;
        int parent;

        public HuffmanNode(int weight, int lChild, int rChild, int parent) {
            this.weight = weight;
            this.lChild = lChild;
            this.rChild = rChild;
            this.parent = parent;
        }

        @Override
        public String toString() {
            return "HuffmanNode{" +
                    "weight=" + weight +
                    ", parent=" + parent +
                    ", lChild=" + lChild +
                    ", rChild=" + rChild +
                    '}' + "\n";
        }
    }

    private HuffmanNode[] huffNodes;

    public MyHuffmanTree(int[] w, int n) {
        int m = 2 * n - 1;
        huffNodes = new HuffmanNode[m + 1];
        // 初始化
        for (int i = 1; i <= m; i++) {
            huffNodes[i] = new HuffmanNode(0, 0, 0, 0);
        }
        // 设置初始化值
        for (int i = 1; i <= n; i++) {
            huffNodes[i].weight = w[i - 1];
        }

        for (int i = n + 1; i <= m; i++) {
            int[] childIndex = minChild(i - 1);
            huffNodes[i].lChild = childIndex[0];
            huffNodes[i].rChild = childIndex[1];
            huffNodes[childIndex[0]].parent = huffNodes[childIndex[1]].parent = i;
            huffNodes[i].weight = huffNodes[childIndex[0]].weight + huffNodes[childIndex[1]].weight;
        }
    }

    public void releaseHuffmanTree() {
        for (int i = 0; i < huffNodes.length; i++) {
            huffNodes[i] = null;
        }

        huffNodes = null;
    }

    private int[] minChild(int n) {
        int min = 0;
        int child[] = new int[2];

        // 寻找最小权值编号
        for (int i = 1; i <= n; i++) {
            if (huffNodes[i].parent == 0) {
                min = i;
                break;
            }
        }
        for (int i = 1; i <= n; i++) {
            if (huffNodes[i].parent == 0 && huffNodes[i].weight < huffNodes[min].weight)
                min = i;
        }
        child[0] = min;

        // 寻找第二小的权值编号
        for (int i = 1; i <= n; i++) {
            if (huffNodes[i].parent == 0 && i != child[0]) {
                min = i;
                break;
            }
        }
        for (int i = 1; i <= n; i++) {
            if (huffNodes[i].parent == 0 && i != child[0] && huffNodes[i].weight < huffNodes[min].weight)
                min = i;
        }
        child[1] = min;

        return child;
    }

    public String[] createHuffmanCode(int n) {
        String[] codes = new String[n];

        for (int i = 1; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            int pos = i;
            int p = huffNodes[pos].parent;

            while (p != 0) {
                char bit = (huffNodes[p].lChild == pos) ? '0' : '1';
                sb.insert(0, bit); // 始终插在开头，实现倒序
                pos = p;
                p = huffNodes[pos].parent;
            }
            codes[i - 1] = sb.toString();
        }
        return codes;
    }

    @Override
    public String toString() {
        return Arrays.toString(huffNodes);
    }
}
