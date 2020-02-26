package cn.cz.sparsearray;

import java.io.*;
import java.nio.Buffer;

/**
 * 读盘操作
 *
 * @author Kartoffel
 * @create 2020-02-14-22:59
 */
public class ReaderAndRestore {
    public static void main(String[] args) {
        /*
         *  步骤
         *      1.先读取文件中第一行数据,并创建相应大小的棋盘
         *      2.读取下一行数据给棋盘赋值
         */


        //读取文件
        File f = new File("chessArr.txt");
        BufferedReader bufr = null;
        try {
            bufr = new BufferedReader(new FileReader(f));
            String line = null;

            line = bufr.readLine();   //读取第一行数据
            String[] arr = line.split("\t");   //以"\t"为分隔规则各分为数组
            int x = Integer.parseInt(arr[0]);  //第一行第一个为棋盘的行
            int y = Integer.parseInt(arr[1]);  //第一行第二个为棋盘的列
            int[][] sparseArr = new int[x][y];   //以此创建二维棋盘

            while (null != (line = bufr.readLine())) {   //读取行为空,停止循环
                String[] arr1 = line.split("\t");
                int a = Integer.parseInt(arr1[0]);
                int b = Integer.parseInt(arr1[1]);
                int value = Integer.parseInt(arr1[2]);
                sparseArr[a][b] = value;
            }

            for (int[] a : sparseArr) {
                for (int e : a) {
                    System.out.print(e + "    ");
                }
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
