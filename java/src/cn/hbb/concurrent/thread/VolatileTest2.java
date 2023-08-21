package cn.hbb.concurrent.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//public class VolatileTest2 implements Runnable {
//    private volatile int i = 0;
//    @Override
//    public void run() {
//        for (int j=0;j<1000;j++) {
//            i++;
//        }
//    }
//    public int getI() {
//        return i;
//    }
//
//    public static void main(String[] args) throws InterruptedException {
//        VolatileTest2 v2 = new VolatileTest2();
//        for (int i=0;i<100;i++){
//            new Thread(v2).start();
//        }
//        Thread.sleep(5000);
//        System.out.println(v2.getI());
//    }
//}
public class VolatileTest2 {

    private static boolean flag = true;
    private static volatile int i = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            int j;
            while (flag) {
                j=i;
            }
            System.out.print("i: "+i+",");

        });

        t1.start();
        Thread.sleep(10);
        flag = false;
        i++;
        System.out.println("主线程将flag改为false");
    }
}