package cn.cz.circlelinkedlist;

/**
 * 小孩类
 * @author Kartoffel
 * @create 2020-02-20-10:44
 */
public class BoyNode {
    private int no;
    private BoyNode next;

    public BoyNode(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    @Override
    public String toString() {

        return "第" + no + "个小孩";
    }

    public BoyNode getNext() {
        return next;
    }

    public void setNext(BoyNode next) {
        this.next = next;
    }
}
