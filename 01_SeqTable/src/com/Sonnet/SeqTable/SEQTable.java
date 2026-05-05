package com.Sonnet.SeqTable;

public class SEQTable {
    public int[] data;
    int pos;
    int capacity;

    /*
        功能：初始化顺序表
        参数：需要的元素个数
     */
    public SEQTable( int n) {
        this.data = new int[n];
        this.pos = 0;
        this.capacity = n;
    }

    /*
        功能： 打印顺序表中的信息
        参数： 无
        返回值： 无
            1. 判断该顺序表中是否有元素，没有元素则进行提示
            2. 遍历打印
     */
    public void showSeqTable() {
        if (this.pos == 0) {
            System.out.println("data is null");
            return;
        }
        System.out.println("pos is " + this.pos + " and capacity is " + this.capacity);
        for (int i = 0 ; i < this.pos; i++) {
            System.out.print(this.data[i] + " ");
        }
        System.out.println();
    }

    /*
        功能：尾插
        参数：需要插入的元素
        返回值：成功true ， 失败false
            1. 判断是否需要扩容
            2. 尾插
     */
    public boolean pushbackSeqTable(int value) {
        if (this.pos == this.capacity) {
            this.enlargerSeqTable();
        }
        this.data[pos++] = value;

        return true;
    }

    /*
        功能： 顺序表扩容
        参数： 无
        返回值： 成功true 失败false
            1. 开辟新空间
            2. 将老空间中的元素拷贝到新空间中
            3. 让data指针指向新空间
     */
    public boolean enlargerSeqTable2() {
        int[] tmp = new int[capacity * 2];
        for (int i = 0; i < this.capacity; i++) {
            tmp[i] = this.data[i];
        }
        this.data = tmp;
        this.capacity *= 2;

        return true;
    }

        /*
        功能： 顺序表扩容
        参数： 无
        返回值： 成功true 失败false
            1. 开辟新空间
            2. 将老空间中的元素拷贝到新空间中
            3. 让data指针指向新空间
     */
    public boolean enlargerSeqTable() {
        int[] tmp = new int[capacity * 2];
        System.arraycopy(this.data, 0, tmp, 0, capacity);
        this.data = tmp;
        this.capacity *= 2;

        return true;
    }

    /*
        功能： 查找对应元素的索引
        参数： 需要查找的元素
        返回值： 对应元素的索引值， 如果没找到则返回-1
     */
    public int findIndexOfSeqTable(int value) {
        int index = 0;
        for (int i = 0; i < this.pos; i++) {
            if (value == this.data[i]) {
                index = i;
                return index;
            }
        }
        System.out.println("not found index");
        return -1;
    }

    /*
        功能： 顺序表的删除
        参数： 需要删除的元素
        返回值： 成功true 失败false
            1. 获得需要删除元素的索引
            2. 删除
     */
    public boolean deleteSeqTable(int value) {
        int index = this.findIndexOfSeqTable(value);
        if (index == -1) {
            return false;
        }
        for (int i = index + 1; i < this.pos; i++) {
            this.data[i - 1] = this.data[i];
        }
        this.pos--;

        return true;
    }

    /*
    功能： 任意位置添加元素
    参数： 需要添加的索引位置 需要添加的元素
    返回值： 成功true 失败false
        1. 索引合法性
        2. 是否扩容
        3. 插入
 */
    public boolean insertSeqTable(int index, int value) {
        if (index < 0 || index >= this.pos) {
            System.out.println("index invalid");
            return false;
        }
        if (this.pos == this.capacity ) {
            this.enlargerSeqTable();
        }
        for (int i = this.pos - 1; i >= index; i--) {
            this.data[i + 1] = this.data[i];
        }
        this.data[index] = value;
        this.pos++;

        return true;
    }

    /*
        功能： 修改顺序表中的元素
        参数： 旧元素 新元素
        返回值： 成功true 失败false
            1. 获得需要修改元素的索引
            2. 对旧元素进行修改
     */
    public boolean setSeqTable(int old, int value) {
        int index = this.findIndexOfSeqTable(old);
        if (index == -1) return false;
        this.data[index] = value;

        return true;
    }

}
