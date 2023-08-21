package cn.hbb.concurrent.thread;

public class CreateThread {
    public static void main(String[] args) {
        MyRun myRun = new MyRun();
        Thread t1 = new Thread(myRun);
        t1.start();

        // 最好匿名内部类和lambda
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<100;i++)
                    System.out.println("匿名内部类 "+i);
            }
        });
        t2.start();

        Thread t3 = new Thread(()-> {
                for (int i=0;i<100;i++)
                    System.out.println("lambda "+i);
        });
        t3.start();

        // 主程序
        for (int i=0;i<100;i++)
            System.out.println("main "+i);

    }


}

class MyJob extends Thread{
    @Override
    public void run() {
        for (int i=0;i<100;i++)
            System.out.println("myjob "+i);
    }
}

class MyRun implements Runnable{
    @Override
    public void run() {
        for (int i=0;i<100;i++)
            System.out.println("myrun "+i);
    }
}
