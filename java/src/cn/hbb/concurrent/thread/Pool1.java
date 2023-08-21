package cn.hbb.concurrent.thread;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Pool1 {

//    public static void main(String[] args) throws IOException, InterruptedException {
//
//        method();
//        System.gc();
//
//        Thread.sleep(5000);
//
//        System.in.read();
//
//    }
//    public static void method(){
//        ExecutorService threadExecutor = Executors.newFixedThreadPool(2);
//
//        threadExecutor.execute(()->{
//            System.out.println(Thread.currentThread().getName());
//
//        });
//
//        threadExecutor.execute(()->{
//            System.out.println(Thread.currentThread().getName());
//
//        });
//        threadExecutor.shutdown();
//
//    }
static ExecutorService threadPool = Executors.newFixedThreadPool(200);

    public static void main(String[] args) throws Exception {
        newThreadPool();
        System.gc();
        Thread.sleep(5000);
        System.out.println("线程池被回收了！！");
        System.in.read();
    }

    private static void newThreadPool(){
        for (int i = 0; i < 200; i++) {
            final int a = i;
            threadPool.execute(() -> {
                System.out.println(a);
            });
        }
        threadPool.shutdown();
        for (int i = 0; i < 200; i++) {
            final int a = i;
            threadPool.execute(() -> {
                System.out.println(a);
            });
        }
    }
}
