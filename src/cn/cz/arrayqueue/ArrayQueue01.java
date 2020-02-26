package cn.cz.arrayqueue;

import java.util.Scanner;

/**
 * 模拟简单的队列
 *
 * @author Kartoffel
 * @create 2020-02-15-11:19
 */
public class ArrayQueue01 {
    public static void main(String[] args) {
        //测试
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' ';   //接受用户输入
        Scanner in = new Scanner(System.in);
        boolean loop = true;

        while(loop){
            System.out.println("s(show) : 显示队列");
            System.out.println("a(add) : 添加数据到队列");
            System.out.println("g(get) : 从队列取出数据");
            System.out.println("h(head) : 显示头数据");
            System.out.println("e(exit) : 退出程序");

            key = in.next().charAt(0);   //接收用户输入
            switch (key){
                case 's' :   //显示队列
                    arrayQueue.showQueue();
                    break;
                case 'a' :   //添加数据
                    System.out.println("请输入一个数据");
                    int value = in.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g' :   //获取数据
                    try{
                        int temp = arrayQueue.getQueue();
                        System.out.println(temp);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h' :   //获取头数据
                    try{
                        int head = arrayQueue.headQueue();
                        System.out.println(head);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e' :
                    in.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }

    }
}

//创建一个队列
class ArrayQueue {
    private int maxsize;   //队列最大值
    private int front;   //队列头
    private int rear;   //对列尾
    private int[] arr;   //用于存放数据

    //ArrayaQueue构造器
    public ArrayQueue(int maxsize) {
        this.maxsize = maxsize;
        arr = new int[maxsize];
        front = -1;   //队列中没元素时候指向数组第一个元素的前一个
        rear = -1;   //同上
    }

    //添加数据
    public void addQueue(int number){
        //先判断队列是否满
        if(isFull()){
            System.out.println("队列满不能添加数据");
            return;
        }
        //往数组添加数据
        rear ++;
        arr[rear] = number;
    }

    //取出数据
    public int getQueue(){
        //先判断队列是否空
        if(isEmpty()){
            throw new RuntimeException("队列为空,不能取出数据");
        }
        front ++;  //队列头指向后一位
        return arr[front];
    }

    //显示队列
    public void showQueue(){
        //先判断队列是否为空
        if(isEmpty()){
            System.out.println("队列为空,无法显示");
            return;
        }

        for(int i = 0 ; i < arr.length ; i ++){
            System.out.printf("arr[%d] = %d\n",i ,arr[i]);
        }
    }

    //显示头元素
    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空,没有头数据");
        }
        return arr[front + 1];
    }


    //判断队列是否为空
    private boolean isEmpty() {
        return front == rear;
    }

    //判断队列为满
    private boolean isFull() {
        return rear == maxsize - 1;
    }
}