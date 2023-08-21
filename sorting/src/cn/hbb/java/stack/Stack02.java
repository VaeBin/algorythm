package cn.hbb.java.stack;

import java.util.Stack;

public class Stack02 {

    public static void main(String[] args) {

        TwoStackImitateQueue queue = new TwoStackImitateQueue();
        queue.push(3);
        queue.push(4);
        queue.push(5);

        System.out.println(queue.pop());
        System.out.println(queue.pop());
        queue.push(4);
        queue.push(5);

        System.out.println(queue.pop());
        System.out.println(queue.pop());

    }


    /**
     * 使用栈黑盒结构实现队列（先进先出）
     * 用两个栈，一个push栈一个pop栈，把push栈的数据全倒进pop栈里，从pop栈取数据就是先进先出。
     * 如果倒数据需要全部一次性倒完，且pop里是空的
     */
    public static class TwoStackImitateQueue{
        public Stack<Integer> pushStack;
        public Stack<Integer> popStack;

        public TwoStackImitateQueue(){
            pushStack = new Stack<>();
            popStack = new Stack<>();
        }

        // 倒数据两个原则，一次性全部和popstack是空
        private void pushToPop(){
            if (popStack.empty()){
                while(!pushStack.empty()){
                    popStack.push(pushStack.pop());
                }
            }
        }

        public void push(int val){
            pushStack.push(val);
            pushToPop();
        }

        public int pop(){
            if (pushStack.empty() && popStack.empty())
                throw new RuntimeException("空的");
            pushToPop();
            return popStack.pop();
        }

        public int peek(){
            if (pushStack.empty() && popStack.empty())
                throw new RuntimeException("空的");
            pushToPop();
            return popStack.peek();
        }
    }


}
