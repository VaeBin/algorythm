package cn.hbb.algorithm.unionSetTheory;


// 1 给关系表，返回朋友圈个数
public class FriendCircles {

    public static void main(String[] args) {

        int[][] relationship = {{1,0,1,0,1},
                                {0,1,0,1,0},
                                {1,0,1,0,0},
                                {0,1,0,1,0},
                                {1,0,0,0,1}};
        System.out.println(friendCircles(relationship));

    }
    /**
     *
     * @param relationship
     * @return  根据一张对称的关系表返回朋友圈子数量
     */
    public static int friendCircles(int[][] relationship){
        int N = relationship.length;

        Unions unions = new Unions(N);

        // 遍历关系表，实现union的合并，最后返回合并后的union的个数
        for(int i = 0; i < N; i++){
            for(int j = i+1; j < N; j++){    // 只遍历对称矩阵的一半即可
                if(relationship[i][j]==1){
                    // 两者认识，合并圈子
                    unions.union(i, j);
                }


            }
        }
        return unions.sets;
    }


    public static class Unions{
        private int[] parent;    // 位置i的直系父亲
        private int[] setSize;   // 以位置i为代表节点的union的size个数
        private int[] help;      // 辅助数组，用来优化findParent的时路径压缩
        private int sets;        // 总共的圈子数

        public Unions(int N) {
            this.parent = new int[N];
            this.setSize = new int[N];
            this.help = new int[N];
            this.sets = N;   // 初始每个人一个union

            // 初始化每个人的直系parent是自己，以自己为代表节点的union size 为1
            for(int i = 0; i < N; i++){
                parent[i] = i;
                setSize[i] = 1;
            }
        }


        /**
         * 合并a,b两人的圈子
         * @param a
         * @param b
         */
        public void union(int a, int b){
            // 找到a，b的代表。如果相同已经在一个圈子不用合并，不同再合并
            int present1 = find(a);
            int present2 = find(b);

            if(present1!=present2) {
                // 比较两个圈子size，设置小的圈子的代表的parent为大的圈子的代表,改变size
                if(setSize[present1]<=setSize[present2]){
                    parent[present1] = present2;
                    setSize[present2] = setSize[present1] + setSize[present2];
                    setSize[present1] = 0;
                }
                else{
                    parent[present2] = present1;
                    setSize[present1] = setSize[present1] + setSize[present2];
                    setSize[present2] = 0;
                }
                // sets数-1
                sets--;
            }
        }

        /**
         *
         * @param i
         * @return  返回i的代表节点
         */
        public int find(int i){
            int index = 0;   // help
            while(i != parent[i]){
                help[index++] = parent[i];
                i = parent[i];
            }
            while(index!=0){
                parent[help[index]] = i;   // 将每一个沿途的直系parent都设置为代表
                index--;
            }
            return i;
        }
    }
}
