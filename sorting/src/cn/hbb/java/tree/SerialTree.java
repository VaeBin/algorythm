package cn.hbb.java.tree;

import java.util.LinkedList;
import java.util.Queue;

// 5 树的序列化和反序列化
public class SerialTree {

    // 先序序列化
    public static Queue<String> serialPre(Node head){
        Queue<String> queue = new LinkedList<>();
        pres(head, queue);
        return queue;
    }

    /**
     * 递归方式先序
     * @param head
     * @param queue
     */
    public static void pres(Node head, Queue<String> queue){
        if (head==null){
            queue.add(null);
        }
        else {
            queue.add(String.valueOf(head.value));
            pres(head.left, queue);
            pres(head.right, queue);
        }
    }

    /**
     * 先序的反序列化
     * @param queue
     * @return
     */
    public static Node buildByPreQueue(Queue<String> queue){
        if(queue.size()==0 || queue==null){
            return null;
        }
        return preb(queue);
    }
    public static Node preb(Queue<String> queue){
        String value = queue.poll();
        if(value==null){
            return null;
        }
        Node head = new Node(Integer.valueOf(value));
        head.left = preb(queue);
        head.right = preb(queue);
        return head;
    }


    //按层方式序列化
    public static Queue<String> serialLevel(Node head){
        if (head==null){
            return null;
        }
        Queue<String> queue = new LinkedList<>();
        serialLevel(head, queue);
        return queue;
    }
    public static void serialLevel(Node head, Queue<String> queue){
        if (head==null){
            queue.add(null);
        }
        else{
            Queue<Node> list = new LinkedList<>();
            queue.add(String.valueOf(head.value));
            list.add(head);
            while(!list.isEmpty()){
                if (head.left!=null){
                    list.add(head.left);
                    queue.add(String.valueOf(head.left.value));
                }
                else {
                    queue.add(null);
                }
                if (head.right!=null){
                    list.add(head.right);
                    queue.add(String.valueOf(head.right.value));
                }
                else {
                    queue.add(String.valueOf(null));
                }
            }
        }
    }


    // 按层方式反序列化
    public static Node buildByLevelQueue(Queue<String> queue){
        if(queue.size()==0 || queue==null){
            return null;
        }
        Queue<Node> list = new LinkedList<>();
        Node head = generateNode(queue.poll());
        Node node = null;
        if(head!=null){
            list.add(head);
        }
        else{
            while(!list.isEmpty()){
                node = list.poll();
                node.left = generateNode(queue.poll());
                node.right = generateNode(queue.poll());

                if(node.left!=null){
                    list.add(node.left);
                }
                if(node.right!=null){
                    list.add(node.right);
                }
            }
        }
        return head;
    }
    public static Node generateNode(String s){
        if(s==null){
            return null;
        }
        Node node = new Node(Integer.valueOf(s));
        return node;
    }
}
