package cn.cz.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 合并排序
 *
 * @author Kartoffel
 * @create 2020-02-29-14:48
 */
public class MergeSort {
    public static void main(String[] args) {
//        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
//        int[] temp = new int[arr.length];
//        mergeSort(arr, 0, arr.length - 1, temp);

        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int)(Math.random() * 80000);           //1-8万的随机数据存入数组
        }

        SimpleDateFormat smf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   //格式化时间输出样式
        Date date = new Date();   //获取时间
        String dateStr = smf.format(date);
        System.out.println("排序前的时间是 : " + dateStr);

        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);

        Date date1 = new Date();
        String dateStr1 = smf.format(date1);
        System.out.println("排序后的时间是 : " + dateStr1);

//        System.out.println(Arrays.toString(arr));
    }

    //(分离 + 合并)方法
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid + 1, right, temp);
            merge(arr, left, right, mid, temp);
        }
    }

    //合并方法
    /**
     * @param arr   接受原数组
     * @param left  最左边指针
     * @param right 最右边指针
     * @param mid   中间指针
     * @param temp  辅助数组
     */
    public static void merge(int[] arr, int left, int right, int mid, int[] temp) {

        int i = left;     //辅助变量,用于遍历最左边数据,从第一个数据开始
        int j = mid + 1;  //辅助变量,用于遍历最右边数据,从右边第一个开始,也就是中间值的后一个值
        int t = 0;        //用于指向辅助数组的当前索引

        //1.对两个有序数组进行添加
        //直到两边的数组有一边数组添加结束为止
        while (i <= mid && j <= right) {
            //比较两边遍历的到的数据
            //添加小的元素到辅助数组,并且后移指针对下一个数据进行判断
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                i++;
                t++;
            } else {
                temp[t] = arr[j];
                j++;
                t++;
            }
        }


        //2.当两边数组又一边添加结束
        //把剩下的数据添加到数组中
        while (i <= mid) {    // 说明右边的数据添加完毕
            temp[t] = arr[i];
            i++;
            t++;
        }

        while (j <= right) {    // 说明左边的数据添加完毕
            temp[t] = arr[j];
            i++;
            j++;
        }

        //3.将temp的元素拷贝到arr
        //注意:并不是每次都要拷贝
        t = 0;
        int tempIndex = left;
        while (tempIndex <= right) {
            arr[tempIndex] = temp[t];
            t++;
            tempIndex++;
        }

    }
}
