package cn.hbb.java.dynamic;


// 1 机器人走到目的地
public class Code01_RobotWalk {

    public static void main(String[] args) {

    }

    /**
     *
     * @param N  总共N个位置
     * @param start  起始位置
     * @param aim  终点位置
     * @param K   刚好走K步
     * @return   走法数量
     */
    public static int ways1(int N,int start, int aim, int K){

        // 检查无效题目
        if(N < 2 || start < 1 || start > N || aim < 1 || aim > N){
            return -1;
        }

        return process1(start, K, aim, N);
    }

    /**
     * 暴力递归，尝试过程
     * @param cur  走到当前位置
     * @param rest  剩余步数
     * @param aim   目的位置
     * @param N  有1~N位置
     * @return  机器人在当前位置走过rest步后最终停在aim处的方法数
     */
    public static int process1(int cur, int rest, int aim, int N){
        // base case
        if(rest == 0){
            return cur==aim?1:0;
        }

        // 还有步数要走
        // cur在1，下一步必须2
        if(cur == 1 && cur+1<=N ){
            return process1(2, rest - 1, aim, N);
        }

        // cur在N，下一步必须走N-1位置
        if(cur == N){
            return process1(N-1, rest-1, aim, N);
        }
        // cur在中间位置
        return process1(cur - 1, rest-1, aim, N) +
                process1(cur + 1, rest - 1, aim, N);
    }

    /**
     * 方法二，动态规划
     *
     * @param N  总共N个位置
     * @param start  起始位置
     * @param aim  终点位置
     * @param K   刚好走K步
     * @return   走法数量
     */
    public static int ways2(int N,int start, int aim, int K){
        // 检查无效题目
        if(N < 2 || start < 1 || start > N || aim < 1 || aim > N){
            return -1;
        }

        int[][] dp = new int[N+1][K+1];
        for(int i = 0; i <= N; i++){
            for(int j = 0; j <= K; j++){
                dp[i][j] = -1;
            }
        }
        return process2(start, K, aim, N, dp);
    }

    /**
     * 动态规划
     * @param cur  走到当前位置
     * @param rest  剩余步数
     * @param aim   目的位置
     * @param N  有1~N位置
     * @return  机器人在当前位置走过rest步后最终停在aim处的方法数
     */
    public static int process2(int cur, int rest, int aim, int N, int[][] dp){
        // 先判断是否缓存
        if(dp[cur][rest] != -1) {
            return dp[cur][rest];
        }

        int ans = 0;
        if(rest == 0){
            ans =  cur==aim?1:0;
        }
        else {
            // 还有步数要走
            // cur在1，下一步必须2
            if(cur == 1 && cur+1<=N ){
                ans =  process1(2, rest - 1, aim, N);
            }

            // cur在N，下一步必须走N-1位置
            else if(cur == N){
                ans =  process1(N-1, rest-1, aim, N);
            }
            // cur在中间位置
            else{
                ans = process1(cur - 1, rest-1, aim, N) +
                        process1(cur + 1, rest - 1, aim, N);
            }
        }
        dp[cur][rest] = ans;
        return ans;
    }


    // 最终动态规划版本，直接填表,全程根据递归尝试去填表
    public static int ways3(int N,int start, int aim, int K){
        // 检查无效题目
        if(N < 2 || start < 1 || start > N || aim < 1 || aim > N){
            return -1;
        }

        int[][] dp = new int[N+1][K+1];
        dp[aim][0] = 1;  // rest剩余步数为0，只有cur在aim时才有一种方法数
        for(int rest = 1; rest <= K; rest++){   // 竖着一列一列计算
            dp[1][rest] = dp[2][rest-1];
            for(int cur = 2; cur <= N; N++){
                dp[cur][rest] = dp[cur-1][rest-1] + dp[cur+1][rest-1];
            }
            dp[N][rest] = dp[N-1][rest-1];
        }
        return dp[start][K];
    }
}
