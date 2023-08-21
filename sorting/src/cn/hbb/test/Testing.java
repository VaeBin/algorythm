package cn.hbb.test;

import cn.hbb.java.CheckResults;

import java.util.*;

import static cn.hbb.utils.Tools.compareArrs;
import static cn.hbb.utils.Tools.generateArray;

public class Testing {
    public static void main(String[] args) {

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("11");
        arrayList.add("22");
        arrayList.add("33");
        ListIterator<String> it = arrayList.listIterator();
        while (it.hasNext()) {
            if ("22".equals(it.next()))
                it.add("dd");
        }

        String[] names = {"Bob", "Alice", "Grace"};
        StringJoiner sj = new StringJoiner(", ", "Hello ", "!");
        for (String name : names) {
            sj.add(name);
        }
        System.out.println(sj.toString());
        StringBuilder sb = new StringBuilder("builder");


        int[] arr = {2, 5, 66, 33, 8888, 3354, 2, 44};
    }

        /*
        System.out.println("---------selected sorting----------");
        Sorting.selectSort(arr);
        System.out.println(Arrays.toString(arr));
        */

        /*
        System.out.println("--------bubbling sorting------------");
        Sorting.bubblingSort(arr);
        System.out.println(Arrays.toString(arr));
        */

/*
        System.out.println("--------inserted sorting------------");
        Sorting.insertSort(arr);
        System.out.println(Arrays.toString(arr));
*/


        // 对数器，查找不对的数据测试样例，验证算法的正确性
//        int maxValue = 100, maxLen = 100;
//        int number = 100;
//        boolean success = false;
//        while(number-- >= 0) {
//
//            int[] array = generateArray(maxValue, maxLen);
//            int[] arr1 = Arrays.copyOf(array, array.length);
//            int[] arr2 = Arrays.copyOf(array, array.length);
//
//            Arrays.sort(arr1);
//            CheckResults.insertSort(arr2);
//
//            System.out.println(Arrays.toString(array));
//            System.out.println(Arrays.toString(arr1));
//            System.out.println(Arrays.toString(arr2));
//            if(!compareArrs(arr1, arr2)){
//                break;
//            }
//            success = true;
//        }
//
//        System.out.println(success? "success!" : "fucked!");
//    }
}
