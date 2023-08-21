package cn.hbb.concurrent.thread;

public class UseThread {
    public static void main(String[] args) throws InterruptedException {
//        Thread t1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for(int i = 0;i<100;i++){
//                    if (i==50)
//                        Thread.yield();
//                    System.out.println("t1:"+i);
//                }
//            }
//        });
//        t1.setName("累加");
//        t1.setPriority(10);
//        t1.start();
//        t1.join();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0;i<10;i++){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("t1:"+i);
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0;i<10;i++){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("t2:"+i);
                }
            }
        });
        t1.start();
        t2.start();
        for(int i = 0;i<10;i++) {
            if (i==5)
                t1.join();


            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("main:" + i);
        }



    }



}
