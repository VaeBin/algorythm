package cn.hbb.concurrent.thread;

import java.util.concurrent.Semaphore;

public class OddEvenPrint1 {

    private static final int LIMIT = 100;
    private static Semaphore oddSemaphore = new Semaphore(1);
    private static Semaphore evenSemaphore = new Semaphore(0);

    public static void main(String[] args) {
        Thread oddThread = new Thread(new OddTask());
        Thread evenThread = new Thread(new EvenTask());

        oddThread.start();
        evenThread.start();
    }

    static class OddTask implements Runnable {
        @Override
        public void run() {
            try {
                for (int i = 1; i <= LIMIT; i += 2) {
                    oddSemaphore.acquire();
                    System.out.println("Odd: " + i);
                    evenSemaphore.release();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    static class EvenTask implements Runnable {
        @Override
        public void run() {
            try {
                for (int i = 2; i <= LIMIT; i += 2) {
                    evenSemaphore.acquire();
                    System.out.println("Even: " + i);
                    oddSemaphore.release();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
