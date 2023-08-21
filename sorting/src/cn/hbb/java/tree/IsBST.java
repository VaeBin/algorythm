package cn.hbb.java.tree;


// 10 判断是否是搜索二叉树。
public class IsBST {
    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(2);
        head.right = new Node(7);
        head.left.right = new Node(4);
        head.left.right.left = new Node(3);
        System.out.println(isBST(head).isBST);
    }

    public static class Info{
        boolean isBST;
        int max;
        int min;

        public Info(boolean isBST, int max, int min) {
            this.isBST = isBST;
            this.max = max;
            this.min = min;
        }
    }

    public static Info isBST(Node head){
        if (head==null){
            return null;
        }

        // 判断左右子树是否搜索
        Info leftInfo = isBST(head.left);
        Info rightInfo = isBST(head.right);

        boolean isBST = true;
        // 判断该树是否搜索
        if(leftInfo!=null && ((!leftInfo.isBST)||(leftInfo.max >= head.value))){
            isBST = false;
        }
        if(rightInfo!=null && ((!rightInfo.isBST)||(rightInfo.min <= head.value))){
            isBST = false;
        }

        // 该树max,min
        int max = head.value;
        int min = head.value;
        max = rightInfo!=null?Math.max(rightInfo.max, max):max;
        max = leftInfo!=null?Math.min(leftInfo.min, min):min;

        return new Info(isBST, max, min);
    }

}
