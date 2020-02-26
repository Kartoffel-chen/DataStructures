package cn.cz.circlelinkedlist;

/**
 * @author Kartoffel
 * @create 2020-02-20-11:03
 */
public class Test {
    public static void main(String[] args) {
        CircleLinkedList c = new CircleLinkedList();
        c.add(5);
        c.show();
        c.countBoy(1,2,5);
    }
}
