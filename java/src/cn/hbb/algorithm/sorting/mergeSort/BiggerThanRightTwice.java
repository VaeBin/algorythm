package cn.hbb.algorithm.sorting.mergeSort;


import cn.hbb.utils.Tools;

/**
 * 求一个arr，每一个数num如果比它右边的的数的两倍还大则加1，求总数
 */
public class BiggerThanRightTwice {
    public static void main(String[] args) {
        int[] arr = Tools.generateArr(10, 10);
        for (int item : arr)
            System.out.println(item+" ");
        System.out.println(biggerThanRightTwice(arr));

    }

    public static int biggerThanRightTwice(int[] arr){
        if (arr==null || arr.length<2)
            return 0;

        int rst = 0;

        rst = process(arr, 0, arr.length-1);

        return rst;

    }

    public static int process(int[] arr, int l, int r){
        if (l==r)
            return 0;
        int mid = l+((r-l)>>1);
        return process(arr,l,mid)+process(arr,mid+1,r)+merge(arr, l, mid, r);
    }

    public static int merge(int[] arr, int l, int mid, int r){
        int rst = 0;

        //先计数
        int p2 = mid+1;
        for(int p1 = l;p1<=mid;p1++){
            while(p2<=r && (arr[p1]>arr[p2]*2)){  //记得一定右边不能越界
                p2++;
            }
            //计数
            rst+=p2-(mid+1);
        }

        // 再merge排序arr
        int lidx = l;
        int ridx = mid+1;
        int index = 0;
        System.out.println("-----index:"+index+", lidx:"+lidx+", ridx:"+ridx);
        int len = r-l+1;
        System.out.println("len:"+len+", l:"+l+", r:"+r);
        int[] help = new int[len];
        while(lidx<=mid && ridx<=r){
            help[index++] = arr[lidx]<arr[ridx]?arr[lidx++]:arr[ridx++];
            System.out.println("index:"+index+", lidx:"+lidx+", ridx:"+ridx);
        }
        while (lidx<=mid) {
            help[index++] = arr[lidx++];
            System.out.println("index:"+index+", lidx:"+lidx);
        }
        while (ridx<=r) {
            help[index++] = arr[ridx++];
            System.out.println("index:" + index + ", ridx:" + ridx);
        }
        for (int i=0;i<help.length;i++)
            arr[l+i] = help[i];
        return rst;

    }


}
