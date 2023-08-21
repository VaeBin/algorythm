package cn.hbb.algorithm.linkedList;

import java.util.HashMap;

public class CopyListWithRandom {

    public static class NodeWithRandom{
        public int value;
        public NodeWithRandom next;
        public NodeWithRandom random;

        public NodeWithRandom(int data){
            value = data;
        }

    }

    public static void main(String[] args) {


    }

    // 方法2，原地操作，原地把next改为新节点，一对一对的，仿map结构
    public static NodeWithRandom copyListWithRandomByLocal(NodeWithRandom head){
        NodeWithRandom cur = head;
        NodeWithRandom next;
        // insert新节点作为源节点的next，形成对
        while (cur!=null){
            next = cur.next;
            cur.next = new NodeWithRandom(cur.value);
            cur.next.next = next;
            cur = next;
        }

        // set 新节点的random指针
        cur = head;
        NodeWithRandom newCopy;
        while (cur!=null){
            next = cur.next.next;
            newCopy = cur.next;
            newCopy.random = cur.random!=null?cur.random.next:null;
            cur = next;
        }

        // set next指针
        cur = head;
        NodeWithRandom res = head.next;
        while(cur!=null){
            next = cur.next.next;
            newCopy = cur.next;
            cur.next = next;
            newCopy.next = next!=null?next.next:null;
            cur = next;
        }
        return res;
    }



    // 方法1：借助容器
    public static NodeWithRandom copyListWithRandomByCollection(NodeWithRandom head){

        HashMap<NodeWithRandom, NodeWithRandom> map = new HashMap<>();
        NodeWithRandom cur = head;

        // 先遍历一遍copy节点到hashmap
        while(cur!=null){
            map.put(cur, new NodeWithRandom(cur.value));
            cur = cur.next;
        }
        // 遍历，通过get方法连接
        cur = head;
        while (cur!=null){
            // set next
            map.get(cur).next = map.get(cur.next);
            // set random
            map.get(cur).random = map.get(cur.random);

            cur = cur.next;
        }
        return map.get(head);
    }
}
