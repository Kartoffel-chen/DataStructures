package cn.cz.stack;

import java.util.Scanner;

/**
 * @author Kartoffel
 * @create 2020-02-21-11:17
 */
public class StackLinkedListDemo {
    public static void main(String[] args) {
        StackLinkedList stackLinkedList = new StackLinkedList(5);
        Scanner in = new Scanner(System.in);
        Boolean loop = true;
        while(loop){
            System.out.println("输入push添加数组到栈内");
            System.out.println("输入show,查看栈内数");
            System.out.println("输入pop出栈");
            System.out.println("输入exit退出程序");
            System.out.println("请输入指令");
            String input = in.next();

            switch (input){
                case "push":
                    System.out.print("请输入需要添加的数据 : ");
                    int num = in.nextInt();   //接受输入数据
                    Node node = new Node(num);   //创建节点
                    stackLinkedList.push(node);   //如栈
                    break;
                case "pop":
                    try{
                        stackLinkedList.pop();
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "show":
                    try{
                        stackLinkedList.show();
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    in.close();
                    loop = false;
                    break;
                default:
                    break;
            }
            System.out.println("-----------------------------------------------------");
        }
    }
}

class StackLinkedList {
    private int size;
    private int top = -1;   //指向栈顶
    private Node head = new Node(0);

    public StackLinkedList(int size) {
        this.size = size;
    }

    //栈满
    public boolean isFull() {
        return top == size - 1;
    }

    //栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈
    public void push(Node node) {
        //判断是否栈满
        if (isFull()) {
            System.out.println("栈满,不能加入数");
            return;
        }
        top++;
        //借助辅助指针
        Node temp = head;
        while (temp.getNext() != null){
            temp= temp.getNext();
        }
        temp.setNext(node);
    }

    //出栈
    public void pop(){
        if(isEmpty()){
            throw new RuntimeException("栈中无数据");
        }
        top --;
        //借助辅助指针
        Node temp = head.getNext();
        for(int i = 0 ; i <= top ; i ++){
            temp= temp.getNext();
        }
        System.out.println(temp.getId());
    }

    //显示栈信息
    public void show(){
        if(isEmpty()){
            throw new RuntimeException("栈中无数据");
        }
        Node temp = head.getNext();

        for(int i = 0 ; i <= top ; i ++){
            System.out.println(temp.getId());
            temp= temp.getNext();
        }
    }
}

class Node {
    private int id;
    private Node next;
    private Node top;

    public Node(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getTop() {
        return top;
    }

    public void setTop(Node top) {
        this.top = top;
    }
}