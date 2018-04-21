package sort;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 用benchmark的方法来测试我设计的快速插入排序与系统自带的排序
 */
public class BenchMark {
    public static long getSystemSortTime(int[] numbers){
        long begin=System.nanoTime();
        Arrays.sort(numbers);
        long end=System.nanoTime();
        return end-begin;
    }

    public static void main(String[] args) throws IOException {
        QuickInsertion quickInsertion=new QuickInsertion();
        SortTest sortTest=new SortTest();
        Writer writer=new PrintWriter("mine/src/sort/data.txt");

        int BEGIN=100,END=10000,STEP=100;

        for (int i = BEGIN; i <=END ; i+=STEP) {
            int[] numbers=sortTest.generate(i);
            writer.write(Long.toString(quickInsertion.getQuickInsertionTime(Arrays.copyOf(numbers,numbers.length)))+"\t");
            writer.write(Long.toString(getSystemSortTime(numbers))+"\n");
        }
        writer.flush();
        writer.close();
    }
}
