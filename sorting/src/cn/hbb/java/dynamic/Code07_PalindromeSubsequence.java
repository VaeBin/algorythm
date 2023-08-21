package cn.hbb.java.dynamic;


// #7 求最长回文子序列： 范围尝试模型
public class Code07_PalindromeSubsequence {

    public static void main(String[] args) {
        String s = "ji345khjk543";
        System.out.println(recurrent(s));
        System.out.println(dp(s));
        System.out.println(dp1(s));
    }

    // 递归尝试-------------------

    public static int recurrent(String s){
        if(s == null || s.length()==0){
            return 0;
        }
        int N = s.length();
        return process(s.toCharArray(), 0, N-1);
    }

    // STR[L,...R]范围上的最长
    public static int process(char[] str, int L, int R){
        // base
        if(L == R){

            return 1;
        }
        if(L == R-1){
            return str[L] == str[R]?2:1;
        }

        // 以L,R两端讨论四种情况
        int p1 = process(str, L+1, R-1);
        int p2 = process(str, L, R-1);
        int p3 = process(str, L+1, R);
        int p4 = str[L] == str[R]?(2 + process(str, L+1, R-1)):0;
        return Math.max(Math.max(p1, p2), Math.max(p3, p4));
    }


    // 动态规划---------------------------------
    public static int dp(String s){
        if(s == null || s.length()==0){
            return 0;
        }

        char[] str = s.toCharArray();
        int N = str.length;
        int[][] dp = new int[N][N];


        dp[N-1][N-1] = 1;
        for(int i = 0; i < N-1; i++){
            dp[i][i] = 1;
            dp[i][i+1] = str[i] == str[i+1] ? 2 : 1;
        }

        for(int L  = N-3; L >= 0; L--){
            for(int R = L+2; R < N; R++){

                // 以L,R两端讨论四种情况
                int p1 = dp[L+1][R-1];
                int p2 = dp[L][R-1];
                int p3 = dp[L+1][R];
                int p4 = str[L] == str[R]?(2 + dp[L+1][R-1]):0;
                dp[L][R] =  Math.max(Math.max(p1, p2), Math.max(p3, p4));
            }
        }

        return dp[0][N-1];
    }



    // 动态递归进一步优化，填表时：

    // 动态规划---------------------------------
    public static int dp1(String s){
        if(s == null || s.length()==0){
            return 0;
        }

        char[] str = s.toCharArray();
        int N = str.length;
        int[][] dp = new int[N][N];


        dp[N-1][N-1] = 1;
        for(int i = 0; i < N-1; i++){
            dp[i][i] = 1;
            dp[i][i+1] = str[i] == str[i+1] ? 2 : 1;
        }

        for(int L  = N-3; L >= 0; L--){
            for(int R = L+2; R < N; R++){
                // 以L,R两端讨论四种情况简略版忽略左下，左下不可能是最大的情况，比左和下都小
                dp[L][R] = Math.max(dp[L][R-1], dp[L+1][R]); //先比较左和下谁更大

                if(str[L] == str[R]){
                    dp[L][R] =  Math.max(2 + dp[L+1][R-1], dp[L][R]);
                }
            }
        }
        return dp[0][N-1];
    }
}
