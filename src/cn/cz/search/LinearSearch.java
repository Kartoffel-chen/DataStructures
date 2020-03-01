package cn.cz.search;

/**
 * 线性查找
 * @author Kartoffel
 * @create 2020-03-01-16:55
 */
public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {10,50,4,7,24,48,61};
        int findValue = linearSearch(arr,48);
        if(findValue == -1){
            System.out.println("没有找到需要找的数据下标");
        }else {
            System.out.println("找到的值的下标为" + findValue);
        }
    }
    public static int linearSearch(int[] arr,int findValue){
        int valIndex = -1;   //用于记录要找的值下标,-1默认没找到
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == findValue){   //遍历到的当前值等于需要找的值,那就放回当前下标;
                valIndex = i;
                return valIndex;
            }
        }
        return valIndex;
    }
}
