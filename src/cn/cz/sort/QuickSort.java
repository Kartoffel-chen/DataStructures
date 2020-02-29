package cn.cz.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author Kartoffel
 * @create 2020-02-29-10:49
 */
public class QuickSort {
    public static void main(String[] args) {
//        int[] arr = {-9, 78, 0, 23, -567, 70};
//        quickSort(arr, 0, arr.length - 1);

        int[] arr = new int[8000000];
        for (int i = 0; i < 8000000; i++) {
            arr[i] = (int)(Math.random() * 8000000);           //1-8万的随机数据存入数组
        }

        SimpleDateFormat smf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   //格式化时间输出样式
        Date date = new Date();   //获取时间
        String dateStr = smf.format(date);
        System.out.println("排序前的时间是 : " + dateStr);

        quickSort(arr, 0, arr.length - 1);

        Date date1 = new Date();
        String dateStr1 = smf.format(date1);
        System.out.println("排序后的时间是 : " + dateStr1);
    }

    /**
     * 快速排序
     *
     * @param arr   接收数组
     * @param left  数组左边下标
     * @param right 数组右边下标
     */
    public static void quickSort(int[] arr, int left, int right) {
        //接收基本信息
        int l = left;
        int r = right;
        //找到需要进行快速排序的基数
        int piovt = arr[(left + right) / 2];
        int temp = 0;

        //交换方法
        // 1. 对左右索引指定的值与基数进行排序(从小到大排序)
        // 2. 对左边的数进行遍历,找到一个大于基数的值,右边找到小于基数的值
        // 3. 交换两个值的大小
        while (l < r) {
            //首先找到左边大于基数的值
            while (piovt > arr[l]) {     //如果基数大于这个值,不满足我们的需求,后移l索引
                l += 1;
            }
            //其次找到右边小于基数的值
            while (piovt < arr[r]) {        //如果基数大于这个值,不满足我们的需求,索引前移
                r -= 1;
            }
            //如果 l >= r 说明基数pivot左右两边的值都已经是大于或小于基数了
            if (l >= r) {
                break;
            }

            //找到两个值,交换位置
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //交换以后,如果发现 piovt = arr[l],
            if(piovt == arr[l]){
                r -= 1;
            }
            if(piovt == arr[r]){
                l += 1;
            }
        }
        //当循环结束时候了l r 指向基数下标
        // l ++,作为右半边数组的left索引,r -- 作为左边半边的right
        if (l == r) {
            l += 1;
            r -= 1;
        }

        if (left < r) {
            quickSort(arr, left, r);
        }
        if (right > l) {
            quickSort(arr, l, right);
        }
    }
}
