package task.Task.UI;

import task.Task.Loginization.Loginization;
import task.Task.dao.ClientDao;
import task.Task.data.Client;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class LoginizationUI {

    public static Client startLoginization(BufferedReader bufferedReader) throws IOException {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Client client;
        boolean loop;
        System.out.println("   Login to the Shop   ");
do {
    System.out.print("Login: ");
    String login = bufferedReader.readLine();
    System.out.print("Password: ");
    String password = bufferedReader.readLine();

    if (login != null && password != null) {
        client = Loginization.login(login, password);
        loop = false;
        return client;
    } else {
        System.out.println("Failed to login.");
        return null;
    }
} while (!loop);

    }

}