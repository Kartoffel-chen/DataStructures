package cn.cz.Recursive;

/**
 * @author Kartoffel
 * @create 2020-02-26-10:40
 */
public class EightQueen {
    //表示八个皇后
    int max = 8;
    //用来存放皇后摆放位置,下标表示第n个皇后
    int[] array = new int[max];

    public static void main(String[] args) {
        //测试
        EightQueen eightQueen = new EightQueen();
        eightQueen.check(0);
    }

    //创建一个放入皇后的方法
    private void check(int n){
        if(n == max){    //说明皇后全部放好
            print();
            return;
        }

        //否者一次放入皇后,并且判断是否能放入
        for (int i = 0; i < max; i++) {
            //先把该皇后放在该行的第一列
            array[n] = i;
            //判断当放置第n个皇后于之前的皇后是否冲突
            if(judge(n)){   //你冲突
                check(n+1);
            }
            //如果冲突就继续循环,把皇后后移一个位置
        }
    }

    //判断皇后是否能摆放在此位置的方法
    // 1.判断放入皇后和之前放入的皇后是否有冲突
    private boolean judge(int n){
        //对之前的皇后进行遍历
        for (int i = 0; i < n; i++) {
            //array[i] == array[n],判断是否在同一列
            //Math.abs(n-i) == Math.abs(array[n] - array[i]) , 判断是否在同一斜线

            //分析 : 假如现在加入的是第二个皇后 且位置是第三个 arr[1] = 2; n = 1;
            //       此时第一个皇后在第二个位置 array[0] = 1 ; i = 0;
            //       n - i = 1; arr[n] - arr[i] = 1; 所以不能放在这
            if(array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n] - array[i])){
                return false;
            }
        }
        return true;
    }

    //一个输出皇后摆放位置的方法
    private void print(){
        for(int arr : array){
            System.out.printf("%d  ",arr);
        }
        System.out.println();
    }

}
