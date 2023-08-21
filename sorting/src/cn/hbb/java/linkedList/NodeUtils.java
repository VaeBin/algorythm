package cn.hbb.java.linkedList;

public class NodeUtils {
    private NodeUtils(){}

    public static void printLinkedList(Node head){
        while(head!=null){
            System.out.println(head.value+" ");
            head = head.next;
        }
    }

    public static Node generateLinkeList(int len, int range){
        Node head = new Node((int) Math.random() * range);
        Node tem = head;
        while(len>1){
            Node node = new Node((int) Math.random() * range);
            tem.next = node;
            tem = tem.next;
        }

        return head;
    }
}
