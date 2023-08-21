package cn.hbb.concurrent.thread;


// 模拟两个线程死锁
public class DeadLock {
    public static Integer a = new Integer(2);
    public static Integer b = new Integer(10);

    public static void main(String[] args) {
        new Thread(()->{
            synchronized (a){
                try {
                    System.out.println(Thread.currentThread()+ "get a");
                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (b){
                    System.out.println(Thread.currentThread()+" get b");
                }
            }
        }).start();

        new Thread(()->{
            synchronized (b){
                try {
                    System.out.println(Thread.currentThread()+ "get b");
                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (a){
                    System.out.println(Thread.currentThread()+" get a");
                }
            }
        }).start();

    }

}
