package cn.cz.search;

import java.util.ArrayList;
import java.util.List;

/**
 * 二分法查找
 *
 * @author Kartoffel
 * @create 2020-03-01-17:30
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,20,30,30,40,50,60,60,60,100,120,160};
        int right = arr.length - 1;

        List<Integer> findValue = binarySearch(arr, 0, right, 60);
        System.out.println(findValue);
    }

    public static int binarySearch1(int[] arr, int left, int right, int findValue){
        if (left > right) {
            return -1;
        }

        //获得数组中间值,以及中间值下标
        int mid = (right + left) / 2;
        int midValue = arr[mid];

        //前提,我们传入的数组是一个有序数组(从小到大)
        //判断查找数据与中间值大小
        if (findValue < midValue) {  //小于中间值,说明这个需要查找的这个值在中间值的左边
            return binarySearch1(arr, left, mid - 1, findValue);
        } else if (findValue > midValue) {    //大于中间值,说明这个需要查找的值在中间值的右边
            return binarySearch1(arr, mid + 1, right, findValue);
        } else {   //不大不小,那就相等
            return mid;
        }
    }

    /**
     * 二分法查找,返回一个集合(因为一个数组中可能出现重复的数据)
     *
     * @param arr       接受需要查找的数组
     * @param left      左索引,指向数组头
     * @param right     右索引,指向数组尾
     * @param findValue 需要查找的数据
     * @return
     */
    public static ArrayList<Integer> binarySearch(int[] arr, int left, int right, int findValue) {
        if (left > right) {
            return new ArrayList<>();
        }

        //获得数组中间值,以及中间值下标
        int mid = (right + left) / 2;
        int midValue = arr[mid];

        //前提,我们传入的数组是一个有序数组(从小到大)
        //判断查找数据与中间值大小
        if (findValue < midValue) {  //小于中间值,说明这个需要查找的这个值在中间值的左边
            return binarySearch(arr, left, mid - 1, findValue);
        } else if (findValue > midValue) {    //大于中间值,说明这个需要查找的值在中间值的右边
            return binarySearch(arr, mid + 1, right, findValue);
        } else {   //不大不小,那就相等
            //但是这里数据中可能存在多个需要查找的值,所以这里不能直接返回
            ArrayList<Integer> findIndex = new ArrayList<>();

            //mid指向满足条件的值
            //指针前移,遍历数组看看是否还存在满足的值
            //满足的话先添加到集合中
            int tempIndex = mid - 1;
            while (true) {
                if (tempIndex < 0 || arr[tempIndex] != findValue) {
                    break;
                }
                findIndex.add(tempIndex);
                tempIndex -= 1;
            }

            //当左边的值存放完成后,才能存放当前找到的mid
            findIndex.add(mid);

            //接着就继续遍历数组右边
            //存放满足条件的下标
            tempIndex = mid + 1;
            while (true) {
                if (tempIndex > arr.length - 1 || arr[tempIndex] != findValue) {
                    break;
                }
                findIndex.add(tempIndex);
                tempIndex += 1;
            }

            //最后返回数组
            return findIndex;
        }
    }
}
