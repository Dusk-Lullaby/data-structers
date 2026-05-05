package com.Sonnet.matrix_graph;

public class MatrixGraph<T> {

     public static class MatrixVertex<T> {
         private int number;     // 顶点的序号
         private T show;         // 顶点所代表的数据

         public MatrixVertex(int number, T show) {
             this.number = number;
             this.show = show;
         }

         public T getShow() {
             return show;
         }
     }

    public static class MatrixEdge {
        private int matrixEdge;       // 边的权重

        public MatrixEdge(int matrixEdge) {
            this.matrixEdge = matrixEdge;
        }

        public int getMatrixEdge() {
            return matrixEdge;
        }
    }

    private static final int MAX_VERTEX_NUM = 10;   // 最大顶点数
    private final int INF = (int) 1E4;       // 无穷大

    private boolean[] visited;              // 已经访问数组
    private MatrixVertex<T>[] vertices;    // 顶点数组
    private MatrixEdge[][] edges;       // 边的二维数组
    private int vertexNum;              // 顶点个数
    private int edgeNum;                // 边的个数
    private boolean directed;           // 是否有向

    public MatrixGraph(T[] show, int vertexNum, boolean directed, int weight) {
        this.edgeNum = 0;
        this.directed = directed;
        this.vertexNum = vertexNum;
        this.vertices = new MatrixVertex[MAX_VERTEX_NUM];
        this.edges = new MatrixEdge[MAX_VERTEX_NUM][MAX_VERTEX_NUM];
        this.visited = new boolean[MAX_VERTEX_NUM];

        // 初始化顶点数组和已访问数组
        for (int i = 0; i < vertexNum; i++) {
            this.vertices[i] = new MatrixVertex<>(i, show[i]);
            this.visited[i] = false;

            // 初始化边数组
            for (int j = 0; j < vertexNum; j++) {
                this.edges[i][j] = new MatrixEdge(weight);
            }
        }
    }

    public int getINF() {
        return INF;
    }

    public MatrixVertex<T>[] getVertices() {
        return vertices;
    }

    public int getVertexNum() {
        return vertexNum;
    }

    public MatrixEdge[][] getEdges() {
        return edges;
    }

    public int getEdgeNum() {
        return this.edgeNum;
    }

    /*
        功能：添加边
        参数：起点 终点 权重
        返回值：无
     */
    public void addMatrixGraph(int x, int y, int weight) {
        if (x < 0 || x >= this.vertexNum || y < 0 || y >= this.vertexNum)
            return;
        if (!isEdge(weight))
            return;

        this.edges[x][y].matrixEdge = weight;
        // 无向图
        if (!this.directed) {
            this.edges[y][x].matrixEdge = weight;
        }
        this.edgeNum++;
    }

    /*
        功能：判断是否是边
        参数：权重
        返回值：是true 否false
     */
    private boolean isEdge(int weight) {
        if (weight > 0 && weight < INF)
            return true;
        return false;
    }

    /*
        功能：访问
        参数：顶点
        返回值：无
     */
    private void visitedMatrixVertex(MatrixVertex<T> vertex) {
        System.out.print(vertex.show + "\t");
    }

    /*
        功能：深度优先搜索
        参数：从第几个顶点开始搜索
        返回值：无
     */
    public void DFSMatrixGraph(int v) {
        visitedMatrixVertex(this.vertices[v]);
        this.visited[v] = true;

        // 从v节点开始，找到一个边节点，再通过这个节点进行DFS
        for (int i = 0; i < this.vertexNum; i++) {
            if (isEdge(this.edges[v][i].matrixEdge) && !this.visited[i]) {
                DFSMatrixGraph(i);
            }
        }
    }

    /*
        功能：广度优先搜索
        参数：从第几个顶点开始搜索
        返回值：无
     */
    void BFSMatrixGraphTravel(int v) {
        // 申请队列
        int[] queue = new int[MAX_VERTEX_NUM];
        int rear = 0;
        int front = 0;
        // 入队
        rear = (rear + 1) % MAX_VERTEX_NUM;
        queue[rear] = v;
        this.visited[v] = true;

        while (front != rear) {
            // 出队
            front = (front + 1) % MAX_VERTEX_NUM;
            int cur = queue[front];
            visitedMatrixVertex(this.vertices[cur]);
            for (int i = 0; i < this.vertexNum; i++) {
                // 是边并且没有被访问
                if (isEdge(this.edges[cur][i].matrixEdge) && !this.visited[i]) {
                    rear = (rear + 1) % MAX_VERTEX_NUM;
                    queue[rear] = i;
                    this.visited[i] = true;
                }
            }
        }
    }

    /*
        功能：重置已访问数组
        参数：无
        返回值：无
     */
    public void resetVisited() {
        for (int i = 0; i < this.edgeNum; i++) {
            this.visited[i] = false;
        }
    }
}
