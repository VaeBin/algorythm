package cn.hbb.java.sorting.quickSort;

import java.util.Arrays;

public class NetherlandsFlag1 {

    public static void main(String[] args) {

        int[] nums = {2,5,3,7,8,5,3,7,9};
        System.out.println(Arrays.toString(netherlandsFlag(nums, 5)));
    }


    /**
     * 题目：一个target和nums，要求把nums中<=target的放左边，>target的数放右边，左右两部分可以无序。
     * 最左边维持一个<=区域，放比目标数target小等的数，边界为border=-1，index往右遍历数组nums，如果当前数nums[index]<=target,
     * 则交换index数和边界外第一个位置数，index+1，border+1。如果index数>target，index+1。
     * @param nums target
     * @return
     */
    public static int[] netherlandsFlag(int[] nums, int target){
        if (nums==null || nums.length==0)
            return null;
        int len = nums.length;
        if (len==1)
            return nums;

        int border = -1;
        for(int index = 0;index<len;index++){
            if(nums[index]<=target){
                swap(nums,border+1, index);
                border++;
            }
        }
        return nums;
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
