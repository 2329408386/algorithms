package sort;

/**
 * 插入排序
 */
public class InsertionSort {

    // 插入排序
    public void insertionSort(int[] numbers){
        for (int i = 0; i < numbers.length; i++) {
            int value=numbers[i],pos=i-1;
            while(pos>=0&&numbers[pos]>value)
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
}
