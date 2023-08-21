package cn.hbb.java.sorting.mergeSort;

public class CountOfRangeSum_ {

    public int countRangeSum(int[] nums, int lower, int upper) {
        int len = nums.length;
        if(nums==null || len==0)
            return 0;

        //前缀和sum
        long[] sum = new long[len];
        sum[0] = nums[0];
        for(int i = 1;i<len;i++)
            sum[i] = sum[i-1]+nums[i];

        return process(sum,0,len-1,lower,upper);
    }

    public int process(long[] sum, int L, int R, int lower, int upper){
        if(L==R)
            return sum[L]>=lower && sum[R]<=upper?1:0;

        int M = L+((R-L)>>1);
        return process(sum,L, M,lower,upper)+process(sum,M+1,R,lower,upper)+merge(sum,L,M,R,lower,upper);
    }

    public int merge(long[] sum, int L,int M,int R,int lower, int upper){
        int ans = 0;
        int windowL = L;
        int windowR = L;
        for(int i = M+1;i<=R;i++){
            long min = sum[i]-upper;
            long max = sum[i]-lower;
            while(windowL<=M && sum[windowL]<min){
                windowL++;
            }
            while(windowR<=M && sum[windowR]<=max){
                windowR++;
            }
            ans += windowR-windowL;
        }

        //merge
        long[] help = new long[R-L+1];
        int index = 0;
        int p1 = L;
        int p2 = M+1;
        while(p1<=M && p2<=R){
            help[index++] = sum[p1]<=sum[p2]?sum[p1++]:sum[p2++];
        }
        while(p1<=M)
            help[index++] = sum[p1++];
        while(p2<=R){
            help[index++] = sum[p2++];
        }
        for(int j = 0;j<help.length;j++){
            sum[L+j] = help[j];
        }
        return ans;
    }
}