package cn.hbb.java.dynamic;


import com.sun.org.apache.regexp.internal.RE;

// 8题象棋马怎么跳K步到达目的地，有多少走法
public class Code08_HorseJump {

    public static void main(String[] args) {

    }

    /**
     * 递归
     * @param a 目的地x坐标
     * @param b  目的地y坐标
     * @param K  走K步
     * @return
     */
    public static int recurrence(int a, int b, int K){
        return process(0, 0, K, a, b);
    }

    /**
     *
     * @param x  现在所处位置
     * @param y  现在位置
     * @param rest 剩余步数
     * @param a
     * @param b
     * @return
     */
    public static int process(int x, int y, int rest, int a, int b){
        // base
        if(rest == 0){
            return (x == a && y == b) ? 1 : 0;
        }
        // 越界x[0..9], y[0...8]
        if(x < 0 || x > 9 || y < 0 | y > 8)
        {
            return 0;
        }


        // 8 directions
        int ways = process(x+2, y+1, rest-1, a, b);
        ways += process(x+1, y+2, rest-1, a, b);
        ways += process(x+1, y-2, rest-1, a, b);
        ways += process(x+2, y-1, rest-1, a, b);
        ways += process(x-1, y-2, rest-1, a, b);
        ways += process(x-2, y-1, rest-1, a, b);
        ways += process(x-1, y+2, rest-1, a, b);
        ways += process(x-2, y+1, rest-1, a, b);

        return ways;
    }

    // 动态规划------------------------------
    public static int dp(int a, int b, int K){

        int[][][] dp = new int[10][9][K+1];   // k==0时还会判断
        //从rest从下往上算
        dp[a][b][0] = 1;
        for(int rest = 1; rest <= K; rest++){
            for(int x = 0; x < 10; x++){
                for(int y = 0; y < 9; y++){
                    // 8 directions
                    int ways = pick(dp, x+2, y+1, rest-1);
                    ways += pick(dp,x+1, y+2, rest-1);
                    ways += pick(dp,x+1, y-2, rest-1);
                    ways += pick(dp,x+2, y-1, rest-1);
                    ways += pick(dp,x-1, y-2, rest-1);
                    ways += pick(dp,x-2, y-1, rest-1);
                    ways += pick(dp,x-1, y+2, rest-1);
                    ways += pick(dp,x-2, y+1, rest-1);

                    dp[x][y][rest] = ways;

                }
            }
        }

        return dp[0][0][K];
    }

    // 如果x,y位置上越界了就返回0，如果没有越界就返回值
    public static int pick(int[][][] dp , int x, int y, int rest){
        if(x < 0 || x > 9 || y < 0 | y > 8)
        {
            return 0;
        }

        return dp[x][y][rest];
    }
}
