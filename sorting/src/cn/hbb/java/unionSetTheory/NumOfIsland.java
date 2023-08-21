package cn.hbb.java.unionSetTheory;


// 2 岛数量问题， leet 200
public class NumOfIsland {
    public static void main(String[] args) {
//        char[][] grid ={{'1','1','1','1','0'},
//                        {'1','1','0','1','0'},
//                        {'1','1','0','0','0'},
//                        {'0','0','0','0','0'}};

        char[][] grid ={{'1','1','1'},
                        {'0','1','0'},
                        {'1','1','1'}};
        System.out.println(numIsland(grid));
    }


    // 方法一:并查集, 只看右边和下面，但是要考虑边界，最右一列和最最下一行
    public static int numIsland(char[][] board){
        Union union = new Union(board);
        int row = board.length;
        int col = board[0].length;

        // 边界
        for(int j = 1; j < col; j++){
            if(board[0][j] == '1' && board[0][j-1] == '1'){
                union.union(0, j-1, 0,j);
            }
        }
        for(int i = 1; i < row; i++){
            if(board[i][0] == '1' && board[i-1][0] == '1'){
                union.union(i-1, 0, i,0);
            }
        }

        for(int i = 1; i < row; i++){
            for(int j = 1; j < col; j++){
                if(board[i][j] == '1'){
                    if(board[i][j-1] == '1'){
                        union.union(i, j-1, i,j);
                    }
                    if(board[i-1][j] == '1') {
                        union.union(i-1, j, i, j);
                    }
                }
            }
        }
        return union.setsNum;
    }
    public static class Union{
        int[] parent;
        int[] setSize;
        int[] help;
        int setsNum;
        int col;

        public Union(char[][] board){
            int row = board.length;
            col = board[0].length;
            int len = row * col;

            parent = new int[len];
            setSize = new int[len];
            help = new int[len];
            setsNum = 0;
            for(int i = 0; i < row; i++){
                for(int j = 0; j < col; j++){
                    int index = getIndex(i, j);
                    if(board[i][j] == '1'){
                        parent[index] = index;
                        setSize[index] = 1;
                        setsNum++;
                    }
                    else {
                        parent[index] = -1;
                    }
                }
            }
        }


        // 换算二维坐标为一维坐标
        private int getIndex(int i, int j){
            return i*col + j;
        }

        // 把两个点所在的union合并
        public void union(int i, int j, int a, int b){
            // 找两点的代表
            int index1 = getIndex(i, j);
            int index2 = getIndex(a, b);
            int present1 = find(index1);
            int present2 = find(index2);

            // 代表不同则合并
            if(present1 != present2){
                // 比较size，小代表指大代表
                if(setSize[present1] < setSize[present2]){
                    parent[present1] = present2;
                    setSize[present2] += setSize[present1];
                }
                else {
                    parent[present2] = present1;
                    setSize[present1] += setSize[present2];
                }
                setsNum--;
            }
        }

        // 找到代表节点并优化指向parent
        private int find(int index){
            int tem = 0;
            while(index != parent[index]){
                help[tem++] = index;
                index = parent[index];
            }
            while(tem != 0){
                parent[help[--tem]] = index; // 重定向
            }
            return index;
        }
    }





    // ------------------------------------------------------------------------

    // 方法2（最优解）：递归，感染
    public static int numIsland2(char[][] board){
        int nums = 0;

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == '1'){
                    affect(board, i, j);    // 递归感染连在一起的所有1
                    nums++;
                }
            }
        }
        return nums;
    }

    private static void affect(char[][] board, int i, int j){
        // base case
        if(i < 0 || i >=board.length || j < 0 || j >= board[0].length || board[i][j] != '1'){
            return ;
        }

        // 先感染本位置
        board[i][j] = '0';

        // 感染周围
        affect(board, i-1, j);
        affect(board, i+1, j);
        affect(board, i, j-1);
        affect(board, i, j+1);
    }


}
