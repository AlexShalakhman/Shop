package task.Task.UI;

import task.Task.Loginization.Loginization;
import task.Task.dao.ClientDao;
import task.Task.data.Client;
import task.Task.validation.LoginizationValidator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class LoginizationUI {

    public Client startLoginization(BufferedReader bufferedReader) {
        try {
            ClientDao clientDao = new ClientDao();
            LoginizationValidator loginizationValidator = new LoginizationValidator();
            Loginization loginization = new Loginization();
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
                    client = loginization.login(login, password);
                    loop = false;
                    boolean successfulLogin = loginizationValidator.validateUser(login, password);
                    if (successfulLogin == true){
                        System.out.println("You have successfully logged in!");
                        System.out.println("Hello, " + clientDao.findClientFirstNameByLoginData(login, password) + "! What would you like to do today?");
                    }
                    return client;
                } else {
                    System.out.println("Failed to login.");
                    return null;
                }

            } while (!loop);

        } catch (IOException ioException) {
            System.out.println("IOException");        }
        return null;
    }



}