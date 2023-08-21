package cn.hbb.concurrent.thread;


// 两个线程交替打印0~100的奇偶数
public class OddEvenPrint {


        private static final int LIMIT = 100;
        private static int number = 0;
        private static final Object lock = new Object();

        public static void main(String[] args) {
            Thread oddThread = new Thread(new OddTask());
            Thread evenThread = new Thread(new EvenTask());

            oddThread.start();
            evenThread.start();
        }

        static class OddTask implements Runnable {
            @Override
            public void run() {
                while (number <= LIMIT) {
                    synchronized (lock) {
                        if (number % 2 == 1) {
                            System.out.println("Odd: " + number);
                            number++;
                            lock.notify();
                        } else {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }

        static class EvenTask implements Runnable {
            @Override
            public void run() {
                while (number <= LIMIT) {
                    synchronized (lock) {
                        if (number % 2 == 0) {
                            System.out.println("Even: " + number);
                            number++;
                            lock.notify();
                        } else {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }

