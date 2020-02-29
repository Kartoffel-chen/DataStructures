package cn.cz.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author Kartoffel
 * @create 2020-02-29-22:37
 */
public class RadixSort {
    public static void main(String[] args) {
//        int[] arr = {80, 456, 57, 71, 13, 3, 46, 2};
//        radixSort(arr);
//        System.out.println(Arrays.toString(arr));

        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int)(Math.random() * 80000);           //1-8万的随机数据存入数组
        }

        SimpleDateFormat smf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   //格式化时间输出样式
        Date date = new Date();   //获取时间
        String dateStr = smf.format(date);
        System.out.println("排序前的时间是 : " + dateStr);

        int[] temp = new int[arr.length];
        radixSort(arr);

        Date date1 = new Date();
        String dateStr1 = smf.format(date1);
        System.out.println("排序后的时间是 : " + dateStr1);
    }

    /**
     * 基数排序法
     *
     * @param arr 接受原有数组
     */
    public static void radixSort(int[] arr) {
        int max = arr[0];
        for (int value : arr) {
            if (max < value) {
                max = value;
            }
        }

        int numOfTime = (max + "").length();
        //创建一个二位数组,用于放入每次排序的数据
        int[][] bucket = new int[10][arr.length];
        ///创建一个一位数组,来存放bucket中存放数据的个数
        int[] bucketIndex = new int[10];
        for (int size = 0, n = 1; size < numOfTime; size++, n *= 10) {
            //遍历数组摆放数据
            for (int i = 0; i < arr.length; i++) {
                int digitOfElement = arr[i] / n % 10;     // n对所需要判断的个位,10位等进行控制  当第一次循环时候,取个位值,n*10为就为个位数
                bucket[digitOfElement][bucketIndex[digitOfElement]] = arr[i];    //当取到个位数值时候,把当前数据存放到对应的桶中
                // 例如当我们去到个位值时1,就把当前数组的值存放到bucket[1][bucketIndex[digitOfElement]] = arr[i]
                // 这里bucketIndex[digitOfElement] 所存放的其实就是桶中数据的个数,下标代表几号桶
                // 例如1号桶存放了5个数据,那么1号下标对应的数组数值就是5
                bucketIndex[digitOfElement]++;
            }
            //按照桶的顺序放回到原来的数组中
            int index = 0;
            for (int i = 0; i < bucket.length; i++) {
                if (bucketIndex[i] != 0) {
                    //如果这个桶里有值,则循环遍历放入原数组
                    for (int j = 0; j < bucketIndex[i]; j++) {
                        //取元素放入
                        arr[index++] = bucket[i][j];
                    }
                }
                bucketIndex[i] = 0;
            }
        }

    }
}
