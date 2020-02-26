package cn.cz.stack;

import com.sun.source.tree.CaseTree;

import java.util.Scanner;

/**
 * @author Kartoffel
 * @create 2020-02-21-17:20
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
//        System.out.println("模拟计算器");
//        Scanner in = new Scanner(System.in);
//        System.out.print("请输入:");
//        String num = in.next();
        String num = "20/5*(2*4+1)-120+84";

        System.out.printf("表达式 %s = %d", num, res(num));
    }

    public static int res(String num) {
        //创建两个栈
        ArrayStack numberStack = new ArrayStack(10);   // 栈一:存放数据
        ArrayStack oStack = new ArrayStack(10);    // 栈二:存放符号
        char[] arr = num.toCharArray();   // 把字符串切割成数组

        int index = 0;
        int num1;
        int num2;
        int res = 0;        // 接受计算结果
        char oper = ' ';
        char val = ' '; // 用来接收遍历的字符
        int keyNum = 0;

        //遍历字符数组
        while (true) {
            val = arr[index];
            //判断是否是符号
            if (oStack.isOper(val)) {
                //在判断符号栈是否为空
                if (!oStack.isEmpty()) {
                    //判断符号优先级
                    if (oStack.priority(val) <= oStack.priority(oStack.topOfStack())) {
                        num1 = numberStack.pop();
                        num2 = numberStack.pop();
                        oper = (char) oStack.pop();
                        //进行计算
                        res = numberStack.cal(num1, num2, oper);
                        //把计算后的结果入数据栈
                        numberStack.push(res);
                        //然后将这个符号入栈,为下一次符号作比较
                        oStack.push(val);
                    } else {
                        //当前优先级大于上一个符号优先级,入栈
                        oStack.push(val);
                    }
                } else {
                    //符号入栈
                    oStack.push(val);
                }
            } else if (val == '(') {
                //往后遍历得到新的字符串直到遇到')'结束
                String newNumber = "";   // 用于字符串拼接
                while (arr[index + 1] != ')') {   // 不是右括号 循环
                    char loop = arr[index + 1];
                    newNumber = newNumber + loop;
                    index++;
                }
                int res01 = res(newNumber);
                index += 1;
                numberStack.push(res01);
            } else {
                //如果是数字,就继续判断下一个是否是数字
                keyNum = keyNum * 10 + (val - '0');
                if (index >= arr.length - 1) {
                    numberStack.push((keyNum));
                } else {
                    int index1 = index + 1;
                    if (oStack.isOper(arr[index1])) {
                        numberStack.push(keyNum);
                        keyNum = 0;
                    }
                }
            }
            index++;
            if (index >= arr.length) {
                break;
            }
        }
        //当扫描结束,就顺序两个栈中pop出相应的数据和符号,并运行
        while (!oStack.isEmpty()) {
            num1 = numberStack.pop();
            num2 = numberStack.pop();
            oper = (char) (oStack.pop());
            //进行计算
            res = numberStack.cal(num1, num2, oper);
            numberStack.push(res);
        }
        return res;
    }
}

class ArrayStack {
    private int top = -1;   // 栈顶
    private int size;   // 创建的栈大小
    private int[] stack;   // 栈数组

    //构造器(传入创建栈的大小)
    public ArrayStack(int size) {
        this.size = size;
        stack = new int[size];
    }

    //判断栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //判断栈满
    public boolean isFull() {
        return top == size - 1;
    }

    //入栈方法
    public void push(int num) {
        //先判断是否栈满
        if (isFull()) {
            System.out.println("栈满");
            return;
        }

        top++;   // 栈顶后移
        stack[top] = num;
    }

    //出栈方法
    public int pop() {
        //先判断时候空栈
        if (isEmpty()) {
            throw new RuntimeException("空栈");
        }

        int num = stack[top];
        top--; //   取出一个值栈顶下移
        return num;
    }

    //显示栈
    public void show() {
        //先判断时候空栈
        if (isEmpty()) {
            throw new RuntimeException("空栈");
        }

        //遍历栈
        for (int i = top; i <= 0; i--) {
            System.out.println(stack[i]);
        }
    }

    //返回运算优先级(数字越大,优先级越高)
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    //判断是否是一个符号
    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    //计算方法
    public int cal(int x, int y, char oper) {
        int res = 0;
        switch (oper) {
            case '+':
                res = x + y;
                break;
            case '-':
                res = y - x;   //注意顺序(减数和被减数)
                break;
            case '*':
                res = x * y;
                break;
            case '/':
                res = y / x;   //注意顺序(除数和被除数)
                break;
        }
        return res;
    }

    //放回栈顶数据
    public int topOfStack() {
        return stack[top];
    }
}