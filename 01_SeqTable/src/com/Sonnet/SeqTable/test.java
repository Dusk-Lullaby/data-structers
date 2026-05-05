package com.Sonnet.SeqTable;

public class test {
    public static void main(String[] args) {
        SEQTable table = new SEQTable(5);
        table.showSeqTable();
        System.out.println("----------------");
        for(int i = 0; i < 5; i++) {
            table.pushbackSeqTable(i + 100);
        }
        table.showSeqTable();
        System.out.println("-----------------");
        table.pushbackSeqTable(82);
        table.showSeqTable();
        System.out.println("-------------------");
        table.deleteSeqTable(103);
        table.showSeqTable();
        System.out.println("-----------------");
        table.insertSeqTable(3, 802);
        table.showSeqTable();
        System.out.println("-----------------");
        table.setSeqTable(101, 802);
        table.showSeqTable();
    }

}
