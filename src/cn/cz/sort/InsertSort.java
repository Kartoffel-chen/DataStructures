package cn.cz.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 插入排序
 *
 * @author Kartoffel
 * @create 2020-02-28-17:40
 */
public class InsertSort {
    public static void main(String[] args) {
//        int[] arr = {6, 8, 4, 0, -5, 10};
//        insertSort(arr);

        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int)(Math.random() * 80000);           //1-8万的随机数据存入数组
        }

        SimpleDateFormat smf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   //格式化时间输出样式
        Date date = new Date();   //获取时间
        String dateStr = smf.format(date);
        System.out.println("排序前的时间是 : " + dateStr);

        insertSort(arr);

        Date date1 = new Date();
        String dateStr1 = smf.format(date1);
        System.out.println("排序后的时间是 : " + dateStr1);
    }

    public static void insertSort(int[] arr) {
        int insertVal = 0;
        int insertIndex = 0;

        for (int i = 1; i < arr.length; i++) {

            insertVal = arr[i];    // 接受需要插入的数据
            insertIndex = i - 1;   // 表示要插入数据的前一个数据下标

            //说明
            //  insertIndex - 1 > 0 保证下标不越界
            //  insertVal < arr[insertIndex] 当前要插入的值小于上一个值
            //  那就把上一个值后移一为
            while (insertIndex >= 0 && insertVal < arr[insertIndex]){
                arr[insertIndex + 1] = arr[insertIndex];   //后移操作
                insertIndex --;
            }

            //循环结束时候找到插入位置

            arr[insertIndex + 1] = insertVal;

        }
//        System.out.println(Arrays.toString(arr));
    }
}
