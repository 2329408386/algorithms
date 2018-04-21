package sort;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class SortTest {
    static final int N=100;
    static InsertionSort insertionSort;
    static QuickSort quickSort;
    static QuickInsertion quickInsertion;
    static Random random =new Random();

    @Before
    public void init(){
        insertionSort=new InsertionSort();
        quickSort=new QuickSort();
        quickInsertion=new QuickInsertion();
    }

    @Test
    public void insertionSort() {
        int[] numbers=generate(N);
        assertEquals(false,isSorted(numbers));
        insertionSort.insertionSort(numbers);
        assertEquals(true,isSorted(numbers));
    }

    @Test
    public void quickSort(){
        int[] numbers=generate(N);
        assertEquals(false,isSorted(numbers));
        quickSort.quickSort(numbers,0,numbers.length-1);
        assertEquals(true,isSorted(numbers));
    }

    @Test
    public void quickInsertion(){
        int[] numbers=generate(N);
        assertEquals(false,isSorted(numbers));
        quickInsertion.quickInsertion(numbers,0,numbers.length-1);
        assertEquals(true,isSorted(numbers));
    }

    // 判断一个数组是否有序
    private boolean isSorted(int[] numbers){
        for (int i = 0; i < numbers.length-1; i++) {
            if(numbers[i]>numbers[i+1])
                return false;
        }
        return true;
    }

    // 生成一个长度为n的随机数组(n>=1)
    public int[] generate(int n){
        int[] numbers=new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i]=random.nextInt();
        }
        return numbers;
    }
}