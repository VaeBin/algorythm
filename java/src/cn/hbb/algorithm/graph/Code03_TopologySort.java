package cn.hbb.algorithm.graph;


import java.util.*;

// 图的拓扑排序
public class Code03_TopologySort {

    public static List<Node> sortedTopology(Graph graph){
        //维持一个<节点,入度>的map，和一个入度为零的节点队列
        HashMap<Node, Integer> map = new HashMap<>();
        Queue<Node> zeroQueue = new LinkedList<>();
        //遍历图的节点添加进两个集合
        for(Node node : graph.nodes.values()){
            map.put(node, node.in);
            if (node.in==0){
                zeroQueue.add(node);
            }
        }
        //遍历入度零的队列while不为空，弹出，加入拓扑排序，更新map里nexts的入度--。如果到0加入zerolist
        List<Node> result = new ArrayList<>();
        while(!zeroQueue.isEmpty()){
            Node poll = zeroQueue.poll();
            result.add(poll);
            for(Node next: poll.nexts){
                next.in--;
                if(next.in==0){
                    zeroQueue.add(next);
                }
            }
        }
        return result;
    }

}
