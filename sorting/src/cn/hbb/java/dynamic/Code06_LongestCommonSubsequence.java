package cn.hbb.java.dynamic;


import cn.hbb.java.tree.MaxHappy;

// #6 求两个字符串的最大公共子序列长度（不连续）
public class Code06_LongestCommonSubsequence {

    public static void main(String[] args) {

        String s1 = "ahj3453h";
        String s2 = "ahjd4he";
        System.out.println(longestSubsequence1(s1, s2));
        System.out.println(dp(s1, s2));

    }

    public static int longestSubsequence1(String s1, String s2){
        if(s1 == null || s2 == null || s1.length()==0 || s2.length()==0){
            return 0;
        }
        return process(s1.toCharArray(), s2.toCharArray(), s1.length()-1, s2.length()-1);
    }

    /**
     *
     * @param s1
     * @param s2
     * @param i   s1[0....i]
     * @param j    s2[0....j]
     * @return
     */
    public static int process(char[] s1, char[] s2, int i, int j){
        // base case:从右往左递归那就是最左边的时候终止，两个str最左不同时需要分三种情况考虑
        if(i == 0 && j == 0){
            return s1[i] == s2[j]?1:0;
        }
        else if(i == 0){
            return s1[i] == s2[j]?1:process(s1, s2, i, j-1);
        }
        else if(j == 0){
            return s1[i] == s2[j]?1:process(s1, s2, i-1, j);
        }

        // 常规情况-------------------

        // 不以i结尾，j可能结尾
        int p1 = process(s1, s2, i-1, j);
        // 不以j结尾，i可能结尾
        int p2 = process(s1, s2, i, j-1);
        // 以i结尾，以j结尾
        int p3 = s1[i] == s2[j]?1+ process(s1, s2, i-1, j-1):0;

        return Math.max(p1, Math.max(p2, p3));
    }


    // 动态规划---------------------
    public static int dp(String s1, String s2){
        if(s1 == null || s2 == null || s1.length()==0 || s2.length()==0){
            return 0;
        }
        int N = s1.length();
        int M = s2.length();
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        int[][] dp = new int[N][M];

        // 根据递归判断条件翻译
        dp[0][0] = str1[0] == str2[0]?1:0;
        for(int j = 1; j < M; j++){
            dp[0][j] = str1[0] == str2[j]?1:dp[0][j-1];
        }
        for(int i = 1; i < N; i++){
            dp[i][0] = str1[i] == str2[0]?1:dp[i-1][0];
        }


        for(int i = 1; i < N; i++){
            for(int j = 1; j < M; j++){
                // 不以i结尾，j可能结尾
                int p1 = dp[i-1][j];
                // 不以j结尾，i可能结尾
                int p2 = dp[i][j-1];
                // 以i结尾，以j结尾
                int p3 = str1[i] == str2[j]?1+ dp[i-1][j-1]:0;

                dp[i][j] = Math.max(p1, Math.max(p2, p3));
            }
        }

        // 确定返回值
        return dp[N-1][M-1];
    }

}
