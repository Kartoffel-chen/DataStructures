package cn.cz.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author Kartoffel
 * @create 2020-02-28-16:28
 */
public class SelectSort {
    public static void main(String[] args) {
//        int[] arr = {6, 8, 4, 0, -5, 10};
//        selectSort(arr);

        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int)(Math.random() * 80000);           //1-8万的随机数据存入数组
        }

        SimpleDateFormat smf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   //格式化时间输出样式
        Date date = new Date();   //获取时间
        String dateStr = smf.format(date);
        System.out.println("排序前的时间是 : " + dateStr);

        selectSort(arr);

        Date date1 = new Date();
        String dateStr1 = smf.format(date1);
        System.out.println("排序后的时间是 : " + dateStr1);
    }

    public static void selectSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {

            int minIndex = i;                 //假定最小值下标
            int min = arr[minIndex];          //假定第i个值为最小值

            for (int j = i + 1; j < arr.length - 1; j++) {
                if (arr[minIndex] > arr[j]) {   //与下一个数据相比,如果小于
                    min = arr[j];               //交换
                    minIndex = j;
                }
            }
            //当里层循环结束时,就找到了数组中的最小值以及最小值下标

            arr[minIndex] = arr[i];    //交换
            arr[i] = min;
        }
//        System.out.println(Arrays.toString(arr));
    }
}
