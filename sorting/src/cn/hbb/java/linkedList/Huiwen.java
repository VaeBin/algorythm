package cn.hbb.java.linkedList;

import java.util.Stack;


public class Huiwen {

    public static void main(String[] args) {
        Node head = new Node(1);
        Node temp = head;
        temp.next = new Node(2);
        temp = temp.next;
        temp.next = new Node(3);
        temp = temp.next;
        temp.next = new Node(3);
        temp = temp.next;
        temp.next = new Node(2);
        temp = temp.next;
        temp.next = new Node(1);
        temp = temp.next;
        temp.next = null;

        System.out.println(isHuiWen(head));
        System.out.println(isHuiWenOnLocal(head));





    }

    /**
     * 利用容器，比如栈，数组进行判断回文
     * @param head
     * @return
     */
    public static boolean isHuiWen(Node head){
        if (head==null)
            return false;
        Node temp = head;
        Stack<Integer> stack = new Stack<>();
        while(temp!=null){
            stack.push(temp.value);
            temp = temp.next;
        }
        temp = head;
        while(temp!=null){
            Integer pop = stack.pop();
            if (pop!=temp.value)
                return false;
            temp = temp.next;
        }
        return true;
    }

    public static boolean isHuiWenOnLocal(Node head){
        if (head==null)
            return false;

        // 找到中指针
        Node midNode = findMid(head);

        // 把中指针往右反转链表，记录尾巴节点
        Node end = null;
        Node temp = midNode;
        Node next = null;
        Node last = null;
        while (temp!=null){
            next = temp.next;
            temp.next = last;
            last = temp;
            temp = next;
        }
        end = last;

        // 从头，尾两节点遍历，直到一方为空结束判断回文
        Node headTemp = head;
        Node endTemp = end;
        while(headTemp!=null&& endTemp!=null){
            if (headTemp.value!= endTemp.value)
                return false;
            headTemp = headTemp.next;
            endTemp = endTemp.next;
        }
        return true;
    }

    /**
     * 快慢指针找中间或上中指针
     * @param head
     * @return
     */
    public static Node findMid(Node head){
        if(head==null)
            return null;

        Node slow = head;
        Node fast = head;
        while(fast!=null){
            fast = fast.next;
            if (fast==null || fast.next==null)
                return slow;
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

}
