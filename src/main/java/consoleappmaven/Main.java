package consoleappmaven;


import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author atsikhamirau on 03.09.2018
 */
public class Main {

    public static void main(String[] args) {

        PriorityQueue<Integer> queue = new PriorityQueue<>((i1, i2)-> i2 - i1);

        queue.add(1);
        queue.add(6);
        queue.add(2);
        queue.add(7);
        queue.add(8);
        queue.add(0);

        System.out.println(queue.peek());
        System.out.println(queue.contains(0));

    }

}
