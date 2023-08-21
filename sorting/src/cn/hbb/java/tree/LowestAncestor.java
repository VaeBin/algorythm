package cn.hbb.java.tree;


// 14 找两个节点的最低公共祖先
public class LowestAncestor {

    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(2);
        head.right = new Node(7);
        head.left.right = new Node(4);
        head.left.right.left = new Node(3);
        System.out.println(findAncestor(head,head.left,head.left.right).value);
    }


    public static class Info{
        boolean findA;
        boolean findB;
        Node ans;

        public Info(boolean findA, boolean findB, Node ans) {
            this.findA = findA;
            this.findB = findB;
            this.ans = ans;
        }
    }

    public static Node findAncestor(Node x, Node a, Node b){
        return process(x, a, b).ans;
    }

    public static Info process(Node x, Node a, Node b){
        if(x==null){
            return new Info(false, false, null);
        }

        Info leftInfo = process(x.left, a, b);
        Info rightInfo = process(x.right, a, b);

        boolean findA = leftInfo.findA || rightInfo.findA || (x==a);
        boolean findB = leftInfo.findB || rightInfo.findB || (x==b);
        Node ans = null;
        // 左树有结果
        if(leftInfo.ans!=null){
            ans = leftInfo.ans;
        }
        // 右树有结果
        else if(rightInfo.ans!=null){
            ans = rightInfo.ans;
        }
        // x汇聚，左右各一个或者x本身是一个
        else if(findA && findB){
            ans = x;
        }

        return new Info(findA, findB, ans);
    }

}
