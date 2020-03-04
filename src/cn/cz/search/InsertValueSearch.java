package cn.cz.search;

import java.util.ArrayList;

/**
 * 插值查找
 *
 * @author Kartoffel
 * @create 2020-03-03-11:02
 */
public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr = new int[100];

        for (int i = 0; i < 100; i++) {
            arr[i] = i + 1;
        }
        ArrayList<Integer> res = insertValueSearch(arr, 0, arr.length - 1, 69);
        System.out.println(res);
    }

    /**
     * @param arr   原数组
     * @param left  左索引
     * @param right 右索引
     * @param key   需要找的值
     * @return
     */
    public static ArrayList<Integer> insertValueSearch(int[] arr, int left, int right, int key) {

        //递归结束,还没有找到需要的值
        if (left > right) {
            return new ArrayList<>();
        }

        //插值查找公式
        int mid = left + (key - arr[left]) / (arr[right] - arr[left]) * (right - left);
        int midValue = arr[mid];

        //二分递归
        if (key < midValue) {   //在左边
            return insertValueSearch(arr, left, mid - 1, key);
        } else if (key > midValue) {   // 在右边
            return insertValueSearch(arr, mid + 1, right, key);
        } else {   //就是当前值
            //创建一个链表,存放所有找到的下标
            ArrayList<Integer> findIndex = new ArrayList<>();

            //判断该当前左边数据是否还存在相同值
            int temp = mid - 1;
            while (true) {
                if (temp < 0 || arr[temp] != key) {
                    break;
                }
                findIndex.add(temp);
                temp--;
            }

            //左边存完后,存放当前值,然后在循序存放右边值
            findIndex.add(mid);

            //判断该当前左边数据是否还存在相同值
            temp = mid + 1;
            while (true) {
                if (temp > arr.length - 1 || arr[temp] != key) {
                    break;
                }
                findIndex.add(temp);
                temp++;
            }

            return findIndex;
        }
    }
}
