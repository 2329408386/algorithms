package basic;

import java.util.Scanner;

/**
 * 兰博和提莫闲聊之后，回归到了他们的正题，约德尔人的未来。
 *
 * 说起约德尔人的未来，黑默丁格曾经提出了一个约德尔测试，将约德尔人的历史的每个阶段都用一个字符表达出来。(包括可写字符,不包括空格。)。然后将这个字符串转化为一个01串。转化规则是如果这个字符如果是字母或者数字，这个字符变为1,其它变为0。然后将这个01串和黑默丁格观测星空得到的01串做比较，得到一个相似率。相似率越高,则约德尔的未来越光明。
 *
 * 请问:相似率为多少？
 */
public class DomolTest {
    // 存放最长子字符串
    private static int[][] results;

    // 初始化最长子字串
    private static void initResults(int n,int m){
        results=new int[n+1][m+1];
        for (int i = 0; i <=n; i++) {
            for (int j = 0; j <= m; j++) {
                results[i][j]=-1;
            }
        }
    }

    // 将一个字符串转换成二进制字符串(规则: 数字或者字母,转换成1,其余为0)
    private static String changeToBin(String s){
        int len=s.length();
        StringBuilder toReturn=new StringBuilder();
        for (int i = 0; i < len; i++) {
            if(isDigitOrAlpha(s.charAt(i)))
                toReturn.append('1');
            else
                toReturn.append('0');
        }
        return toReturn.toString();
    }
    private static boolean isDigitOrAlpha(char c){
        if(c>='0'&&c<='9')
            return true;
        else if((c>='a'&&c<='z')||(c>='A'&&c<='Z'))
            return true;
        else
            return false;
    }

    // 求最长公共子序列
    public static int lcs(String s1,String s2){
        int l1=s1.length(),l2=s2.length();
        if(l1==0||l2==0) return 0;
        else if(results[l1][l2]!=-1) return results[l1][l2];
        else if(s1.charAt(l1-1)==s2.charAt(l2-1)){
            results[l1][l2]=lcs(s1.substring(0,l1-1),s2.substring(0,l2-1))+1;
            return results[l1][l2];
        }else{
            results[l1][l2]=Math.max(lcs(s1.substring(0,l1-1),s2),lcs(s1,s2.substring(0,l2-1)));
            return results[l1][l2];
        }
    }

    public static int similarLen(String s1,String s2){
        int count=0,len=Math.min(s1.length(),s2.length());
        for (int i = 0; i < len; i++) {
            if(s1.charAt(i)==s2.charAt(i))
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String s1=input.nextLine(),s2=input.nextLine();
        s1=changeToBin(s1);
//        initResults(s1.length(),s2.length());

//        int lcs=lcs(s1,s2);
        int count=similarLen(s1,s2);
        System.out.format("%.2f%%\n",count*100.0/s1.length());
    }
}