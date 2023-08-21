package cn.hbb.algorithm.sorting.radixSort;


import java.util.Arrays;

/**
 * 标准步骤：从个位到最高位遍历数组，放入10个桶里，然后按顺序把桶里的数据拿出来，接着下一轮遍历。
 *
 * 优化：为了节约十个桶，还是从个位到高位遍历数组，准备一个count（十位）数组用来计数，然后变成累加前缀和，然后从右往左遍历原数组看该位应该填入
 * 最右边第几个位置。依次按位遍历
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] arr = {2,4,6,2,7,3,9};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void radixSort(int[] arr){
        if (arr==null|| arr.length<2)
            return;
        radixSort(arr,0,arr.length-1,maxbits(arr));
    }

    /**
     * L到R范围的数组排序，digit是有多少位
     * @param nums
     * @param L
     * @param R
     * @param bits
     */
    public static void radixSort(int[] nums, int L, int R, int bits){
        final int radix = 10;
        int[] help = new int[R-L+1];

        // bits循环
        for(int b = 1;b<=bits;b++){
            // count计数
            int[] count = new int[radix];
            int radix1 = 0;
            for(int i=L;i<=R;i++){
                radix1 = getRadix(nums[i], b);
                count[radix1]++;
            }

            // count'累加
            for(int j = 1;j<radix;j++){
                count[j] = count[j]+count[j-1];
            }

            // 从右往左遍历数组填数
            for(int index = R;index>=L;index--){
                radix1 = getRadix(nums[index], b);
                help[count[radix1]-1] = nums[index];
            }

            for(int i = 0;i<help.length;i++){
                nums[i+L] = help[i];
            }
        }
    }

    /**
     * num的第b位是什么数字
     * @param num
     * @param b
     * @return
     */
    public static int getRadix(int num,int b){
        return ((num/((int)Math.pow(10,b-1)))%10);
    }

    public static int maxbits(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int a: arr){
            max = Math.max(max, a);
        }
        // 计算max的位数
        int bits = 0;
        while(max!=0){
            bits++;
            max = max/10;
        }
        return bits;
    }
}
