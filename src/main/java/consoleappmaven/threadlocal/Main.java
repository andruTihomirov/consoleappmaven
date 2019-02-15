package consoleappmaven.threadlocal;

/**
 * @author atsikhamirau on 10.08.2018
 */
public class Main {

    public static void main(String[] args) {
        ThreadLocalExample threadLocalExample = new ThreadLocalExample();
        threadLocalExample.checkFromThread_1();
        threadLocalExample.checkFromThread_2();
    }

}
