package cn.hbb.algorithm;

import static cn.hbb.utils.Tools.swap;

public class CheckResults {

    /**
     * 遍历n-1次，每一次选出前面最大的放在最后
     * @param arrays
     */
    public static void selectSort(int[] arrays) {
        // null empty?
        if(arrays==null || arrays.length<2)
            return ;

        // from 0...N-1 TO 1...N-1 TO 2...N-1
        for(int i=0; i<arrays.length-1; i++){
            // each itr's minIndex
            int minIndex = i;
            for(int j=i+1; j<arrays.length; j++){

                // from min to max sorting
                minIndex = arrays[j] < arrays[minIndex] ? j : minIndex;
            }
            // itr over , swap the values
            swap(arrays, minIndex, i);
        }

    }


    /**
     * 两个两个比较，一路向前
     * @param arr
     */
    public  static void bubblingSort(int[] arr){
        if (arr== null || arr.length < 2)
            return;

        for (int i=0; i<arr.length; i++){    // n times
            for (int j=0; j<arr.length-1-i; j++){
                if (arr[j] > arr[j+1])
                    swap(arr, j, j+1);
            }
        }
    }

    /**
     * 插入排序，倒着来找到合适的位置插入
     * @param arr
     */
    public static void insertSort(int[] arr){
        if (arr == null || arr.length < 2)
            return ;

        // 错误写法，因为交换了之后可能又将很小的数交换到后面来了，但是i已经继续往下走了，跳过了。
//        for (int i = 1; i<arr.length; i++){
//            int j = i-1;
//            while (j>=0 && arr[i]<arr[j]){
//                j--;
//            }
//            if(i != j+1)
//                swap(arr, i, j+1);
//        }

        for (int i = 1; i< arr.length; i++){
            for (int j = i-1; j>=0; j--){
                if (arr[j+1]<arr[j]){
                    swap(arr, j, j+1);
                }

            }
        }
    }

}
