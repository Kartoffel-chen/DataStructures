package cn.cz.stack;

import cn.cz.circlelinkedlist.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author Kartoffel
 * @create 2020-02-22-11:46
 */
public class PolandNotation {
    public static void main(String[] args) {
        String suffixExperssion = "3 4 + 10 * 6 -";
        List ls = getListString(suffixExperssion);
        System.out.println("逆波兰表达式为: " + ls);


        String expession = "1+((2+3)*4)-5";
        List<String> infixExperessionList = toInfixExpressionList(expession);
        System.out.println(infixExperessionList);
        List<String> test = parseSuffixExpressionList(infixExperessionList);
        System.out.println(test);
        int res = calculate(test);
        System.out.println("运算结果是: " + res);

    }

    //将逆波兰表达式切割并且添加到list集合中(方便进行读取并且操作)
    public static List<String> getListString(String suffixExperssion) {
        //首先把字符串切割为数组(按照空格切割)
        List<String> ls = new ArrayList<>();
        String[] arrString = suffixExperssion.split(" ");
        Collections.addAll(ls, arrString);
        return ls;
    }

    /*
    思路 ：
        1.如果是数据就直接存放
        2.遇到符号就pop上两个数据，进行运算
        3.运算的结果push入栈
    */
    public static int calculate(List<String> list) {
        //先创建一个栈
        Stack<String> stack = new Stack<>();

        //对list进行遍历
        for (String ls : list) {
            //这里使用正则表达式
            if (ls.matches("\\d+")) {   // 匹配的是多位数，入栈
                stack.push(ls);
            } else {   // 不是数字的话说明是符号，按照步骤来
                //判断符号
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res;   // 用来存放运算结果

                switch (ls) {
                    case "+":
                        res = num1 + num2;
                        break;
                    case "-":
                        res = num1 - num2;
                        break;
                    case "*":
                        res = num1 * num2;
                        break;
                    case "/":
                        res = num1 / num2;
                        break;
                    default:
                        throw new RuntimeException("输入的运算符号有误，请检查后再次输入");
                }
                stack.push(res + "");
            }
        }
        return Integer.parseInt(stack.pop());
    }

    /*
    中缀表达式转换为后缀表达式
        1.初始化两个栈: 运算符栈s1和存储中间结果的栈s2
        2.从左到右扫描中缀表达式
        3.遇到操作数是,入栈s2
        4.遇到运算符是,比较其于s1栈顶运算符的优先级:
     */

    //先将中缀表达式转为对应的list
    public static List<String> toInfixExpressionList(String s) {
        //先创建一个list
        List<String> ls = new ArrayList<String>();

        int index = 0;   // 用来对字符串进行遍历
        char c;          // 用来接受遍历到的字符
        String str;      // 拼接

        do {
            c = s.charAt(index);
            //对接受进来的字符进行判断
            if ((c = s.charAt(index)) < 48 || (c = s.charAt(index)) > 57) {   // 不是数字
                ls.add("" + c);
                index++;
            } else {
                str = "";   //先将str置空
                while (index < s.length() && (c = s.charAt(index)) > 48 && (c = s.charAt(index)) < 57) {
                    str += c;
                    index++;
                }
                ls.add(str);
            }
        } while (index < s.length());
        return ls;
    }

    //将中缀表达式的list,转换为后缀表达式list
    public static List<String> parseSuffixExpressionList(List<String> ls){
        Stack<String> s1 = new Stack<>();   // 符号栈
        List<String> s2 = new ArrayList<>();  //储蓄中间结果list

        //遍历ls
        for(String item:ls){
            //如果是一个数,加入s2
            if(item.matches("\\d+")){
                s2.add(item);
            }else if(item.equals("(")){   // 如果遇到左括号,继续压栈
                s1.push(item);
            }else if(item.equals(")")){   // 如果遇到右括号,就把左括号之前的所有内容添加到s2
                while(!s1.peek().equals("(")){
                    s2.add(s1.pop());
                }
                s1.pop();   // !!!!重点(这一步将入栈的左括号弹出)
            }else{   // 如果是符号,就判断符号的优先级,根据优先据进行加入s2
                while(s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)){
                    s2.add(s1.pop());
                }
                //还需要将item压入栈
                s1.push(item);
            }
        }
        while (s1.size()!= 0){
            s2.add(s1.pop());
        }

        return s2;
    }
}


class Operation{
    private static final int ADD = 1;
    private static final int SUB = 1;
    private static final int MUL = 2;
    private static final int DIV = 2;

    //放回优先级方法
    public static int getValue(String operation){
        int result = 0;
        switch (operation){
            case "+" :
                result = ADD;
                break;
            case "-" :
                result = SUB;
                break;
            case "*" :
                result = MUL;
                break;
            case "/" :
                result = DIV;
                break;
            default:
                System.out.println("运算符错误");
                break;
        }
        return result;
    }
}