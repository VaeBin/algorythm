//package cn.hbb.java.graph;
//
//import java.util.*;
//
//// 最小生成树
//public class Kruskal {
//
//
//    public static class Unions{
//        private Node[] parent;    // 位置i的直系父亲
//        private Node[] setSize;   // 以位置i为代表节点的union的size个数
//        private Node[] help;      // 辅助数组，用来优化findParent的时路径压缩
//        private HashMap<Integer, Node> map;
//        private int sets;        // 总共的圈子数
//
//        public Unions(int N) {
//            this.parent = new Node[N];
//            this.setSize = new Node[N];
//            this.help = new Node[N];
//            this.sets = N;   // 初始每个人一个union
//
//            // 初始化每个人的直系parent是自己，以自己为代表节点的union size 为1
//            for(int i = 0; i < N; i++){
//                parent[i] = i;
//                setSize[i] = 1;
//            }
//        }
//
//
//        /**
//         * 合并a,b两人的圈子
//         * @param a
//         * @param b
//         */
//        public void union(int a, int b){
//            // 找到a，b的代表。如果相同已经在一个圈子不用合并，不同再合并
//            int present1 = find(a);
//            int present2 = find(b);
//
//            if(present1!=present2) {
//                // 比较两个圈子size，设置小的圈子的代表的parent为大的圈子的代表,改变size
//                if(setSize[present1]<=setSize[present2]){
//                    parent[present1] = present2;
//                    setSize[present2] = setSize[present1] + setSize[present2];
//                    setSize[present1] = 0;
//                }
//                else{
//                    parent[present2] = present1;
//                    setSize[present1] = setSize[present1] + setSize[present2];
//                    setSize[present2] = 0;
//                }
//                // sets数-1
//                sets--;
//            }
//        }
//
//        /**
//         *
//         * @param i
//         * @return  返回i的代表节点
//         */
//        public int find(int i){
//            int index = 0;   // help
//            while(i != parent[i]){
//                help[index++] = parent[i];
//                i = parent[i];
//            }
//            while(index!=0){
//                parent[help[index]] = i;   // 将每一个沿途的直系parent都设置为代表
//                index--;
//            }
//            return i;
//        }
//    }
//
//
//    // 利用并查集
//    public static Set<Edge> kruskal(Graph graph){
//        //每个节点初始化为一个集合
//        FriendCircles.Unions unionsFind = new FriendCircles.Unions(graph.nodes.size());
//
//        //由边的权重从小到大排序遍历;，两端点如果是同一个集合内就不要（有环），如果不是则要然后合并成一个集合。
//        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new Comparator<Edge>() {
//            @Override
//            public int compare(Edge o1, Edge o2) {
//                return o1.weight-o2.weight;
//            }
//        });
//        Set<Edge> result = new HashSet<>();
//        while(!priorityQueue.isEmpty()){
//            Edge edge = priorityQueue.poll();
//            if(unionsFind.find(edge.from)!=unionsFind.find(edge.to)){
//
//
//            }
//
//        }
//
//    }
//
//}
