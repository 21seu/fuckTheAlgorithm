package part03_juc;

/**
 * 交替打印解法2
 */
public class LC_1114PrintInOrder2 {

    private boolean first;
    private boolean second;
    private Object lock = new Object();

    public LC_1114PrintInOrder2() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        synchronized(lock) {
            printFirst.run();
            this.first = true;
            lock.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        synchronized(lock) {
            while (!this.first) lock.wait();
            printSecond.run();
            this.second = true;
            lock.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        synchronized(lock) {
            while (!this.second) lock.wait();
            printThird.run();
        }
    }
}
