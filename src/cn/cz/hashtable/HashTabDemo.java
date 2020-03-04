package cn.cz.hashtable;

import java.text.BreakIterator;
import java.util.Scanner;

/**
 * @author Kartoffel
 * @create 2020-03-03-22:11
 */
public class HashTabDemo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //创建5个哈希链表
        HashTab hashTab = new HashTab(5);

        String key = "";
        while (true) {
            System.out.println("输入add添加数据到哈希表");
            System.out.println("输入show显示哈希表");
            System.out.println("输入find找到找到学生信息");
            System.out.println("输入delete删除哈希表中信息");
            System.out.println("输入exit退出程序");

            key = input.next();

            switch (key) {
                case "add":
                    System.out.println("请输入要添加的学生id");
                    int id = input.nextInt();
                    System.out.println("请输入学生姓名");
                    String name = input.next();
                    Student student = new Student(id, name);
                    hashTab.add(student);
                    break;
                case "show":
                    hashTab.show();
                    break;
                case "find":
                    System.out.println("请输入需要查找的学生id");
                    int findId = input.nextInt();
                    hashTab.find(findId);
                    break;
                case "delete":
                    System.out.println("请输入需要删除的学生id");
                    int deleteId = input.nextInt();
                    hashTab.delete(deleteId);
                    break;
                case "exit":
                    input.close();
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }
}

//哈希标
class HashTab {
    private int size;
    private StuLinkedList[] hashArr;

    public HashTab(int size) {
        this.size = size;
        hashArr = new StuLinkedList[size];

        //实例化数组
        for (int i = 0; i < hashArr.length; i++) {
            hashArr[i] = new StuLinkedList();
        }
    }

    //哈希标添加方法
    public void add(Student student) {
        //根据员工id获取hash表的插入位置
        int index = hashIndex(student.getId());
        hashArr[index].add(student);
    }

    //哈希表显示方法
    //遍历
    public void show() {
        for (int i = 0; i < hashArr.length; i++) {
            hashArr[i].show(i);
        }
    }

    //哈希表删除法
    public void delete(int id) {
        int index = hashIndex(id);
        hashArr[index].delete(id);
    }

    //查找哈希表中的数据
    public void find(int id) {
        int index = hashIndex(id);
        Student student = hashArr[index].find(id);
        if (student == null) {
            System.out.printf("没有找到%d这个学生\n", id);
        } else {
            System.out.printf("在第%d条链表中找到学生id = %d\n ", index, id);
        }
    }

    //获取哈希插入位置
    public int hashIndex(int id) {
        return id % size;
    }

    public int getSize() {
        return size;
    }
}


//节点管理
class StuLinkedList {
    //头接待你
    Student head = null;

    public StuLinkedList() {
    }

    //添加节点方法
    //班级学号,我们按照id顺序添加,所以只用在链表最后添加
    public void add(Student newStu) {
        //如果是添加进来的第一个节点
        if (head == null) {
            head = newStu;
            return;
        }
        //借助辅助指针
        Student temp = head;

        //遍历找到最后一个节点
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        //退出循环,temp指向最后一个元素
        temp.setNext(newStu);
        newStu.setPro(temp);
    }

    //显示链表
    public void show(int index) {
        //首先判断链表是否为空
        if (head == null) {
            System.out.println("链表" + (index + 1) + "为空");
            return;
        }
        System.out.print("链表" + (index + 1) + "信息为 : ");

        //借助辅助指针
        Student temp = head;
        while (temp != null) {
            System.out.print("===> 学号:" + temp.getId() + ", 姓名:" + temp.getName() + "   ");
            temp = temp.getNext();
        }
        System.out.println();
    }

    //删除链表
    //根据id删除
    public void delete(int id) {
        //判断链表是否为空
        if (head == null) {
            System.out.println("链表为空");
            return;
        }

        //借助辅助指针
        Student temp = head;
        boolean flag = false;
        while (temp != null) {
            if (id == temp.getId()) {
                flag = true;
                break;
            }
            temp = temp.getNext();
        }

        if (flag) {
            if(temp == head){
                head = temp.getNext();
            }else if(temp.getNext() == null){
                temp.getPro().setNext(null);
            }else{
                temp.getNext().setPro(temp.getPro());
                temp.getPro().setNext(temp.getNext());
            }
            System.out.println("删除成功");
        } else {
            System.out.println("没有找到需要删除的学生信息 id = " + id);
        }
    }

    //查找链表信息
    public Student find(int id) {
        //首先判断链表是否为空
        if (head == null) {
            System.out.println("链表为空");
            return null;
        }

        //借助辅助指针
        Student temp = head;
        boolean flag = false;
        while (true) {
            //判断是否找到id
            if (id == temp.getId()) {
                //找到
                break;
            }
            if (temp.getNext() == null) {
                temp = null;
            }

            temp = temp.getNext();
        }
        return temp;
    }
}

//创建一个学生类
class Student {
    private int id;   //学生学号
    private String name;   //学生姓名
    private Student next;
    private Student pro;

    public Student getPro() {
        return pro;
    }

    public void setPro(Student pro) {
        this.pro = pro;
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student getNext() {
        return next;
    }

    public void setNext(Student next) {
        this.next = next;
    }

}
