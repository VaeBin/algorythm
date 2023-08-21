package cn.hbb.algorithm.tree;

// 7 二叉树折纸问题
public class PaperFolding {
    public static void main(String[] args) {
        // 层数N
        int N = 4;
        process(1,N,true);
    }

    /**
     * 打印以想象的节点为头的整棵树
     * @param level  该节点在第level层
     * @param N   共有N层
     * @param down   是否是凹
     */
    public static void process(int level, int N, boolean down){
        if(level>N){
            return;
        }
        process(level+1, N, true);
        System.out.println(down?'凹':'凸');
        process(level+1, N, false);

    }
}
