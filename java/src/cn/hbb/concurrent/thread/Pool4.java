package cn.hbb.concurrent.thread;

import java.util.concurrent.*;

public class Pool4 {

    static int[] nums = new int[100_000_000];
    static {
        for(int i = 0;i<nums.length;i++){
            nums[i] = (int)(Math.random()*1000);
        }
    }

    public static void main(String[] args) {

        ForkJoinPool forkJoinPool = (ForkJoinPool)Executors.newWorkStealingPool();
        long begin = System.nanoTime();
        ForkJoinTask<Integer> task = forkJoinPool.submit(new SumRecursiveTask(0,nums.length-1));
        long end = System.nanoTime();

        System.out.println(end-begin);
    }

    private static class SumRecursiveTask extends RecursiveTask<Integer>{
        private int start,end;
        private final int MAX_STRIDE = 20_000_000;
        public SumRecursiveTask(int start, int end){
            this.start = start;
            this.end = end;
        }


        @Override
        protected Integer compute() {
            int sum = 0;
            int stride = end-start;
            if (stride<=MAX_STRIDE){
                // 处理任务
                for (int i = start;i<=end;i++)
                    sum += nums[i];

            }
            else{
                //分而治之
                int mid = start+((end-start)>>1);
                SumRecursiveTask left = new SumRecursiveTask(start,mid);
                SumRecursiveTask right = new SumRecursiveTask(mid+1,end);
                left.fork();
                right.fork();
                sum = left.join()+right.join();
            }
            return sum;
        }
    }


}
