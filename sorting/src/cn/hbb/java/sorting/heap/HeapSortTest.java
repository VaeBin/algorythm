package cn.hbb.java.sorting.heap;

import cn.hbb.java.Utils;

import java.util.Arrays;

public class HeapSortTest {

    public static void main(String[] args) {
        int[] nums = {2,5,3,7,8,5,3,7,5};
        heapSort(nums);
        System.out.println(Arrays.toString(nums));

    }

    public static void heapSort(int[] arr){
        if (arr==null || arr.length<2)
            return;
        int len = arr.length;
        // 构建大根堆insert方法O(NlogN)
//        for(int i = 0;i<len;i++){
//            heapInsert(arr, i);
//        }
        // 构建大根堆heapify方法O(N)
        for(int i = len-1;i>=0;i--){
            heapify(arr, i,len);
        }
        // 头尾交换，heapsize--, 重新heapify成大根堆。再交换、--、heapify
        int heapSize = len;
        while(heapSize>0){
            Utils.swap(arr, --heapSize,0);
            heapify(arr, 0, heapSize);
        }
    }





    private static void heapInsert(int[] arr, int index){
        while(arr[index]>arr[(index-1)/2]){
            Utils.swap(arr, index, (index-1)/2);
            index = (index-1)/2;
        }
    }

    private static void heapify(int[] arr, int index, int heapsize){
        int left = index*2+1;
        while(left<heapsize){
            // 比较孩子最大的位置
            int largest = left+1<heapsize && arr[left]<arr[left+1]?left+1:left;
            largest = arr[largest]<arr[index]?index:largest;    // 比较孩子中最大和父亲谁最大
            if (largest==index)
                break;
            Utils.swap(arr, index, largest);
            index = largest;
            left = index*2+1;
        }
    }

}
