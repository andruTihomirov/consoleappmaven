package consoleappmaven.streams;

import java.util.stream.Stream;

/**
 * @author atsikhamirau on 23.08.2018
 */
public class Main {

    public static void main(String[] args) {
        User user0 = new User();
        user0.setLogin("andru_0");
        user0.setPassword("pa$$_0");

        User user1 = new User();
        user1.setLogin("andru_1");
        user1.setPassword("pa$$_1");

        Stream<User> stream = Stream.of(user0, user1);

        stream = stream.peek(u -> u.setLogin("0"));

        stream.forEach(System.out::println);

    }

}
