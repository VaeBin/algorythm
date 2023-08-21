package cn.hbb.java.dynamic;

// #14题，醉汉走出K步后越界二维区域就死亡
public class Code14_BobDie {

    public static void main(String[] args) {


    }

    public static double bobDieLivePossibility(int row, int col, int K, int N, int M){
        return (double)process(row, col, K, N, M)/Math.pow(4, K);
    }

    /**
     * 递归
     * @param row   当前位置
     * @param col   当前位置
     * @param rest   剩余步数
     * @param N     区域大小
     * @param M     区域大小
     * @return
     */
    public static long process(int row, int col , int rest, int N, int M){
        // base
        if(row < 0 || row >= N || col < 0 || col >= M){
            return 0;
        }

        if(rest == 0){
            return 1;   // 生存点数+1
        }

        // 还有rest步数走
        long up = process(row-1, col, rest-1, N, M);
        long down = process(row+1, col, rest-1, N, M);
        long left = process(row, col-1, rest-1, N, M);
        long right = process(row, col+1, rest-1, N, M);

        return up + down + left + right;
    }

    // dp----------------------
    public static double dp(int row, int col, int K, int N, int M){
        long[][][] dp = new long[N][M][K+1];

        dp[row][col][0] = 0;
        for(int rest = 1; rest <= K; rest++){
            for(int r = 0; r < N; r++){
                for(int c = 0; c < M; c++){
                    // 还有rest步数走
                    long up = pick(dp, r-1,c,rest-1);
                    long down = pick(dp, r+1, c,rest-1);
                    long left = pick(dp, r,c-1,rest-1);
                    long right = pick(dp, r,c+1,rest-1);

                    dp[r][c][rest] = up + down + left + right;
                }
            }

        }
        return (double)dp[row][col][K]/Math.pow(4, K);
    }


    // 处理越界
    public static long pick(long[][][] dp, int row, int col, int rest){
        // base
        if(row < 0 || row >= dp.length || col < 0 || col >= dp[0].length){
            return 0;
        }
        return dp[row][col][rest];
    }
}
