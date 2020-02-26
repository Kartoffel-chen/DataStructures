package cn.cz.sparsearray;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 模拟存棋盘
 * 使用:稀疏数组
 *
 * @author Kartoffel
 * @create 2020-02-14-21:27
 */
public class SparseArray {
    public static void main(String[] args) {
        //创建棋盘的二维数组
        //1表示白棋     2表示黑棋
        int[][] sparseArr = new int[12][15];
        sparseArr[1][2] = 1;
        sparseArr[5][6] = 1;
        sparseArr[6][7] = 2;
        sparseArr[0][9] = 1;
        sparseArr[7][2] = 2;

        //控制台打印数组
        //并且返回有效值个数
        int size = showArr(sparseArr);
//        System.out.println(size);

        //创建稀疏数组,大小为有效个数+1
        int[][] chess = new int[size + 1][3];

        /*
        存入数据规则
        第一行 几行 几列  有效数据个数
        第二行  几行 几列  有效数字1
        第二行  几行 几列  有效数字2
         */

        chess[0][0] = sparseArr.length;
        chess[0][1] = sparseArr[0].length;
        chess[0][2] = size;

        //对有效数字进行存储
        int count = 1;
        for (int i = 0; i < sparseArr.length; i++) {
            for (int j = 0; j < sparseArr[i].length; j++) {
                if (sparseArr[i][j] != 0) {
                    chess[count][0] = i;
                    chess[count][1] = j;
                    chess[count][2] = sparseArr[i][j];
                    count++;
                }
            }
        }

        //控制台显示稀疏数组
        showArr(chess);

        //将稀疏数组存入.txt文件
        input(chess);

    }

    //遍历数组
    public static int showArr(int[][] arr) {
        int count = 0;
        for (int[] a : arr) {
            for (int e : a) {
                if (e != 0) {
                    count++;
                }
                System.out.print(e + "    ");
            }
            System.out.println();
        }
        return count;
    }

    //存入文件
    public static void input(int[][] arr) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("chessArr.txt");
            for (int[] a : arr) {
                for (int e : a) {
                    fileWriter.write(e + "\t");
                }
                fileWriter.write("\r");
            }
        } catch (IOException e) {
            throw new RuntimeException("运行时异常");
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
