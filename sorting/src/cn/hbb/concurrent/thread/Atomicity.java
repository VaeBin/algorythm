package cn.hbb.concurrent.thread;

import java.util.concurrent.locks.ReentrantLock;

public class Atomicity {


    private static ReentrantLock lock = new ReentrantLock();
    static class Iner{
        private static Integer count = 0;
        private static int count1;

    }


    public static void increament(){
        synchronized (Iner.class){
            Iner.count++;
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Iner.count1++;
    }

    public static void increament1(){
        lock.lock();
        Iner.count++;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
        Iner.count1++;
    }


    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                increament();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                increament();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(Iner.count);
        System.out.println(Iner.count1);
    }


}
