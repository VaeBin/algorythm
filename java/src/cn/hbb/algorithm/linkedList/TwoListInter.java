package cn.hbb.algorithm.linkedList;

// 1
public class TwoListInter {

    public static void main(String[] args) {

    }

    public static Node getIntersectNode(Node head1, Node head2){
        if (head1==null||head2==null){
            return null;
        }
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        // 两条有环
        if (loop1!=null && loop2!=null){
            return bothLoop(head1, loop1, head2, loop2);
        }
        // 两条无环
        if (loop1==null && loop2==null){
            return noLoop(head1, head2);
        }
        // 一条有环一条无环
        return null;
    }


    public static Node noLoop(Node head1, Node head2){
        if (head1==null || head2==null){
            return null;
        }
        Node cur1 = head1;
        Node cur2 = head2;
        int n = 0;
        while(cur1!=null){
            n++;
            cur1 = cur1.next;
        }
        while(cur2!=null){
            n--;
            cur2 = cur2.next;
        }
        // 假设cur1长
        cur1 = n>0?head1:head2;
        cur2 = cur1==head1?head2:head1;

        // cur1先走
        while(n!=0){
            cur1 = cur1.next;
            n--;
        }
        while(cur1!=cur2){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2){
        // 入环是否相同,相交在前
        if (loop1==loop2){
            Node cur1 = head1;
            Node cur2 = head2;
            int n = 0;
            while(cur1!=loop1){
                n++;
                cur1 = cur1.next;
            }
            while(cur2!=loop2){
                n--;
                cur2 = cur2.next;
            }
            // 假设cur1长
            cur1 = n>0?head1:head2;
            cur2 = cur1==head1?head2:head1;

            // cur1先走
            while(n!=0){
                cur1 = cur1.next;
                n--;
            }
            while(cur1!=cur2){
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        }
        else{
            // 入环不同
            Node cur1 = loop1.next;
            while(cur1!=loop1){
                if (cur1==loop2)
                    return cur1;
            }
            return null;
        }
    }

    // 找到链表的第一个入环节点
    public static Node getLoopNode(Node head){

        if (head==null){
            return null;
        }

        Node fast = head;
        Node slow = head;
        // 第一次相遇
        while(slow!=fast){
            if (fast.next==null||fast.next.next==null){
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        // 第二次相遇
        fast = head;
        while(slow!=fast){
            fast = fast.next;
            slow=slow.next;
        }
        return slow;
    }
}
