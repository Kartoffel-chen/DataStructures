package cn.cz.Recursive;

import java.io.*;

/**
 * @author Kartoffel
 * @create 2020-02-25-22:18
 */
public class Test {
    public static void main(String[] args) {
        test1();
    }

    public  static void test2(){
        int[][] map = ReadMap();

        setWay(map,1,1);

        for(int[] a : map){
            for(int b : a){
                System.out.print(b);
            }
            System.out.println();
        }
    }

    public static void test1(){
        Map map = new Map(8, 8);
        map.showMap();
        System.out.println("--------------------------------------------");
        int[][] map1 = map.getMap();
        setWay(map1, 1, 1);

        for (int[] a : map1) {
            for (int b : a) {
                System.out.print(b + "  ");
            }
            System.out.println();
        }
    }

    //从文件中读取棋盘
    public static int[][] ReadMap(){
        //确定流
        BufferedReader bufferedReader = null;
        int[][] map = null;
        try {
            //源
            bufferedReader = new BufferedReader(new FileReader("迷宫.txt"));
            String line = bufferedReader.readLine();
            String[] lineArr = line.split(" ");
            map = new int[Integer.parseInt(lineArr[0])][Integer.parseInt(lineArr[1])];
            int x = 0;
            int y = 0;
            while(null!=(line = bufferedReader.readLine())){
                char[] arr =line.toCharArray();
                for(char a : arr){
                    map[x][y] = a - '0';
                    y ++;
                }
                y = 0;
                x ++;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("读取文件失败");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert bufferedReader != null;
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return map;
    }
    //使用递归来完成找到迷宫出口
    //说明
    // 1.map表示迷宫
    // 2.xy表示小球起点坐标
    // 3.如果小球能达到arr[6][5],表示找到通路
    // 4.约定 : 当map[x][y]为0时,说明该点没有走过,为1表示是墙不能通过,为2表示通路可以走,为3表示已经走过但是走不通
    // 5.小球移动规则,上->右->下->左

    /**
     * @param map 迷宫地图
     * @param x   起点的x坐标
     * @param y   起点的y坐标
     * @return 返回是否找到通路
     */
    public static boolean setWay(int[][] map, int x, int y) {
        //首先判断是否找到通路
        if (map[6][4] == 2) {    //找到
            return true;
        } else {                 //没找到
            if (map[x][y] == 0) {
                //如果此时小球所在位置是0,说明可以走,置为2
                map[x][y] = 2;
                //小球上移动
                if (setWay(map, x + 1, y)) {         //小球上移动
                    return true;
                } else if (setWay(map, x, y + 1)) {  //小球右移动
                    return true;
                } else if (setWay(map, x - 1, y)) {  //小球下移动
                    return true;
                } else if (setWay(map, x, y - 1)) {  //小球左移动
                    return true;
                }else{
                    //上下左右都走不通说明是死路
                    map[x][y] = 3;
                    return false;
                }
            } else {    // 说明此时小球可能遇到墙或者,已经走过这条路
                return false;
            }
        }
    }
}
