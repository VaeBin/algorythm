package cn.hbb.algorithm.queue;

public class RingArray {

    public static void main(String[] args) {
        QueueByArray queue = new QueueByArray(5);
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.pop());
        queue.push(4);
        queue.push(5);
        queue.push(6);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());

    }

    public static class QueueByArray{
        public int start ;
        public int end ;
        public int size ;
        public int[] arr;
        final public int limit;

        public QueueByArray(int limit){
            this.start=0;
            this.end = 0;
            this.size = 0;
            this.arr = new int[limit];
            this.limit = limit;
        }

        // 添加
        public void push(int val){
            if (size==limit)
                throw new RuntimeException("队列满了不能加了");

            size++;
            arr[start] = val;
            start = nextIndex(start);
        }

        public int pop(){
            if (size==0)
                throw new RuntimeException("队列是空的");
            size--;
            int rst = arr[end];
            end = nextIndex(end);
            return rst;
        }


        // 循环的index
        public int nextIndex(int index){
            return index+1>=limit?0:index+1;
        }





    }
}
