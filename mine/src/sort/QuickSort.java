package sort;

/**
 * 快速排序
 */
public class QuickSort {

    // 快速排序
    public void quickSort(int[] numbers,int left,int right){
        int index=partition(numbers,left,right);
        if(index<right)
            quickSort(numbers,index,right);
        if(left<index-1)
            quickSort(numbers,left,index-1);
    }

    // 将一个数组分解成2部分,左边部分的所有值都小于右边部分
    private int partition(int[] numbers,int left,int right){
        int pivot=numbers[(left+right)>>1];
        while(left<=right){
            while(numbers[left]<pivot)
                left++;
            while(numbers[right]>pivot)
                right--;
            if(left<=right){
                swap(numbers,left,right);
                left++;
                right--;
            }
        }
        return left;
    }

    // 将一个数组2个位置值交换位置
    private void swap(int[] numbers,int first,int second){
        int temp=numbers[first];
        numbers[first]=numbers[second];
        numbers[second]=temp;
    }
}
