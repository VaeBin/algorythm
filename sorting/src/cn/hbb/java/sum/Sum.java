package cn.hbb.java.sum;

public class Sum {

    public static void main(String[] args) {
        System.out.println("求数组的第l-r索引段的和-------------");
        int[] arr = {3,5,2,6,3,7,9,1};
        System.out.println(new RangeSum(arr).rangeSum(1,2));






    }


    /**
     * 求数组的第l-r索引段的和
     * 维持一个前缀和数组pre[],arr[l~r]求和=pre[r]-pre[l-1]
     */
    public static class RangeSum{
        private int[] pre;

        public RangeSum(int[] arr){
            pre = new int[arr.length];
            pre[0] = arr[0];
            for (int i = 1;i<arr.length;i++){
                pre[i] = pre[i-1]+arr[i];
            }
        }

        public int rangeSum(int left, int right){
            if (left==0)
                return pre[right];

            if (left<=right)
                return pre[right]-pre[left-1];

            return -1;
        }
    }
}
