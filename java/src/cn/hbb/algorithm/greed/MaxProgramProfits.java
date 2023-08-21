package cn.hbb.algorithm.greed;

import java.util.Comparator;
import java.util.PriorityQueue;

// 4 做收益最大的项目
public class MaxProgramProfits {
    public static void main(String[] args) {

    }

    public static class Program{
        int cost;
        int profits;

        public Program(int cost, int profits) {
            this.cost = cost;
            this.profits = profits;
        }
    }



    /**
     * @param K  最多做K个项目
     * @param W   本金
     * @param profits   项目们的利润数组
     * @param costs     项目们的成本数组
     * @return  最终返回最大资金
     */
    public static int maxProfits(int K, int W, int[] profits, int[] costs){
        // 按照cost构建小根堆
        PriorityQueue<Program> minCosts = new PriorityQueue<>(new Comparator<Program>() {
            @Override
            public int compare(Program o1, Program o2) {
                return o1.cost - o2.cost;
            }
        });
        // 按照profits构建大根堆
        PriorityQueue<Program> maxProfits = new PriorityQueue<>(new Comparator<Program>() {
            @Override
            public int compare(Program o1, Program o2) {
                return o2.profits - o1.profits;
            }
        });

        // 填入数据heap
        for(int i = 0; i < profits.length; i++){
            minCosts.add(new Program(costs[i], profits[i]));
        }

        // K轮选取项目
        for(int j = 0; j < K; j++){
            // 根据w判断出小根堆入大根堆，多个项目
            while(!minCosts.isEmpty() && minCosts.peek().cost <= W){
                maxProfits.add(minCosts.poll());
            }
            // 买不起，无项目
            if(maxProfits.isEmpty()){
                return W;
            }
            W += maxProfits.poll().profits;
        }
    return W;
    }
}
