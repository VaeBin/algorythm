package cn.hbb.algorithm.graph;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

// 宽度优先遍历
public class Code01_BFS {


    public static void main(String[] args) {

    }

    public static void bfs(Node start){
        if(start==null){
            return;
        }

        // 准备队列，set
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();
        //添加第一个节点
        queue.add(start);
        set.add(start);
        //while队列不为空，弹出，打印
        while(!queue.isEmpty()){
            Node poll = queue.poll();
            System.out.println(poll.value);
            //while nexts，如果set不含next，加入next
            for(Node next: poll.nexts){
                if(!set.contains(next.value)){
                    set.add(next);
                    queue.add(next);
                }
            }
        }
    }
}
