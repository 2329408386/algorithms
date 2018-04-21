package sort;

import java.util.Arrays;

/**
 * 比较插入排序和快速排序, 找到让它们速率基本相近的那个n值.
 */
public class Comparison {
    private static final int N=2000;    // 在2000以内必然有一个点, 使得快速排序的效率
    static InsertionSort insertionSort=new InsertionSort();
    static QuickSort quickSort=new QuickSort();
    static SortTest sortTest=new SortTest();

    public int findN(){
        // 记得测试时,传入的数组应该是副本
        for (int i = 5; i < N; i++) {
            int[] numbers=sortTest.generate(i);
            long quickTime=getQuickSortTime(Arrays.copyOf(numbers,numbers.length));
            long insertionTime=getInsertionSortTime(Arrays.copyOf(numbers,numbers.length));
            if(quickTime<insertionTime)
                return i;
        }
        return N;
    }

    // 获得快速排序一个整型数组的时间ni
    public long getQuickSortTime(int[] numbers){
        long begin=System.nanoTime();
        quickSort.quickSort(numbers,0,numbers.length-1);
        long end=System.nanoTime();
        return end-begin;
    }

    // 获得插入排序一个整型数组的时间
    public long getInsertionSortTime(int[] numbers){
        long begin=System.nanoTime();
        insertionSort.insertionSort(numbers);
        long end=System.nanoTime();
        return end-begin;
    }

    // 测出n的值为22,18,22,5,16,11(取16作为临界点).
    public static void main(String[] args) {
        Comparison comparison=new Comparison();
        System.out.println(comparison.findN());
    }
}
