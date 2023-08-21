package cn.hbb.concurrent.thread;

public class ThreadLocalTest {


    private static ThreadLocal tl1 = new ThreadLocal();
    private static ThreadLocal tl2 = new ThreadLocal();

    public static void main(String[] args) {
        System.out.println(tl1==tl2);
        tl1.set("123");
        tl2.set("456");


        System.out.println("main:" +tl1.get());
    }
}
