package cn.hbb.algorithm.tree;


import java.util.LinkedList;
import java.util.Queue;

// 8 判断是否是完全二叉树
public class IsCBT {


    public static void main(String[] args) {

        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(5);

        System.out.println(isCBT(head));
        System.out.println(isCBTBy2(head));
    }


    // 递归套路方法
    public static class Info{
        boolean isFull;
        boolean isCBT;
        int height;

        public Info(boolean isFull, boolean isCBT, int height) {
            this.isFull = isFull;
            this.isCBT = isCBT;
            this.height = height;
        }
    }

    public static boolean isCBTBy2(Node x){
        return process(x).isCBT;
    }

    public static Info process(Node x){
        if(x==null){
            return new Info(true, true, 0);
        }

        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);

        boolean isFull = leftInfo.isFull && rightInfo.isFull && (leftInfo.height== rightInfo.height);
        // 是否是完全二叉树。
        // 可能1：左右都满，同高
        boolean p1 = leftInfo.isFull && rightInfo.isFull && (leftInfo.height==rightInfo.height);
        // 可能2：左完全，右满，左高=右高+1
        boolean p2 = leftInfo.isCBT && rightInfo.isFull && (leftInfo.height==(rightInfo.height+1));
        // 可能3：左满，右满，左高=右高+1
        boolean p3 = leftInfo.isFull && rightInfo.isFull && (leftInfo.height==(rightInfo.height)+1);
        // 可能4：左满，右完全，左高=右高
        boolean p4 = leftInfo.isFull && rightInfo.isCBT && (leftInfo.height== rightInfo.height);
        boolean isCBT = p1 || p2 || p3 || p4;
        int height = Math.max(leftInfo.height, rightInfo.height)+1;

        return new Info(isFull, isCBT, height);
    }








    // 层次遍历方法
    public static boolean isCBT(Node head){
        if (head==null){
            return true;
        }

        // 层次遍历
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        boolean leaf = false;
        while(!queue.isEmpty()){
            Node poll = queue.poll();
            if(poll.left==null && poll.right!=null){
                return false;
            }
            // 如果当前节点不是叶节点，检查是否遇到过子节点不双全的节点
            if((poll.left!=null || poll.right!=null)&& leaf){
                return false;
            }
            if(poll.left==null || poll.right==null){
                leaf=true;
            }

            // 层次遍历
            if(poll.left!=null){
                queue.add(poll.left);
            }
            if(poll.right!=null){
                queue.add(poll.right);
            }
        }
    return true;
    }
}
