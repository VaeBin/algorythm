package cn.hbb.java.dynamic;


// 背包问题
public class Code03_Knapsack {

    public static void main(String[] args) {

        int[] w = {3,2,4,7};
        int[] v = {5,6,3,19};
        int bag = 11;
        System.out.println(process(w, v, 0, bag));
        System.out.println(dpMethod(w, v, bag));
    }

    /**
     * 递归
     * @param w  重量数组
     * @param v  价值数组
     * @param index  当前决定物品的index
     * @param bag   剩余背包容量
     * @return
     */
    public static int process(int[] w, int[] v, int index, int bag){
        if(index == w.length){
            return 0;
        }
        // bag无容量，w可以为0，所以bag为0还可以继续
        if(bag < 0){
            return 0;
        }

        // 要当前物品,还得bag能装下当前物品重量
        int p1 = 0;
        if(bag-w[index]>=0){
            p1 = v[index] + process(w, v, index+1, bag-w[index]);
        }

        // 不要当前物品
        int p2 = process(w, v, index+1, bag);

        return Math.max(p1, p2);
    }

    // --------------------------------------------------------
    // 动态规划方法
    public static int dpMethod(int[] w, int[] v, int bag){
        int N = w.length;
        int[][] dp = new int[N+1][bag+1];

        // dp[N][] = 0;

        // 从下往上，然后假设从左往右计算哈
        for(int index = N-1; index >= 0; index--){
            for(int rest = 0; rest <= bag; rest++){
                // 要当前
                int p1 = 0;
                if(rest-w[index]>=0){
                    p1 = v[index] + dp[index+1][rest-w[index]];
                }

                // 不要当前物品
                int p2 = dp[index+1][rest];

                dp[index][rest] = Math.max(p1, p2);
            }
        }

        return dp[0][bag];
    }


}
