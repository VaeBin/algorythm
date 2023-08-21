package cn.hbb.algorithm.sorting.heap;


import cn.hbb.algorithm.Utils;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 一个数组是无序的，但是在排好序后不超过距离K。
 * 用小根堆0-5位置，然后取最小放在第一个位置，然后接着add到小根堆接着取
 */
public class UnSortInKRange {


    public static void main(String[] args) {
        int[] nums = {2,5,3,7,8,5,3,7,5};
        unSortInKRange(nums,3);
        System.out.println(Arrays.toString(nums));
    }

    public static void unSortInKRange(int[] arr, int K){
        if (arr==null || arr.length<2)
            return;

        int len = arr.length;
        int begin = 0;
        // 构建小根堆
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = begin;i<=begin+K;i++){
            heap.add(arr[i]);
        }
        Integer poll = heap.poll();
        arr[begin++] = poll;

        while(begin+K<len){
            heap.add(arr[begin+K]);
            Integer poll1 = heap.poll();
            arr[begin++] = poll1;
        }
        while(!heap.isEmpty())
            arr[begin++] = heap.poll();

    }


    // 小根堆
    private static void heapify(int[] arr, int index, int heapsize){
        int left = index*2+1;
        while(left<heapsize){
            // 比较孩子最大的位置
            int smallest = left+1<heapsize && arr[left]<arr[left+1]?left:left+1;
            smallest = arr[smallest]>arr[index]?index:smallest;    // 比较孩子中最大和父亲谁最大
            if (smallest==index)
                break;
            Utils.swap(arr, index, smallest);
            index = smallest;
            left = index*2+1;
        }
    }

}
