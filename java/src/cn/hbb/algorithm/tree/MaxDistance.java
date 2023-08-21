package cn.hbb.algorithm.tree;

// 11 求二叉树中两个节点的最大距离
public class MaxDistance {


    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(2);
        head.right = new Node(7);
        head.left.right = new Node(4);
        head.left.right.left = new Node(3);
        System.out.println(maxDistance(head).distance);
    }

    public static class Info{
        int distance;
        int height;

        public Info(int d, int h){
            this.distance = d;
            this.height = h;
        }
    }

    public static Info maxDistance(Node x){
        if(x == null){
            return new Info(0, 0);
        }

        // 左右信息
        Info leftInfo = maxDistance(x.left);
        Info rightInfo = maxDistance(x.right);

        // 求max distance
        int d1 = leftInfo.distance;
        int d2 = rightInfo.distance;
        int d3 = leftInfo.height + rightInfo.height +1;
        int maxDis = Math.max(Math.max(d1,d2),d3);

        // 求height
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;

        return new Info(maxDis, height);
    }
}
