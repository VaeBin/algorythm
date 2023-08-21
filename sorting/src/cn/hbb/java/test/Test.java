package cn.hbb.java.test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Test {

    public static void main(String[] args) {
        int[] arr = {3,2,1,4,5,4};
        System.out.println(kArr(arr, 3));
    }

    public static Integer kArr(int[] arr, int K){
        if (arr == null || arr.length ==0){
            return null;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        for(int i = 0; i < arr.length; i++){
            queue.add(arr[i]);
        }

        while(K > 0){
            Integer poll = queue.poll();
            K--;
        }
        if(!queue.isEmpty()){
            return queue.peek();
        }
        else {
            return null;
        }
    }
}
