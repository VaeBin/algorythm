package cn.hbb.java.tree;

import java.util.LinkedList;
import java.util.Queue;

// 4 层次遍历二叉树
public class LevelPrint {

    public static void level(Node head){
        if (head==null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        Node cur = null;
        while(!queue.isEmpty()){
            cur = queue.poll();
            System.out.println(cur.value);
            if(cur.left!=null){
                queue.add(cur.left);
            }
            if(cur.right!=null){
                queue.add(cur.right);
            }
        }
    }

}
