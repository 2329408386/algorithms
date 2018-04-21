package meituan;

import java.util.Scanner;

public class GCD {

    private static int gcd(int a,int b){
        return a%b==0?b:gcd(b,a%b);
    }

    private static int[] getA(int N,int p){
        int[] A=new int[N];
        A[0]=p;
        for (int i = 1; i < N; i++) {
            A[i]=(A[i-1]+153)%p;
        }
        return A;
    }

    public static int calculateSum(int[] A,int m,int n){
        int toReturn=0;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++)
                toReturn+=A[gcd(i,j)-1];
        }
        return toReturn;
    }

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String[] elements=input.nextLine().split(" ");
        int N=Integer.parseInt(elements[0]);
        int n=Integer.parseInt(elements[1]);
        int m=Integer.parseInt(elements[2]);
        int p=Integer.parseInt(elements[3]);
        int[] A=getA(N,p);
        System.out.println(calculateSum(A,m,n));
    }
}
