package sort;

/**
 * 快速插入排序. 在数据量100万以下的时候,都是我的大多数时候占据上风, 但当数据量超大的时候,确实它的更快.
 */
public class QuickInsertion {
    private static int N=10;

    // 快速排序
    public void quickInsertion(int[] numbers,int left,int right){
        int index=partition(numbers,left,right);
        if(index<right){
            if(right-index>=N)
                quickInsertion(numbers,index,right);
            else
                insertionSort(numbers,index,right);
        }

        if(left<index-1){
            if(index-1-left>=N)
                quickInsertion(numbers,left,index-1);
            else
                insertionSort(numbers,left,index-1);
        }
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

    // 插入排序
    private void insertionSort(int[] numbers,int left,int right){
        for (int i = left; i <=right; i++) {
            int value=numbers[i],pos=i-1;
            while(pos>=left&&numbers[pos]>value)
                pos--;
            move(numbers,pos+1,i);
        }
    }

    // 将end位置的值移动到begin位置, 将begin到end-1的值一次后移一位
    private void move(int[] numbers,int begin,int end){
        int value=numbers[end];
        for (int i = end; i > begin; i--) {
            numbers[i]=numbers[i-1];
        }
        numbers[begin]=value;
    }

    // 获得quickInsertion的时间
    public long getQuickInsertionTime(int[] numbers){
        long begin=System.nanoTime();
        quickInsertion(numbers,0,numbers.length-1);
        long end=System.nanoTime();
        return end-begin;
    }
}
