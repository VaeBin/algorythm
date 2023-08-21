package cn.hbb.algorithm.greed;


import java.util.PriorityQueue;

// 3 分隔金币最小代价
public class LeastMoney {
    public static void main(String[] args) {
        int[] arr = {2,1,7,3,4,2,1};
        System.out.println(leastMoney(arr));
    }

    public static int leastMoney(int[] arr){
        // 放进小根堆
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int a : arr){
            heap.add(a);
        }

        // 弹出两个值合并放回，累加到代价里
        int cost = 0;
        int cur = 0;
        while(heap.size()>1){
            cur = heap.poll() + heap.poll();
            cost += cur;
            heap.add(cur);
        }

        // 返回代价
        return cost;
    }
}
