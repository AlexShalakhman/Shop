package task.Task.Loginization;

import task.Task.dao.ClientDao;
import task.Task.data.Client;
import task.Task.validation.LoginizationValidator;

import java.nio.file.Path;

public class Loginization {

    public static Client login(String login, String password) {
        boolean loop = false;
            try {
                while(!loop) {

                    if (LoginizationValidator.validateUser(login, password)) {
                        Client client = ClientDao.initializeClient(login, password);
                        System.out.println("You have successfully logged in!");
                        System.out.println("Hello, " + ClientDao.findClientFirstNameByLoginData(login, password) + "! What would you like to do today?");
                        loop = true;
                        return client;
                    } else {
                        loop = true;
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Wrong login or password. Please try again.");
            return null;

    }

}
