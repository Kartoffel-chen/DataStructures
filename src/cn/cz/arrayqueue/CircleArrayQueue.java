package cn.cz.arrayqueue;

import java.util.Scanner;

/**
 * @author Kartoffel
 * @create 2020-02-15-15:24
 */
public class CircleArrayQueue {
    public static void main(String[] args) {
        //测试
        ArrayQueue02 ArrayQueue02 = new ArrayQueue02(4);
        char key = ' ';   //接受用户输入
        Scanner in = new Scanner(System.in);
        boolean loop = true;

        while (loop) {
            System.out.println("s(show) : 显示队列");
            System.out.println("a(add) : 添加数据到队列");
            System.out.println("g(get) : 从队列取出数据");
            System.out.println("h(head) : 显示头数据");
            System.out.println("e(exit) : 退出程序");

            key = in.next().charAt(0);   //接收用户输入
            switch (key) {
                case 's':   //显示队列
                    ArrayQueue02.showQueue();
                    break;
                case 'a':   //添加数据
                    System.out.println("请输入一个数据");
                    int value = in.nextInt();
                    ArrayQueue02.addQueue(value);
                    break;
                case 'g':   //获取数据
                    try {
                        int temp = ArrayQueue02.getQueue();
                        System.out.println(temp);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':   //获取头数据
                    try {
                        int head = ArrayQueue02.headQueue();
                        System.out.println(head);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
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
class ArrayQueue02 {
    private int maxsize;   //队列最大值
    private int front;   //队列头    修改 : 指向第一个元素位置 默认值为0
    private int rear;   //对列尾    修改 : 指向最后一个位置的下一个位置 默认值为0(因为没有数据时,队列尾巴应该指向-1,下一个位置为0 )
    private int[] arr;   //用于存放数据

    public ArrayQueue02(int maxsize) {
        this.maxsize = maxsize;
        arr = new int[maxsize];
    }

    //添加数据
    public void addQueue(int number) {
        //先判断队列是否满
        if (isFull()) {
            System.out.println("队列满不能添加数据");
            return;
        }
        //往数组添加数据
        arr[rear] = number;
        rear = (rear + 1) % maxsize;   //添加数据后,队列尾后移一位    又因为复用性所以对其取余,加入+1为4(此时最大为3),4%3=1,回到第一
    }

    //取出数据
    public int getQueue() {
        //先判断队列是否空
        if (isEmpty()) {
            throw new RuntimeException("队列为空,不能取出数据");
        }
        int value = arr[front];
        front = (front + 1) % maxsize;  //队列头指向后一位   这里的取模同添加元素中取模的是一致的
        return value;
    }

    //显示队列
    public void showQueue() {
        //先判断队列是否为空
        if (isEmpty()) {
            System.out.println("队列为空,无法显示");
            return;
        }

        for (int i = front; i < front + size(); i++) {  //这里的起始就应该为对列头多代表的元素,结束条件应该为有效数据的个数
            System.out.printf("arr[%d] = %d\n", i % maxsize, arr[i % maxsize]);
        }
    }

    public int size() {
        return (rear + maxsize - front) % maxsize;
    }

    //显示头元素
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空,没有头数据");
        }
        return arr[front];
    }

    //判断队列是否为空
    private boolean isEmpty() {
        return front == rear;
    }

    //判断队列为满
    private boolean isFull() {
        return (rear + 1) % maxsize == front;
    }
}
