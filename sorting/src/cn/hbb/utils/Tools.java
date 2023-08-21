package cn.hbb.utils;

public class Tools {
    public static void swap(int[] arr, int idx1, int idx2){

        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }


    // 对数器
    public static int[] generateArray(int maxV, int maxLen){
        System.out.println(Math.random()*(maxLen+1));
        System.out.println((int)(Math.random()*(maxLen+1)));
        int len = (int)(Math.random()*(maxLen+1));
        int[] arr = new int[len];
        for(int i=0;i<arr.length;i++){
            arr[i] = (int) (Math.random() * maxV)-(int)(Math.random()*maxV);
        }
        return arr;
    }


    public static boolean compareArrs(int[] arr1, int[] arr2){
        if (arr1.length != arr2.length)
            return false;

        for (int i=0; i<arr1.length; i++){
            if (arr1[i]!=arr2[i])
                return false;
        }
        return true;
    }



    //随机生成arr
    public static int[] generateArr(int range, int maxLen){
        int[] arr;
        int len = (int)(Math.random()*maxLen)+5;
        arr = new int[len];
        for (int i =0 ;i<len;i++){
            arr[i] = (int)(Math.random()*range)+1-(int)(Math.random()*range);
        }
        return arr;
    }
}
