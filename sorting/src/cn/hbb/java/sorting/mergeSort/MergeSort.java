package cn.hbb.java.sorting.mergeSort;

import java.util.Arrays;
import java.util.List;

/**
 * merge排序时间复杂度0(NlogN)
 *
 */
public class MergeSort {

    public static void main(String[] args) {

        System.out.println("递归------------------");
        int[] arr = {3,5,1,7,9,3,2,4};
        mergeSort(arr);
        for (int item: arr)
            System.out.print(item+" ");
        System.out.println();
        System.out.println("迭代----------------------");
        int[] arr1 = {3,5,1,7,9,3,2,4};
        mergeSort2(arr1);
        for (int item: arr1)
            System.out.print(item+" ");

    }


    public static void mergeSort(int[] arr){
        if (arr==null || arr.length<2)
            return;

        // 调用递归
        process(arr, 0, arr.length-1);
    }

    /**
     * 递归过程先排序左边一半，排序右边一半，然后merge起来
     * @param arr
     * @param l
     * @param r
     */
    public static void process(int[] arr, int l, int r){
        // base case
        if (l==r)
            return;

        int mid = l+((r-l)>>1);
        process(arr,l,mid);
        process(arr,mid+1,r);
        merge(arr,l,mid,r);
    }

    /**
     * 归并，两半分别用两个索引，临时数组help保持一个索引，最后赋值给arr
     * @param arr
     * @param l
     * @param mid
     * @param r
     */
    public static void merge(int[] arr, int l, int mid, int r){
        //临时数组
        int[] help = new int[r-l+1];
        // 三个索引
        int lidx = l;
        int ridx = mid+1;
        int hidx = 0;
        // 两半都还有
        while(lidx<=mid && ridx<=r){
            help[hidx++] = arr[lidx]<arr[ridx]?arr[lidx++]:arr[ridx++];
        }
        // 右边没了左边还有
        while(lidx<=mid){
            help[hidx++] = arr[lidx++];
        }
        // 左边没了右边还有
        while(ridx<=r){
            help[hidx++] = arr[ridx++];
        }
        // 将help给arr
        for (int i=l;i<=r;i++){
            arr[i] = help[i-l];
        }
    }


    //-------------------用迭代的方法更明显O(NlogN)-------------------------------------

    /**
     * 步长从1，2，4，8，16.....要小于=N，共迭代logN次，每次merge是O(N)，总体就是O(NlogN)
     * @param arr
     */
    public static void mergeSort2(int[] arr){
        if (arr==null || arr.length<2)
            return;
        int N = arr.length;
        int mergeSize = 1;
        while(mergeSize<N){
            int l = 0;
            while(l<N){
                int mid = l+mergeSize-1;
                // 如果左半边不够mergeSize就不用和右半边合并了，单独作为一组，和下一次翻倍的mergeSize的合并
                if (mid>=N)
                    break;
                // 如果有左半边,r是多少，也有可能右半边残缺不完整
                int r = Math.min(mid+1+mergeSize-1, N-1);
                merge(arr,l,mid,r);
                l = r+1;
            }
            // 防止翻倍超出N，防止N很大会溢出,不能=，因为需要再merge一次
            if (mergeSize>N/2)
                break;
            // 翻倍
            mergeSize<<=1;
        }

    }

}
