package basic;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 给定一个长度为n的整数数组a，元素均不相同，问数组是否存在这样一个片段，只将该片段翻转就可以使整个数组升序排列。其中数组片段[l,r]表示序列a[l], a[l+1], ..., a[r]。原始数组为
 *
 * a[1], a[2], ..., a[l-2], a[l-1], a[l], a[l+1], ..., a[r-1], a[r], a[r+1], a[r+2], ..., a[n-1], a[n]，
 *
 * 将片段[l,r]反序后的数组是
 *
 * a[1], a[2], ..., a[l-2], a[l-1], a[r], a[r-1], ..., a[l+1], a[l], a[r+1], a[r+2], ..., a[n-1], a[n]。
 */
public class ReverseArray {

    public static boolean isSatsify(int[] numbers){
        ArrayList<Integer> positions=new ArrayList<>(3);
        if(!addTurnOverPositions(numbers,positions))
            return false;
        else if(positions.size()==2){
            if(numbers[positions.get(0)]<numbers[positions.get(1)])
                return false;
            else if(numbers[positions.get(0)]<numbers[positions.get(1)+1]&&numbers[positions.get(1)]>numbers[positions.get(0)-1])
                return true;
            else
                return false;
        }
        else if(positions.size()==1){
            if(numbers[positions.get(0)]>numbers[0]&&numbers[numbers.length-1]>numbers[positions.get(0)-1])
                return true;
            else if(numbers[positions.get(0)]<numbers[0]&&numbers[0]<numbers[positions.get(0)+1])
                return true;
            else
                return false;
        }
        else
            return true;
    }
    // 添加带有峰值元素的位置，如果这种位置的个数大于2，返回false，否则返回true.
    private static boolean addTurnOverPositions(int[] numbers,ArrayList<Integer> positions){
        int count=0;
        for(int i=1;i<numbers.length-1;i++){
            if((numbers[i]>numbers[i-1]&&numbers[i]>numbers[i+1])||(numbers[i]<numbers[i-1]&&numbers[i]<numbers[i+1])){
                positions.add(i);
                count++;
                if(count>2)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);

        int n=Integer.parseInt(input.nextLine());

        String[] elements=input.nextLine().split(" ");
        int[] numbers=new int[elements.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i]=Integer.parseInt(elements[i]);
        }

        System.out.println(isSatsify(numbers)?"yes":"no");
    }
}
