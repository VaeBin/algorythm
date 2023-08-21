package cn.hbb.java.tree;


import java.util.Stack;

// 1 先中后序遍历
public class preInPost {

    public static void main(String[] args) {

    }

    // 非递归先序遍历,弹出节点打印先压右节点再压左节点
    public static void preStack(Node head){
        if(head==null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        Node pop;
        while(!stack.isEmpty()){
            pop = stack.pop();
            System.out.println(pop.value);
            if (pop.right!=null){
                stack.push(pop.right);
            }
            if (pop.left!=null){
                stack.push(pop.left);
            }
        }
    }

    // 非递归后序遍历,弹出节点不打印进另一个栈，先压左节点再压右节点
    public static void postStack(Node head){
        if(head==null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        Stack<Node> stack1 = new Stack<>();
        stack.push(head);
        Node pop;
        while(!stack.isEmpty()){
            pop = stack.pop();
//            System.out.println(pop.value);
            stack1.push(pop);
            if (pop.left!=null){
                stack.push(pop.left);
            }
            if (pop.right!=null){
                stack.push(pop.right);
            }
        }
    }
    // 非递归中序遍历,弹出节点不打印进另一个栈，先压左节点再压右节点
    public static void inStack(Node head){
        if(head==null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node pop;
        Node cur = head;
        while(!stack.isEmpty()|| cur!=null){
            if(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            else{
                cur = stack.pop();
                System.out.println(cur.value);
                cur = cur.right;
            }
        }
    }


    // 递归先序遍历
    public static void pre(Node head){
        if(head==null){
            return;
        }
        System.out.println(head.value);
        pre(head.left);
        pre(head.right);
    }
    // 递归后序遍历
    public static void post(Node head){
        if(head==null){
            return;
        }
        pre(head.right);
        pre(head.left);
        System.out.println(head.value);
    }
    // 递归中序遍历
    public static void in(Node head){
        if(head==null){
            return;
        }
        pre(head.left);
        System.out.println(head.value);
        pre(head.right);
    }
}
