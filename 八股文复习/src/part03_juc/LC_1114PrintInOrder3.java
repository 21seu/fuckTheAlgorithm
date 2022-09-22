package part03_juc;

/**
 * 交替打印解法3
 */
public class LC_1114PrintInOrder3 {

    private volatile int count;

    public LC_1114PrintInOrder3() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        count++;
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        while (count != 2){};
        printSecond.run();
        count++;
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        while (count != 3){};
        printThird.run();
    }
}
