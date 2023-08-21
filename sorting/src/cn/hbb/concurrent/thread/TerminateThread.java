package cn.hbb.concurrent.thread;

public class TerminateThread {


    public static void main(String[] args) {


        Thread thread = Thread.currentThread();
        System.out.println(thread.isInterrupted());
    }

    public static synchronized void sync()  {
        try {
            for (int i = 0; i < 10; i++) {
                if(i == 5) {
                    TerminateThread.class.wait();
                }
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
