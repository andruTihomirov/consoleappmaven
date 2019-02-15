package consoleappmaven.threadlocal;

import java.util.ArrayList;
import java.util.List;

/**
 * @author atsikhamirau on 10.08.2018
 */
public class ThreadLocalExample {

    private ThreadLocal<List<String>> local = new ThreadLocal<>();

    private List<String> messages = new ArrayList<>();

    public void checkFromThread_1() {
        new Thread(() -> {
            List<String> list = new ArrayList<>();
            local.set(list);
            list.add("1");
            list.add("2");
            list.add("3");

            System.out.println("Thread local list 1:" + local.get());

            messages.add("1");
            messages.add("2");
            messages.add("3");

            System.out.println("Messages list 1:" + messages);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();
    }

    public void checkFromThread_2() {
        new Thread(() -> {
            System.out.println("Thread local list 2:" + local.get());
            System.out.println("Messages list 2:" + messages);
        }).start();
    }

    public ThreadLocal<List<String>> getLocal() {
        return local;
    }
}
