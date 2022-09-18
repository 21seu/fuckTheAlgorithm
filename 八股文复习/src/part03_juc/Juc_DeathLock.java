package part03_juc;

/**
 * Created by fengtj on 2022/9/17 14:42
 */
public class Juc_DeathLock {

    private static Object resource01 = new Object();
    private static Object resource02 = new Object();

    public static void main(String[] args) {
        new Thread(()->{
            synchronized (resource01) {
                System.out.println(Thread.currentThread() + "get resource01");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting get resource02");
                synchronized (resource02) {
                    System.out.println(Thread.currentThread() + "get resource02");
                }
            }
        },"线程1").start();

        /**
         * 这样导致死锁
         */
//        new Thread(()->{
//            synchronized (resource02) {
//                System.out.println(Thread.currentThread() + "get resource02");
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(Thread.currentThread() + "waiting get resource01");
//                synchronized (resource01) {
//                    System.out.println(Thread.currentThread() + "get resource01");
//                }
//            }
//        },"线程2").start();

        /**
         * 解决死锁
         */
        new Thread(() -> {
            synchronized (resource01) {
                System.out.println(Thread.currentThread() + "get resource01");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting get resource02");
                synchronized (resource02) {
                    System.out.println(Thread.currentThread() + "get resource02");
                }
            }
        }, "线程 2").start();
    }
}
