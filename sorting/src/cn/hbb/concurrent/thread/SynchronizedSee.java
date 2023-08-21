package cn.hbb.concurrent.thread;

public class SynchronizedSee {
    private static boolean flag = true;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while (flag) {
//                synchronized (SynchronizedSee.class){
//                    //...
//                }
                System.out.println(111);
            }
            System.out.println("t1线程结束");

        });

        t1.start();
        Thread.sleep(10);
        flag = false;
        System.out.println("主线程将flag改为false");
    }
}
