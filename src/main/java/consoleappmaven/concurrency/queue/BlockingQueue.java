package consoleappmaven.concurrency.queue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author atsikhamirau on 14.02.2019
 */
public class BlockingQueue {


    private static final int DEFAULT_QUEUE_SIZE = 5;

    private Object[] values = new Object[DEFAULT_QUEUE_SIZE];

    private int putIndex;

    private int takeIndex;

    private int count;

    private Lock lock = new ReentrantLock();

    private Condition produce = lock.newCondition();

    private Condition consume = lock.newCondition();

    public void put(Object object) throws InterruptedException {
        lock.lock();

        try {
            while (count == values.length) {
                produce.await();
            }

            values[putIndex] = object;
            putIndex++;

            if (putIndex == values.length) {
                putIndex = 0;
            }

            count++;

            consume.signal();

        } finally {
            lock.unlock();
        }
    }

    public Object take() throws InterruptedException {
        lock.lock();

        try {

            while (count == 0) {
                consume.await();
            }

            Object object = values[takeIndex];
            takeIndex++;

            if (takeIndex == values.length) {
                takeIndex = 0;
            }

            count--;
            produce.signal();

            return object;

        } finally {
            lock.unlock();
        }
    }

}
