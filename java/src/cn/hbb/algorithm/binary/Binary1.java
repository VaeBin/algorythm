package cn.hbb.algorithm.binary;

public class Binary1 {


    public static void main(String[] args) {


        int[] arr = {3,3,4,5,6,7,7,8,9};
        System.out.println("有序数组中找某个数是否存在--------------");
        System.out.println(binarySearch(arr,9));

        System.out.println("找有序数组中>=某数最左侧的位置-------");
        System.out.println(indexLeft(arr, 3));

        System.out.println("找无序数组中局部最小位置-------");
        int[] arr1 = {8,6,4,5,6,1,7,5,9};
        System.out.println(localMin(arr1));

    }

    /**
     * 有序数组中找某个数是否存在
     * @param arr, num
     * @return
     */
    public static boolean binarySearch(int[] arr, int num){

        if (arr==null || arr.length==0)
            return false;

        int l = 0;
        int r = arr.length-1;
        int mid = 0;
        while (l<r){
//            mid = (l+r)/2;
            mid = l+((r-l)>>1);   // 优化：防止溢出
            if (arr[mid]==num)
                return true;
            else if (arr[mid]<num){
                l = mid+1;
            }
            else
                r = mid-1;
        }
        return arr[l] == num;
    }

    /**
     * 找有序数组中>=某数最左侧的位置。返回索引
     * @param arr
     * @param num
     * @return
     */
    public static int indexLeft(int[] arr, int num){

        if (arr==null || arr.length==0)
            return -1;

        int l = 0;
        int r = arr.length-1;
        int mid = 0;
        int idx = 0;
        while(l<r){
            mid = l+((r-l)>>1);
            if (arr[mid]==num) {
                idx = mid;
                r = mid-1;
            }
            else if(arr[mid]<num){
                l = mid+1;
            }
            else {
                r = mid-1;
            }
        }
        return arr[l]==num?l:-1;
    }

    /**
     * 找出无序数组（相邻两位置的数不相等）中的某个局部最小索引
     * @param arr
     * @return
     */
    public static int localMin(int[] arr){

        if (arr==null || arr.length==0)
            return -1;
        // 判断1个数和最左端
        if (arr.length==1 || arr[0]<arr[1])
            return 0;
        // 判断最右端
        if (arr[arr.length-2]>arr[arr.length-1])
            return arr.length-1;
        int l = 1;
        int r = arr.length-2;
        int mid = 0;
        while(l<r){
            mid = l+((r-l)>>1);
            if (arr[mid]>arr[mid-1])
                r = mid-1;
            else if(arr[mid]>arr[mid+1])
                l = mid+1;
            else
                return mid;
        }
        // 3个数
        return l;
    }
}
