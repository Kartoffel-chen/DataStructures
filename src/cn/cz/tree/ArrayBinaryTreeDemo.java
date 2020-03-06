package cn.cz.tree;

/**
 * @author Kartoffel
 * @create 2020-03-06-18:13
 */
public class ArrayBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(arr);
        arrayBinaryTree.preOrder();
    }

}

class ArrayBinaryTree {

    private int[] arr;

    public ArrayBinaryTree(int[] arr) {
        this.arr = arr;
    }

    //重构前序遍历
    public void preOrder(){
        this.preOrder(0);
    }

    //前序遍历数组
    // index表示传入数组下标
    public void preOrder(int index) {

        //首先判断是否为空
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空");
            return;
        }

        //输出当前元素
        System.out.println(arr[index]);

        if ((index * 2 + 1) < arr.length) {
            preOrder(index * 2 + 1);
        }

        if ((index * 2 + 2) < arr.length) {
            preOrder(index * 2 + 2);
        }
    }
}