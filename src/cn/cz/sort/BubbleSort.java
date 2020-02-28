package cn.cz.sort;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author Kartoffel
 * @create 2020-02-28-11:53
 */
public class BubbleSort {
    public static void main(String[] args) {
//        int[] arr = {-2, 5, -1, 8, 6};
//        bubbleSort(arr);

        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int)(Math.random() * 80000);           //1-8万的随机数据存入数组
        }

        SimpleDateFormat smf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   //格式化时间输出样式
        Date date = new Date();   //获取时间
        String dateStr = smf.format(date);
        System.out.println("排序前的时间是 : " + dateStr);

        bubbleSort(arr);

        Date date1 = new Date();
        String dateStr1 = smf.format(date1);
        System.out.println("排序后的时间是 : " + dateStr1);
    }

    public static void bubbleSort(int[] arr) {
        //创建一个变量
        int temp = 0;
        boolean flag = false;   //用来记录是否发生交换

        for (int i = 0; i < arr.length - 1; i++) {   //
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {    // 从小到大排序
                    flag = true;              //发生交换,置为true
                    temp = arr[j];            //把当前数字据记录下来
                    arr[j] = arr[j + 1];      //交换
                    arr[j + 1] = temp;
                }
            }

            if (flag) {
                flag = false;      // 如果发生交换,把flag置为false,重新进行判断
            } else {
                break;             // 如果没有发生交换,跳出此次循环
            }
        }
    }
}
