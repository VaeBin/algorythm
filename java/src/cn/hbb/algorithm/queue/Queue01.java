package cn.hbb.algorithm.queue;


import java.util.LinkedList;
import java.util.Queue;

public class Queue01 {

    public static void main(String[] args) {

        Integer a = 128;
        Integer b = 128;
        System.out.println(a==b);

        TwoQueueImitateStack<Integer> stack = new TwoQueueImitateStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.peek());

    }


    /**
     * 用队列模拟栈的先进后出
     * 用两个队列，轮班倒，主队列queue，副队列help，添加往主队列加，弹出的时候除了最后一个都放进help，弹出queue最后一个值，然后交换主副引用
     *
     */
    public static class TwoQueueImitateStack<T>{
        public Queue<T> queue;
        public Queue<T> help;

        public TwoQueueImitateStack(){
            queue = new LinkedList<>();
            help = new LinkedList<>();
        }

        public void push(T val){
            queue.offer(val);
        }

        public T pop(){
            if (queue.size()==0)
                throw new RuntimeException("空的");
            while(queue.size()>1){
                help.offer(queue.poll());
            }
            T rst = queue.poll();
            Queue<T> temp = queue;
            queue = help;
            help = temp;
            return rst;
        }

        public T peek(){
            if (queue.size()==0)
                throw new RuntimeException("空的");
            while(queue.size()>1){
                help.offer(queue.poll());
            }
            T rst = queue.poll();
            help.offer(rst);       // 要加回去，不能被弹走
            Queue<T> temp = queue;
            queue = help;
            help = temp;
            return rst;
        }
    }
}
