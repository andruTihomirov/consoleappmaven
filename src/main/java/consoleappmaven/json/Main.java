package consoleappmaven.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author atsikhamirau on 09.08.2018
 */
public class Main {

    public static void main(String[] args) {
        List<String> messages = new ArrayList<>();
        addUsersToListAsJSON(messages);
        System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(messages, ArrayList.class));
    }

    private static void addUsersToListAsJSON(List<String> list) {
        if (list == null) {
            throw new IllegalArgumentException("list can't be null.");
        }

        User user;
        for (int i = 0; i < 5; i++) {
            user = new User();
            user.setLogin("andru_" + i);
            user.setPassword("pa$$" + i);
            list.add(user.getAsJSONString());
        }
    }

}
class User {

    private String login;

    private String password;

    public String getAsJSONString() {
        return new Gson().toJson(this);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
