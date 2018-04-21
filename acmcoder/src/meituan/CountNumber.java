package meituan;

import java.util.Scanner;

/**
 * 沫璃在探寻数学的奥秘，她现在想知道n以内的正整数一共有多少位数字。不统计前导零。
 *
 * 例如：n为13时，12345678910111213，共17位，则输出为17。
 * 作者: 李程鹏
 */
public class CountNumber {
    private static long[] sum=new long[20];

    private static void init(){
        long base=1,base2=1;
        sum[0]=0;
        for (int i = 1; i < 18; i++) {
            sum[i]=sum[i-1]+base*9;
            base2*=10;
            base=base*10+base2;
        }
    }

    public static long getLength(long n){
        long origin=n,baseOrigin=1;
        int count=0;
        while(n!=0){
            n=n/10;
            baseOrigin*=10;
            count++;
        }
        baseOrigin/=10;
        return sum[count-1]+(count)*(origin-baseOrigin+1);
    }

    public static void main(String[] args) {
        init();
        Scanner input=new Scanner(System.in);
        int T=Integer.parseInt(input.nextLine());
        for (int i = 0; i < T; i++) {
            long n=Long.parseLong(input.nextLine());
            System.out.println(getLength(n));
        }
    }
}
