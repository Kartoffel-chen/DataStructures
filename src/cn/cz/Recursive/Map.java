package cn.cz.Recursive;

/**
 * 创建一个迷宫地图
 * @author Kartoffel
 * @create 2020-02-25-22:10
 */
public class Map {
    private int x;
    private int y;
    private int[][] map;

    public Map(int x, int y) {
        this.x = x;
        this.y = y;
        map = new int[x][y];
        map[2][1]=1;
        map[2][2]=1;
        map[3][3]=1;
        map[4][4]=1;
        map[5][4]=1;
        map[5][5]=1;

        //上下墙
        for (int i = 0; i < x; i++) {
            map[0][i] = 1;
            map[x-1][i] = 1;
        }

        //左右墙
        for (int i = 0; i < y; i++) {
            map[i][0] = 1;
            map[i][y-1] = 1;
        }
    }

    public int[][] getMap(){
        return map;
    }

    //显示地图方法
    public void showMap(){
        for(int[] x : map){
            for(int y : x){
                System.out.print(y+"  ");
            }
            System.out.println();
        }
    }
}
