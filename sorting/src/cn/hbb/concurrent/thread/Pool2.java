package cn.hbb.concurrent.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Pool2 {

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 1; i <= 200; i++) {
            final int j = i;
            executorService.execute(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ":" + j);
            });
        }
    }
}
