package cn.hbb.java.sorting.quickSort;

import java.util.Arrays;

public class NetherlandsFlag2 {

    public static void main(String[] args) {

        int[] nums = {2,5,3,7,8,5,3,7,5};
        System.out.println(Arrays.toString(netherlandsFlag(nums,0,nums.length-1)));
    }


    /**
     * 题目：一个target和nums，要求把nums中<target的放左边，>target的数放右边，=target放中间。左右两部分可以无序。
     * 最左边维持一个<区域，右边维持一个>区域，边界为lborder=-1，rborder = len, index往右遍历数组nums，如果当前数nums[index]<target,
     * 则交换index数和小边界右第一个位置数，index+1，lborder+1。如果index数>target，则交换index数和大边界左第一个位置数，
     * rborder-1,index不能+1，因为交换后index处的数还没看过。如果=target，index++
     *
     * index向右遍历到index<rborder,就遍历完了
     *
     * 返回小旗子
     * 复杂度O(N)
     * @param nums
     * @return
     */
    public static int[] netherlandsFlag(int[] nums, int L, int R){

        if (L>R)
            return new int[]{-1,-1};
        int len = R-L+1;
        if (len==1)
            return new int[]{0,0};

        // 最右侧的值为基准
        int target = nums[R];
        int lborder = L-1;    // L往左一位
        int rborder = R-1;   // R往左一位
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
