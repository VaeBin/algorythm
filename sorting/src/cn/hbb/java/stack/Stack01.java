package cn.hbb.java.stack;

public class Stack01 {

    public static void main(String[] args) {
        DoubleStack doubleStack = new DoubleStack(3);
        doubleStack.push(4);
        doubleStack.push(2);
        doubleStack.push(5);
        System.out.println(doubleStack.getMin());
    }

    /**
     * 求：正常的栈实现push,pop,getMin，时间复杂度都为O（1）
     * 实现两个栈，一个正常栈，一个最小栈，同步push和pop。每次push时比对一下最小栈的栈顶更小就push，否则重复push最小栈栈顶
     * 不能用一个变量保持最小值，因为会pop，需要回退以前的最小值
     */
    public static class DoubleStack{
        public int[] arr;
        public int[] minStack;

        public int index;
        public final int limit;

        public DoubleStack(int limit){
            this.limit = limit;
            this.index = 0;
            this.arr = new int[limit];
            this.minStack = new int[limit];
        }

        public void push(int val){
            if (this.index==this.limit)
                throw new RuntimeException("栈满了");
            if (this.index>0)
                if(val<this.minStack[this.index-1])
                    this.minStack[this.index] = val;
                else
                    this.minStack[this.index] = this.minStack[this.index-1];
            else
                this.minStack[this.index] = val;
            this.arr[this.index++] = val;

        }

        public int pop(){
            if (this.index<=0)
                throw new RuntimeException("空的~");
            return this.arr[this.index--];
        }

        public int getMin(){
            if (this.index<=0)
                throw new RuntimeException("没有最小值哦，空的呢");
            return this.minStack[this.index-1];
        }
    }
}
