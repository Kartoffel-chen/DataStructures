package cn.cz.circlelinkedlist;

/**
 * @author Kartoffel
 * @create 2020-02-20-10:46
 */
public class CircleLinkedList {

    //定义一个头节点
    private BoyNode first = null;

    public void add(int num) {   // 接收需要创建的小孩人数
        //有效值校验
        if (num < 1) {
            System.out.println("输入值不正确");
            return;
        }

        //循环创建
        //借助辅助指针进行遍历
        BoyNode temp = first;
        for (int i = 1; i <= num; i++) {
            BoyNode boy = new BoyNode(i);
            if (i == 1) {
                first = boy;
                first.setNext(first);   // 构成一个环状
                temp = first;
            } else {
                temp.setNext(boy);
                boy.setNext(first);
                temp = boy;
            }
        }
    }

    public void show() {
        //判断链表是否为空
        if (first == null) {
            System.out.println("链表为空");
            return;
        }

        //借助辅助指针遍历
        BoyNode temp = first;
        while (true) {
            System.out.println(temp);
            if (temp.getNext() == first) {
                break;
            }
            temp = temp.getNext();
        }
    }

    /**
     * @param startNo  表示从第几个小孩开始数
     * @param countNum 表示每次数几个
     * @param num      表示小孩的个数
     */
    public void countBoy(int startNo, int countNum, int num) {
        //先对输入数据进行校验
        if (startNo < 1 || countNum > num || first == null) {
            System.out.println("输入数据有误,请确认后输入");
            return;
        }

        //借助一个辅助指针指向最后一个小孩
        BoyNode last = first;
        while (last.getNext() != first){
            last = last.getNext();
        }

        //把first指向需要开始数数的小孩位置
        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
            last = last.getNext();
        }

        // 说明圈中只有一个人
        while (last != first) {
            //把first指向需要开始数数的小孩位置
            for (int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
                last = last.getNext();
            }
            System.out.println("第" + first.getNo() + "个小孩出圈");
            first = first.getNext();
            last.setNext(first);
        }
        System.out.println("最后留在圈中的小孩是" + first.getNo());
    }
}

