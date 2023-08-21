package cn.hbb.java.linkedList;

/**
 * 给一个链表，和一个target值，小于target的放左边，等于的放中间，大于的放右边
 * 方法一：额外数组空间，遍历至数组然后快排然后连接起来
 * 方法二：空间O(1)，用六个变量，小头、小尾、等头、等尾、大头、大尾，遍历链表放到对应区域连接，最后小尾连等头，等尾连大头
 */
public class QuickSortLinkeList {

    public static void main(String[] args) {
        Node linkeList = NodeUtils.generateLinkeList(8, 20);


    }

    public Node sortByArea(Node head, int target) {
        if (head == null)
            return null;
        Node sH = null;
        Node sT = null;
        Node eH = null;
        Node eT = null;
        Node lH = null;
        Node lT = null;

        Node next = null;
        while (head != null) {
            if (head.value < target) {
                if (sT == null) {
                    sH = head;
                    sT = head;
                }
                sT.next = head;
            }


        }

        return null;
    }

}
