package cn.hbb.algorithm.tree;
import java.util.LinkedList;
import java.util.Queue;

//求一树的最大宽度（也可以求每一层的end节点），利用层次遍历
public class TreeWide {

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.left.right.left = new Node(7);
        head.left.left = new Node(4);
        head.right.right = new Node(6);
        head.right.right.left = new Node(8);
        System.out.println(wide(head));
    }


    public static int wide(Node head){
        if(head==null){
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);

        // 当前层节点数
        int curCount = 0;
        // 当前层的end节点
        Node curEnd = head;
        // 下一层end节点
        Node nextEnd = null;
        // 最大宽度数
        int max = 0;
        while(!queue.isEmpty()){
            Node poll = queue.poll();
            curCount++;
            if(poll.left!=null){
                queue.add(poll.left);
                nextEnd = poll.left;
            }
            if(poll.right!=null){
                queue.add(poll.right);
                nextEnd = poll.right;
            }
            if(poll==curEnd){
                max = max>curCount?max:curCount;
                curCount = 0;
                curEnd = nextEnd;
                nextEnd = null;
            }
        }
        return max;
    }
}
