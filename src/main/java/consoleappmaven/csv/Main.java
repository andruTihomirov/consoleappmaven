package consoleappmaven.csv;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author atsikhamirau on 03.09.2018
 */
public class Main {

    public static void main(String[] args) throws Exception {
        InputStream inputStream = new FileInputStream("D:\\projects\\consoleappmaven\\src\\main\\java\\consoleappmaven\\csv\\import.csv");
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        System.out.println("Headers: " + reader.readLine());

        while(reader.ready()) {
            System.out.println(reader.readLine());
        }
    }

}
