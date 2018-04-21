package basic;

import java.util.Arrays;
import java.util.Scanner;

/**
 * V先生有一天工作到很晚，回家的时候要穿过一条长l的笔直的街道，这条街道上有n个路灯。
 * 假设这条街起点为0，终点为l，第i个路灯坐标为ai。路灯发光能力以正数d来衡量，其中d表示路灯能够照亮的街道上的点与路灯的最远距离，
 * 所有路灯发光能力相同。为了让V先生看清回家的路，路灯必须照亮整条街道，又为了节省电力希望找到最小的d是多少？
 */
public class Light {
    /**
     * 找到相邻路灯之间的最大距离(如果是第一个或者最后一个路灯,则是它们的距离的2倍)
     * @param lights: 按照位置排好序的路灯
     * @param l: 路的最大长度
     * @return
     */
    public static int maxDistance(int[] lights,int l){
        int len=lights.length;
        int d=Math.max(lights[0],l-lights[len-1])*2;
        for(int i=1;i<len-1;i++)
            if(lights[i]-lights[i-1]>d)
                d=lights[i]-lights[i-1];
        return d;
    }

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String[] line1=input.nextLine().split(" ");
        String[] line2=input.nextLine().split(" ");
        int[] lights=new int[line2.length];
        for (int i = 0; i < lights.length; i++) {
            lights[i]=Integer.parseInt(line2[i]);
        }

        Arrays.sort(lights);
        int d=maxDistance(lights,Integer.parseInt(line1[1]));
        System.out.format("%.2f",d/2.0);
    }
}
