package cn.cz.singlinkedlist;

/**
 * @author Kartoffel
 * @create 2020-02-16-15:20
 */
public class MergeLinkedList {
    public static void main(String[] args) {
        //一班学生信息
        StudentNode studentNode1 = new StudentNode(1, "张三", "班长");
        StudentNode studentNode2 = new StudentNode(2, "李四", "团支部");
        StudentNode studentNode3 = new StudentNode(3, "王五", "文艺委员");
        StudentNode studentNode4 = new StudentNode(9, "小强", "咸鱼");
        //二班
        StudentNode studentNode01 = new StudentNode(1, "成龙", "班长");
        StudentNode studentNode02 = new StudentNode(6, "王宝强", "铁憨憨");
        StudentNode studentNode03 = new StudentNode(5, "刘亦菲", "文艺委员");
        StudentNode studentNode04 = new StudentNode(7, "刘翔", "体育委员");
        StudentNode studentNode05 = new StudentNode(10, "丁宁", "大魔王");

        //创建单项链表1
        StudentManage studentManage01 = new StudentManage();
        //添加学生信息到链表1
        studentManage01.add(studentNode4);
        studentManage01.add(studentNode1);
        studentManage01.add(studentNode3);
        studentManage01.add(studentNode2);

        //创建单项链表2
        StudentManage studentManage02 = new StudentManage();
        //添加学生信息到链表1
        studentManage02.add(studentNode04);
        studentManage02.add(studentNode01);
        studentManage02.add(studentNode03);
        studentManage02.add(studentNode02);
        studentManage02.add(studentNode05);

        //修改信息
        StudentNode studentNode5 = new StudentNode(5, "王小五", "垃圾委员");
        studentManage02.upData(studentNode5);
        //删除信息
        studentManage01.delete(9);
        //显示链表信息
        studentManage01.show();
        System.out.println("---------------分界线-----------------------");
        studentManage02.show();


        System.out.println("结束");
    }
}

class StudentManage {
    //创建一个头节点[不能动]
    private StudentNode head = new StudentNode(0, "", "");

    public StudentNode getHead() {
        return head;
    }

    public void setHead(StudentNode head) {
        this.head = head;
    }

    //删除节点信息
    public void delete(int id) {
        //判断链表是否为空
        if (head.getNext() == null) {
            System.out.println("链表为空");
            return;
        }

        //借助辅助指针进行遍历
        StudentNode temp = head.getNext();
        boolean flag = false;   //用于判断是否找到需要删除的节点
        while (temp.getNext() != null) {
            if (temp.getNext().getId() == id) {   //如果指针的下一个节点满足,就把指针的下一个节点的于下一个节点的下一个连接就行
                flag = true;
                break;
            }
            temp = temp.getNext();
        }

        if (flag) {
            temp.setNext(temp.getNext().getNext());
        } else {
            System.out.println("没有找到需要删除id信息" + id);
        }
    }

    //修改节点信息
    //按照学生id进行修改
    public void upData(StudentNode studentNode) {
        //判断链表是否为空
        if (head.getNext() == null) {
            System.out.println("链表为空");
            return;
        }

        //借助辅助指针进行遍历
        StudentNode temp = head.getNext();
        boolean flag = false;   //用于判断是否找到需要修改的节点
        while (!(temp == null)) {
            if (temp.getId() == studentNode.getId()) {
                flag = true;
                break;
            }
            temp = temp.getNext();
        }

        if (flag) {
            temp.setName(studentNode.getName());
            temp.setPosition(studentNode.getPosition());
        } else {
            System.out.println("没有找到需要修改的学号 : " + studentNode.getId());
        }
    }

    public void add01(StudentNode studentNode) {
        //现在到最后一个节点,然后把最后一个节点的next指向新节点
        //遍历需要借助辅助变量
        StudentNode temp = head;
        while (true) {
            //判断是否到链表最后
            if (temp.getNext() == null) {
                break;
            }
            //如果没有到链表最后,后移指针
            temp = temp.getNext();
        }

        //当循环结束,一定指向最后一个节点
        //添加节点
        temp.setNext(studentNode);
    }

    //添加节点方法
    //按照顺序添加
    public void add(StudentNode studentNode) {
        //借助辅助指针进行遍历
        StudentNode temp = head;
        boolean flag = false;   //用来判断是否找到添加位置

        while (true) {
            //判断是否最后节点
            if (temp.getNext() == null) {
                break;
            }
            //按照id来排序
            if (temp.getNext().getId() > studentNode.getId()) {
                break;
            } else if (studentNode.getId() == temp.getNext().getId()) {
                flag = true;  //找到 就在temp后面
                break;
            }
            temp = temp.getNext();
        }
//        if (flag) {
//            System.out.println("要添加的学生id已经存在,不能添加id = " + studentNode.getId() + "的信息");
//        } else {
        studentNode.setNext(temp.getNext());
        temp.setNext(studentNode);
//        }
    }

    //显示链表
    public void show() {
        //判断链表是否为空
        if (head.getNext() == null) {
            System.out.println("链表为空");
            return;
        }
        //借助辅助指针进行遍历
        StudentNode temp = head.getNext();
        while (temp != null) {
            System.out.println(temp);
            temp = temp.getNext();
        }
    }
}

class StudentNode {
    private int id;   //学生id
    private String name;   //学生名字
    private String position;   //职位
    private StudentNode next;   //下一个节点

    public StudentNode(int id, String name, String position) {
        this.id = id;
        this.name = name;
        this.position = position;
    }

    public StudentNode getNext() {
        return next;
    }

    public void setNext(StudentNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "学生信息 : {" +
                "学号=" + id +
                ", 姓名='" + name + '\'' +
                ", 职位='" + position + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
