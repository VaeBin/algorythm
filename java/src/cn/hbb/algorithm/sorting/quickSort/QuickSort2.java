package cn.hbb.algorithm.sorting.quickSort;

import java.util.Arrays;

public class QuickSort2 {

    public static void main(String[] args) {
        int[] nums = {2,5,3,7,8,5,3,7,5};
        quickSort2(nums);
        System.out.println(Arrays.toString(nums));

    }

    /**
     * 系统栈递归】
     * 和荷兰国旗2一样，只不过每次partition不再是固定的最后一位，而是以随机的一个位置上的数先和最后一位交换再使用最后一位partition
     *
     * @param nums
     */
    public static void quickSort2(int[] nums){
        if(nums==null || nums.length<2)
            return;
        process(nums, 0,nums.length-1);
    }

    public static void process(int[] arr, int L, int R){
        if (L>=R)
            return;
        swap(arr, L+(int)(Math.random()*(R-L+1)),R); // 增加了随机性partition，时间复杂度会变成O(NlogN)
        int[] flags = netherlandsFlag(arr, L, R);
        process(arr, L, flags[0]-1);
        process(arr, flags[1]+1, R);
    }

    public static int[] netherlandsFlag(int[] nums, int L, int R){

        if (L>R)
            return new int[]{-1,-1};
        int len = R-L+1;
        if (len==1)
            return new int[]{L,L};

        // 最右侧的值为基准
        int target = nums[R];
        int lborder = L-1;    // L往左一位
        int rborder = R;   // R往左一位
        for(int index = L;index<rborder;index++){
            if(nums[index]<target){
                swap(nums,++lborder, index);
            }
            else if(nums[index]>target){
                swap(nums,--rborder,index--);
            }
        }
        swap(nums,rborder,R);
        return new int[]{lborder+1, rborder};
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
