package cn.hbb.java.sorting.quickSort;

import java.util.Arrays;
import java.util.Stack;

class Range{
    public int L;
    public int R;

    public Range(int l, int r) {
        L = l;
        R = r;
    }
}


/**
 * 迭代版本
 */
public class QuickSort3 {

    public static void main(String[] args) {
        int[] nums = {2,5,3,7,8,5,3,7,5};
        quickSort3(nums);
        System.out.println(Arrays.toString(nums));

    }

    /**
     * 放弃系统栈递归，自己定义栈结构记录国旗两侧位置
     *
     *
     * @param nums
     */
    public static void quickSort3(int[] nums){
        if(nums==null  || nums.length<2)
            return;
        int len = nums.length;
        swap(nums, 0+(int)(Math.random()*len),len-1); // 增加了随机性partition，时间复杂度会变成O(NlogN)
        int[] flags = netherlandsFlag(nums, 0, len-1);
        Stack<Range> stack = new Stack<>();
        stack.push(new Range(0, flags[0]-1));
        stack.push(new Range(flags[1]+1, len-1));
        while(!stack.isEmpty()){
            Range range = stack.pop();
            if (range.L< range.R){
                swap(nums, range.L+(int)(Math.random()*(range.R- range.L+1)), range.R); // 增加了随机性partition，时间复杂度会变成O(NlogN)
                int[] subFlags = netherlandsFlag(nums, range.L, range.R);
                stack.push(new Range(range.L, subFlags[0]-1));
                stack.push(new Range(subFlags[1]+1, range.R));
            }
        }
    }

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
