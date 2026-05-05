package com.Sonnet.adjacency_list;

import java.util.ArrayDeque;
import java.util.Queue;

public class AdjacencyList<T> {

    // 边结构
    public static class ArcEdge {
        private int number;     // 指向的终点
        private int weight;     // 权值
        private ArcEdge next;   // 下一条边

        public int getNumber() {
            return number;
        }

        public int getWeight() {
            return weight;
        }

        public ArcEdge getNext() {
            return next;
        }

        public ArcEdge(int number, int weight, ArcEdge next) {
            this.number = number;
            this.weight = weight;
            this.next = next;


        }
    }

    // 顶点结构
    public static class ArcNode<T> {
        int number;
        T show;
        ArcEdge firstEdge;      // 出度

        public int getNumber() {
            return number;
        }

        public T getShow() {
            return show;
        }

        public ArcEdge getFirstEdge() {
            return firstEdge;
        }

        public ArcNode(int number, T show, ArcEdge firstEdge) {
            this.number = number;
            this.show = show;
            this.firstEdge = firstEdge;
        }
    }

    private ArcNode<T>[] nodes;     // 顶点数组
    private boolean[] visited;          // 已访问数组
    private int nodeNum;            // 顶点的个数
    private int edgeNUm;            // 边的个数
    private boolean directed;       // 是否有向

    public AdjacencyList(int n) {
        this.nodes = new ArcNode[n];
        this.visited = new boolean[n];
        this.nodeNum = n;
    }

    /*
        功能：初始化邻接链表
        参数：顶点数组 是否有向
        返回值：无
     */
    public void initAGraph(T[] shows, boolean directed) {
        this.directed = directed;
        this.edgeNUm = 0;
        for (int i = 0; i < this.nodeNum; i++) {
            this.nodes[i] = new ArcNode<>(i, shows[i], null);
            this.visited[i] = false;
        }
    }

    /*
        功能：添加边
        参数：起点 终点 权重
        返回值：无
     */
    public void addAGraphEdge(int x, int y, int w) {
        if (x < 0 || y < 0 || x >= this.nodeNum || y >= this.nodeNum)
            return;

        // 头插法处理
        ArcEdge edge = new ArcEdge(y, w, this.nodes[x].firstEdge);
        this.nodes[x].firstEdge = edge;
        this.edgeNUm++;

        // 无向图
        if (!this.directed) {
            edge = new ArcEdge(x, w, this.nodes[y].firstEdge);
            this.nodes[y].firstEdge = edge;
        }
    }

    /*
        功能：访问
        参数：顶点
        返回值：无
     */
    private void visitedNode(ArcNode<T> node) {
        System.out.print(node.show + "\t");
    }

    /*
        功能：深度优先搜索
        参数：开始搜索的位置
        返回值：无
     */
    public void DFSAGraphTravel(int v) {
        this.visited[v] = true;
        visitedNode(this.nodes[v]);
        ArcEdge p = this.nodes[v].firstEdge;

        while (p != null) {
            if (!this.visited[p.number]) {
                DFSAGraphTravel(p.number);
            }
            p = p.next;
        }
    }

    /*
        功能：广度优先搜索
        参数：从第几个位置开始搜索
        返回值：无
     */
    public void BFSAGraphTravel(int v) {
        // 重置
        resetVisited();

        // 用队列实现模拟
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(v);
        this.visited[v] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            visitedNode(this.nodes[cur]);
            ArcEdge p = this.nodes[cur].firstEdge;

            while (p != null) {
                if (!this.visited[p.number]) {
                    queue.offer(p.number);
                    this.visited[p.number] = true;
                }

                p = p.next;
            }
        }
    }

    /*
        功能：重置已访问数组
        参数：无
        返回值：无
     */
    private void resetVisited() {
        for (int i = 0; i < this.nodeNum; i++) {
            this.visited[i] = false;
        }
    }

    /*
        功能：释放
        参数：无
        返回值：无
     */
    public void releaseAGraph() {
        this.visited = null;
        this.nodes = null;
        this.nodeNum = 0;
    }

    public int getEdgeNUm() {
        return edgeNUm;
    }

    public ArcNode<T>[] getNodes() {
        return nodes;
    }

    public boolean[] getVisited() {
        return visited;
    }

    public int getNodeNum() {
        return nodeNum;
    }

    public boolean isDirected() {
        return directed;
    }
}
