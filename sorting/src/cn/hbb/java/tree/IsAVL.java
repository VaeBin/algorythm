package cn.hbb.java.tree;

// 9 判断是否是平衡二叉树
public class IsAVL {


    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.right = new Node(5);
        head.left.right.left = new Node(5);
        System.out.println(isAVL(head).isBalanced);
    }


    public static class Info{
        boolean isBalanced;
        int height;

        public Info(boolean isBalanced, int height){
            this.height = height;
            this.isBalanced = isBalanced;
        }


    }
    public static Info isAVL(Node head){
        if(head==null){
            return new Info(true, 0);
        }
        // 判断左右两树是否平衡
        Info leftInfo = isAVL(head.left);
        Info rightInfo = isAVL(head.right);

        // 判断该树是否平衡
        boolean isBalanced = (leftInfo.isBalanced && rightInfo.isBalanced) &&
                (Math.abs(leftInfo.height- rightInfo.height)<=1);
        int height = Math.max(leftInfo.height, rightInfo.height)+1;
        return new Info(isBalanced, height);
    }
}
