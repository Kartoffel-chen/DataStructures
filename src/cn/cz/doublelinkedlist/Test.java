package cn.cz.doublelinkedlist;

/**
 * @author Kartoffel
 * @create 2020-02-19-18:18
 */
public class Test {
    public static void main(String[] args) {
        StudentNode s1 = new StudentNode(1,"张三","小三");
        StudentNode s2 = new StudentNode(2,"李四","小四");
        StudentNode s3 = new StudentNode(3,"王二","小王");
        StudentNode s4 = new StudentNode(4,"麻子","小麻");
        StudentNode s11 = new StudentNode(11,"无限大","无限");
        StudentNode s7 = new StudentNode(7,"最后","尾巴");

        DoublieLinkedList doublieLinkedList = new DoublieLinkedList();
        doublieLinkedList.addByOrder(s1);
        doublieLinkedList.addByOrder(s3);
        doublieLinkedList.addByOrder(s4);
        doublieLinkedList.addByOrder(s11);
        doublieLinkedList.addByOrder(s2);
        doublieLinkedList.addTheEnd(s7);

        System.out.println("显示节点测试");
        doublieLinkedList.show();
        System.out.println("-----------------------------------------------------------------");

        System.out.println("删除节点测试");
        doublieLinkedList.delete(1);
        doublieLinkedList.show();
        System.out.println("-----------------------------------------------------------------");

        System.out.println("修改信息测试");
        StudentNode news = new StudentNode(4,"鸣人","小人");
        doublieLinkedList.upDate(news);
        doublieLinkedList.show();
        System.out.println("-----------------------------------------------------------------");

    }
}
