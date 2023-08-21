package cn.hbb.java.linkedList;

public class LinkedList {

    public static void main(String[] args) {

        //创建一个单链表
        Node node = new Node(0);
        Node head = node;
        Node temp = head;
        for (int i = 1;i<9;i++){
            temp.next = new Node(i);
            temp = temp.next;
            temp.next = new Node(i);
            temp = temp.next;
        }
        temp.next=null;

        // 创建一个双链表
        DoubleNode doubleHead = new DoubleNode(0);
        DoubleNode temp1 = doubleHead;
        DoubleNode pre = null;
        for (int i=1;i<9;i++){
            temp1.next = new DoubleNode(i);
            temp1.last = pre;
            pre = temp1;
            temp1 = temp1.next;
        }
        temp1.next=null;


         System.out.println("打印单链表----------------------");
        printLinkedList(head);

        System.out.println("删掉链表中所有值为3的节点----------------");
        Node deleteHead = deleteVal(head,3);
        printLinkedList(deleteHead);

        System.out.println("单链表反转------------------");
        Node newHead = reverseLinkedList(head);
        printLinkedList(newHead);

        System.out.println("打印双链表----------------------");
        printDoubleLinkedList(doubleHead);

        System.out.println("双链表反转------------------");
        DoubleNode newDoubleHead = reverseDoubleLinkedList(doubleHead);
        printDoubleLinkedList(newDoubleHead);


    }


    // 单链表
    public static class Node{
        public int value;
        public Node next;

        public Node(int data){
            value = data;
        }
    }
    // 双链表
    public static class DoubleNode{
        public int value;
        public DoubleNode last;
        public DoubleNode next;

        public DoubleNode(int data){
            value = data;
        }
    }

    /**
     * 反转单链表
     * @param head
     * @return
     */
    public static Node reverseLinkedList(Node head){

        if (head==null)
            return null;
        if (head.next==null)
            return head;

        Node tem = head;
        Node next, pre = null;
        while(tem!=null){
            next = tem.next;
            tem.next = pre;
            pre = tem;
            tem = next;
        }
        return head=pre;
    }

    /**
     * 打印单链表
     * @param head
     */
    public static void printLinkedList(Node head){
        Node node1 = head;
        for (;node1!=null;node1 = node1.next){
            System.out.print(node1.value+"->");
        }
        System.out.println(node1);
    }

    /**
     * 打印双链表
     * @param head
     */
    public static void printDoubleLinkedList(DoubleNode head){
        DoubleNode node1 = head;
        for (;node1!=null;node1 = node1.next){
            System.out.print(node1.value+"->");
        }
        System.out.println(node1);
    }

    /**
     * 反转双链表
     * @param doubleHead
     * @return
     */
    public static DoubleNode reverseDoubleLinkedList(DoubleNode doubleHead){

        if (doubleHead==null|| doubleHead.next==null)
            return doubleHead;

        DoubleNode pre = null;
        DoubleNode next = null;
        DoubleNode temp = doubleHead;

        while(temp!=null){
            next = temp.next;
            temp.last = next;
            temp.next = pre;
            pre = temp;
            temp = next;
        }
        pre.last = null;
        doubleHead = pre;

        return doubleHead;
    }

    /**
     * 删掉值为val的节点
     * @param head
     * @param val
     * @return
     */
    public static Node deleteVal(Node head, int val){
        Node tem = head;
        Node next = head;
        Node pre = head;
        // head来到第一个不需要删的位置
        while (head!=null){
            if (head.value!=val)
                break;
            next = head.next;
            head = next;
        }
        while(tem!=null){
            next = tem.next;

            if (tem.value==val){
                pre.next = next;
            }
            else
                pre = tem;
            tem = next;
        }
        return head;
    }





}
