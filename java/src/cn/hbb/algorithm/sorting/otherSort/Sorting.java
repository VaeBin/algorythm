package cn.hbb.algorithm.sorting.otherSort;

public class Sorting {

    public static void printArr(int[] arr){

        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {1,5,2,4,8,33,77,3,7};
        System.out.println("选择排序-------------");
        printArr(arr);
        selectSort(arr);
        printArr(arr);
        System.out.println("冒泡排序-------------");
        arr = new int[]{1, 5, 2, 4, 8, 33, 77, 3, 7};
        printArr(arr);
        bubbleSort(arr);
        printArr(arr);
        System.out.println("插入排序-------------");
        arr = new int[]{1, 5, 2, 4, 8, 33, 77, 3, 7};
        printArr(arr);
        insertSort(arr);
        printArr(arr);


    }

    /**
     * 插入排序
     * 0-n轮位置上的数一次往前比较直到找到比他大的数的位置时插入进去,一直比较相互交换
     * @param arr
     */
    public static void insertSort(int[] arr){
        //边界条件
        if (arr.length<2 || arr==null)
            return;
//        // 直观
//        for (int e = 1;e<arr.length;e++){
//            int current = e;
//            while (current-1>=0 && arr[current-1]>arr[current]){
//                int temp = arr[current];
//                arr[current] = arr[current-1];
//                arr[current-1] = temp;
//
//                current--;
//            }
//        }
        // 优化后
        for (int e = 1;e<arr.length;e++){
            for (int current = e;current-1>=0 && arr[current-1]>arr[current];current--){
                int temp = arr[current];
                arr[current] = arr[current-1];
                arr[current-1] = temp;
            }
        }
    }


    /**
     * 冒泡排序
     * 由0到n-1， 0到n-2。。。。
     * @param arr
     */
    public static void bubbleSort(int[] arr){
        //边界条件
        if (arr.length<2 || arr==null)
            return;

        for (int i = 0;i<arr.length-1;i++){
            for (int j = 0;j<arr.length-1-i;j++){
                if (arr[j]<arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }




    /**
     * 选择排序，每一次选择最小/大的那个和索引处交换
     * @param arr
     */
    public static void selectSort(int[] arr){
        //边界条件
        if (arr.length<2 || arr==null)
            return;

        for (int index = 0;index<arr.length;index++){
            int min = arr[index];
            int minInd = index;
            // 每一轮选出最小的，交换
            for (int i = index+1;i< arr.length;i++){
                if (arr[i]<min){
                    minInd = i;
                    min = arr[i];
                }
            }
            // 每一轮最小值索引处的值和index索引的值交换
            int temp = arr[minInd];
            arr[minInd] = arr[index];
            arr[index] = temp;
        }

    }




}
