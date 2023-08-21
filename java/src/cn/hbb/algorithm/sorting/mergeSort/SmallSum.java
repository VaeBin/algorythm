package cn.hbb.algorithm.sorting.mergeSort;

/**
 * 小和问题，给一个数组arr,求每一个数右边比它大的数的累加和(个数之和，
 * 其实还有经典的逆序对，只是换成了右边比左边小，可以merge降序排序，也可以升序排序时索引从mid和r开始降
 * 两种方法对数器测试
 */
public class SmallSum {


    public static void main(String[] args) {

        // 对数器
        int times = 100;
        int[] arr;
        for (int i=0;i<times;i++){
            arr = generateArr(10, 20);
            System.out.println(violent(arr)==smallSum(arr));
        }
    }

    /**
     * 暴力求解O（N2）遍历
     * @param arr
     * @return
     */
    public static int violent(int[] arr){
        int rst = 0;
        if (arr==null || arr.length<2)
            return rst;

        for (int i = 1;i<arr.length;i++){
            for (int j = 0;j<i;j++){
                if (arr[j]<arr[i]){
                    rst+=arr[j];
                }
            }
        }
        return rst;
    }


    /**
     * merge递归，左右组两个索引merge，左边小才会有小和，如果左边小那么右边共有mergeSize-rindex-1个小和
     * @param arr
     * @return
     */
    public static int smallSum(int[] arr){
        int rst = 0;
        if (arr==null || arr.length<2)
            return rst;
        return process(arr, 0, arr.length-1);
    }

    public static int process(int[] arr, int l, int r){
        int rst = 0;
        // base
        if (l==r)
            return 0;
        int mid = l+((r-l)>>1);
        rst = process(arr, l,mid)+process(arr, mid+1,r)+merge(arr,l,mid,r);
        return rst;
    }

    public static int merge(int[] arr, int l, int mid, int r){
        int rst = 0;
        int p1 = l;
        int index = 0;
        int p2 = mid+1;
        int[] help=new int[r-l+1];
        while(p1<=mid && p2<=r){
            if (arr[p1]<arr[p2]){
                rst+=(r-p2+1)*arr[p1]; //p2及右侧有小和的个数是r-p2+1
                help[index++] = arr[p1++];
            }
            else {   // arr[p1]>=arr[p2]都是右移
                help[index++] = arr[p2++];
            }
        }
        // 右边结束了，左边更大，没有小和
        while(p1<=mid){
            help[index++]=arr[p1++];
        }
        // 左边结束了，右边更大剩下的都是小和
        while(p2<=r){
            help[index++] = arr[p2++];
        }
        for (int j=0;j<help.length;j++)
            arr[l+j] = help[j];
        return rst;
    }


    //随机生成arr
    public static int[] generateArr(int range, int maxLen){
        int[] arr;
        int len = (int)(Math.random()*maxLen)+1;
        arr = new int[len];
        for (int i =0 ;i<len;i++){
            arr[i] = (int)(Math.random()*range)-(int)(Math.random()*range);
        }
        return arr;
    }
}
