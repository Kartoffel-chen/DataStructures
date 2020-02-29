package cn.cz.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author Kartoffel
 * @create 2020-02-28-22:13
 */
public class shellSort {
    public static void main(String[] args) {
//        int[] arr = {6, 8, 4, 0, -5, 10};
//        shellSort2(arr);

        int[] arr = new int[8000000];
        for (int i = 0; i < 8000000; i++) {
            arr[i] = (int) (Math.random() * 8000000);           //1-8万的随机数据存入数组
        }

        SimpleDateFormat smf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   //格式化时间输出样式
        Date date = new Date();   //获取时间
        String dateStr = smf.format(date);
        System.out.println("排序前的时间是 : " + dateStr);

        shellSort2(arr);

        Date date1 = new Date();
        String dateStr1 = smf.format(date1);
        System.out.println("排序后的时间是 : " + dateStr1);
    }

    public static void shellSort1(int[] arr) {    //交换式希尔排序
        int temp = 0;
        // 每次循环对数组进行对半分组
        // 例如数组长度为10,第一次分为5组,第二次分为5/2=1组,第三次分为2/2=1
        for (int gap = arr.length; gap > 0; gap /= 2) {
            // 以上例子第一次循环i=3
            // j = 3 - 3 = 0
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    // 对arr[0]和arr[3]的值进行比较
                    if (arr[j] > arr[i]) {    // 前大于后的话就交换
                        temp = arr[j];    // 交换
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }
//        System.out.println(Arrays.toString(arr));
    }

    public static void shellSort2(int[] arr) {    //位移式希尔排序
        for (int gap = arr.length; gap > 0; gap /= 2) {    // 分组
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[i];
                while (j - i >= 0 && temp < arr[j - gap]) {
                    arr[j] = arr[j-gap];
                    j -= gap;
                }
                arr[j] = temp;
            }
        }
//        System.out.println(Arrays.toString(arr));
    }
}
