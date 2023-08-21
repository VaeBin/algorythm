package cn.hbb.algorithm.dynamic;


// # 4
public class Code04_ConvertToLetterString {
    public static void main(String[] args) {

        char[] str = "111".toCharArray();
        System.out.println(process(str,0));
        System.out.println(dp(str));
    }

    // 递归，从str[index,...]开始考虑
    public static int process(char[] str, int index){
        if(index == str.length){
            return 1;  // 叶节点要为1，只要能走到越界就是成功的一条路径，否则无效就在中途死去返回0；
        }

        // index没到最后， 说明有字符
        if(str[index] == '0'){
            return 0;   // 说明前面分配错了，没有‘o’字符对应的字符
        }

        // 单转
        int ways = process(str, index+1);

        // 双转,不越界而且小于27
        if(index+1 < str.length && (str[index] - '0')*10 + str[index+1] - '0' <27){
            ways += process(str, index+2);
        }

        return ways;
    }

    //----------------------------------------------------------------------
    //--动态规划--------------------------------------------------------------------

    public static int dp(char[] str){
        if(str == null || str.length == 0){
            return 0;
        }

        int N = str.length;
        int[] dp = new int[N+1];   // 判断base会到N所以由0~N组成

        // 位置依赖，从右往左填
        dp[N] = 1;
        for(int index = N-1; index >= 0; index--){
            // index没到最后， 说明有字符
            if(str[index] == '0'){
                continue;   // 说明前面分配错了，没有‘o’字符对应的字符,本来默认就是0了
            }

            // 单转
            int ways = dp[index+1];

            // 双转,不越界而且小于27
            if(index+1 < str.length && (str[index] - '0')*10 + str[index+1] - '0' <27){
                ways += dp[index+2];
            }
            dp[index] = ways;
        }
        return dp[0];
    }



}
