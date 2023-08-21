package cn.hbb.java.dynamic;


// 两个人零和博弈拿牌的两端，获胜者的分数
public class Code02_CardsInLine {
    public static void main(String[] args) {

        int[] arr = {5,7,4,5,8,1,6,0,3,4,6,1,7};
        System.out.println(win1(arr));
        System.out.println(win2(arr));
        System.out.println(win3(arr));
    }

    // 递归分析
    public static int win1(int[] arr){
        if(arr == null || arr.length == 0){
            return 0;
        }

        int firstScore = f(arr, 0, arr.length-1);
        int backScore = b(arr, 0, arr.length-1);
        return Math.max(firstScore, backScore);
    }

    // arr上L...R上先手获得的最好分数
    public static int f(int[] arr, int L, int R){
        // 只有一张牌,先拿
        if(L == R){
            return arr[L];
        }

        // 先拿了左牌
        int p1 = arr[L] + b(arr, L+1, R);
        // 先拿了右牌
        int p2 = arr[R] + b(arr, L, R-1);
        // 先手拿最大
        return Math.max(p1, p2);
    }

    // arr上L...R上后手能拿的最好分数
    public static int b(int[] arr, int L, int R){
        // 一张牌，拿不到
        if(L == R){
            return 0;
        }

        // 对方拿了左牌
        int p1 = f(arr, L+1, R);
        // 对方拿了右牌
        int p2 = f(arr, L, R-1);
        // 被迫选最小分数
        return Math.min(p1, p2);
    }

    // ------------------------------------------------------------------

    // 动态规划1.0
    public static int win2(int[] arr){
        if(arr == null || arr.length == 0){
            return 0;
        }
        int N = arr.length;
        int[][] fmap = new int[N][N];
        int[][] bmap = new int[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                fmap[i][j] = -1;
                bmap[i][j] = -1;
            }
        }

        int firstScore = f(arr, 0, arr.length-1, fmap, bmap);
        int backScore = b(arr, 0, arr.length-1, fmap, bmap);
        return Math.max(firstScore, backScore);
    }

    // arr上L...R上先手获得的最好分数
    public static int f(int[] arr, int L, int R, int[][] fmap, int[][] bmap){
        // 先从缓存找
        if(fmap[L][R] != -1){
            return fmap[L][R];
        }
        int ans = 0;
        // 只有一张牌,先拿
        if(L == R){
            ans =  arr[L];
        }
        else {
            // 先拿了左牌
            int p1 = arr[L] + b(arr, L+1, R, fmap, bmap);
            // 先拿了右牌
            int p2 = arr[R] + b(arr, L, R-1, fmap, bmap);
            // 先手拿最大
            ans =  Math.max(p1, p2);
        }
        fmap[L][R] = ans;
       return ans;
    }

    // arr上L...R上后手能拿的最好分数
    public static int b(int[] arr, int L, int R, int[][] fmap, int[][] bmap){
        // 先从缓存找
        if(bmap[L][R] != -1){
            return bmap[L][R];
        }
        int ans = 0;
//        // 一张牌，拿不到
//        if(L == R){
//            ans = 0;
//        }

        if(L != R){
            // 对方拿了左牌
            int p1 = f(arr, L+1, R, fmap, bmap);
            // 对方拿了右牌
            int p2 = f(arr, L, R-1, fmap, bmap);
            // 被迫选最小分数
            ans =  Math.min(p1, p2);
        }
        bmap[L][R] = ans;
        return ans;
    }


    // ------------------------------------------------------------------

    // 动态规划2.0填表版最终版
    public static int win3(int[] arr){
        if(arr == null || arr.length == 0){
            return 0;
        }
        int N = arr.length;
        int[][] fmap = new int[N][N];
        int[][] bmap = new int[N][N];
        for(int i = 0; i < N; i++){   //对角线
            fmap[i][i] = arr[i];
        }

        for(int startCol = 1; startCol < N; startCol++){
            int L = 0;
            int R = startCol;
            while(R < N){
                fmap[L][R] = Math.max(arr[L] + bmap[L+1][R], arr[R] + bmap[L][R-1]);
                bmap[L][R] = Math.min(fmap[L+1][R], fmap[L][R-1]);
                L++;
                R++;
            }
        }

        return Math.max(fmap[0][N-1], bmap[0][N-1]);
    }


}
