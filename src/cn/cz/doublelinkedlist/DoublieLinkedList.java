package cn.cz.doublelinkedlist;

import com.sun.source.tree.IfTree;

/**
 * 双向链表
 *
 * @author Kartoffel
 * @create 2020-02-19-16:17
 */
public class DoublieLinkedList {
    //定义头节点(不能动)
    private StudentNode head = new StudentNode(0, "", "");

    //添加方法二,按照id升序排序
    public void addByOrder(StudentNode studentNode){
        //同样借助辅助变量
        StudentNode temp = head;
        boolean flag = false;   // 用记录是否存在相同id

        while (temp.next != null){
            //判断id是否存在
            if(studentNode.getId() == temp.next.getId()){
                flag = true;
                break;
            }

            //找到插入位置
            if(temp.next.getId() > studentNode.getId()){
                break;
            }
            //后移指针
            temp = temp.next;
        }

        if(flag){   // 存在相同
            System.out.println("要添加的id已经存在,不能再次添加");
            return;
        }else{
            studentNode.next = temp.next;
            studentNode.pro = temp;
            temp.next = studentNode;
        }
    }

    //在链表最后添加,不考虑排序
    public void addTheEnd(StudentNode studentNode) {
        //借助辅助变量(指针)
        StudentNode temp = head;
        //遍历链表
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = studentNode;
        studentNode.pro = temp;
    }

    //修改链表信息
    public void upDate(StudentNode newNode){
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }

        //借助辅助变量(指针)进行遍历
        StudentNode temp = head.next;
        boolean flag = false;   //用于判断该是否找到需要修改的节点id

        while (temp != null) {   // temp为空 终止循环
            if(newNode.getId() == temp.getId()){
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if(flag){   //找到
            temp.setName(newNode.getName());
            temp.setNikeName(newNode.getNikeName());
        }else{   // 没找到
            System.out.println("没有找到需要删除的节点信息");
        }
    }

    // 删除信息(按照id删除)
    public void delete(int id) {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }

        //借助辅助变量(指针)遍历
        StudentNode temp = head.next;
        boolean flag = false;   // 用于判断是否找到需要删除的节点信息
        while (temp != null) {   //temp为空,终止循环
            if (id == temp.getId()) {
                flag = true;
                break;
            }

            temp = temp.next;
        }

        if (flag) {   // 找到
            temp.pro.next = temp.next;
            if (temp.next != null) {   // 判断是否是最后一个节点
                temp.next.pro = temp.pro;
            }
        } else {
            System.out.println("没有找到需要删除的信息");
        }
    }

    //显示链表
    public void show() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }

        //借助辅助变量(指针)遍历
        StudentNode temp = head;
        while (temp.next != null) {
            System.out.println(temp.next);
            temp = temp.next;
        }
    }
}

