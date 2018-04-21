package basic;

import java.util.ArrayList;
import java.util.Scanner;

public class NewCalculator {
    private static String[][] table={
            {" - ","   "," - "," - ","   "," - "," - "," - "," - "," - "},
            {"| |"," | ","  |","  |","| |","|  ","|  ","  |","| |","| |"},
            {"   ","   "," - "," - "," - "," - "," - ","   "," - "," - "},
            {"| |"," | ","|  ","  |","  |","  |","| |","  |","| |","  |"},
            {" - ","   "," - "," - ","   "," - "," - ","   "," - ","   "}
    };

    // 讲一个整数因式分解,把因子排好序后用'*'相连成一个字符串
    public static String split(int n){
        if(n<=2) return Integer.toString(n);

        int end=(int)Math.sqrt(n)+1;

        ArrayList<Integer> factors=new ArrayList<>();
        int i=2;
        while(n>2&i<=end){
            if(n%i==0){
                factors.add(i);
                n=n/i;
                i=1;
                end=(int)Math.sqrt(n)+1;
            }
            i++;
        }
        if(n>=2) factors.add(n);

        // factors已经自然有序了,而且至少有一个元素.

        StringBuilder toReturn=new StringBuilder();

        for (int j = 0; j < factors.size()-1; j++) {
            toReturn.append(factors.get(j)+"*");
        }
        toReturn.append(factors.get(factors.size()-1));

        return toReturn.toString();
    }

    // 按照给的因式相乘的方式,书写成另一种形式
    public static void print(String polynomial){
        int len=polynomial.length();
        for (int i = 0; i <5 ; i++) {
            for (int j = 0; j < len; j++) {
                   if(i==2){
                       System.out.print(polynomial.charAt(j)=='*'?'*':table[i][polynomial.charAt(j)-'0']);
                   }else{
                       System.out.print(polynomial.charAt(j)=='*'?' ':table[i][polynomial.charAt(j)-'0']);
                   }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
//        int[] tests={1,2,3,10,13498,100,256,1024};
//        for (int i = 0; i < tests.length; i++) {
//            String polynomial=split(tests[i]);
//            System.out.println(polynomial);
//            print(polynomial);
//        }

        Scanner input=new Scanner(System.in);
        while (input.hasNextInt()){
            print(split(input.nextInt()));
        }
    }
}
