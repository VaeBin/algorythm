package cn.hbb.algorithm.dynamic;



// # 11不同的货币纸币去组合成aim价值的方法数
public class Code11_CoinsWayEveryPaperDifferent {

    public static void main(String[] args) {

    }

    // 递归,从左到右模型----------------------

    public static int recurrent(int[] arr, int aim){
        return process(arr, 0, aim);
    }

    /**
     *
     * @param arr  货币数组（有面值重复的货币）
     * @param index     当前货币要还是不要
     * @param rest    剩余要组成的货币价值
     * @return
     */
    public static int process(int[] arr, int index, int rest){
        // base
        if(rest < 0){
            return 0;
        }

        if(index == arr.length){
            return rest == 0 ? 1 : 0;
        }
        else{
            return process(arr, index+1, rest-arr[index]) + process(arr, index+1, rest);
        }
    }

    // 动态规划-------------------

    public static int dp(int[] arr, int aim){

        int N = arr.length;
        int[][] dp = new int[N+1][aim+1];

        dp[N][0] = 1;
        for(int index = N-1; index >= 0; index--){
            for(int rest = 0; rest <= aim; rest++){   // rest从右往左或者从左往右都行，因为依赖的事index下一行反正一行填完了才会填上一行
                if(rest-arr[index] < 0){
                    dp[index][rest] =  dp[index+1][rest];
                }
                else{
                    dp[index][rest] += dp[index+1][rest-arr[index]];
                }
            }
        }
        return dp[0][aim];
    }

}
