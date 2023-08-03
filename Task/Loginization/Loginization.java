package task.Task.Loginization;

import task.Task.dao.ClientDao;
import task.Task.data.Client;
import task.Task.validation.LoginizationValidator;

import java.nio.file.Path;

public class Loginization {

    public Client login(String login, String password) {
        boolean loop = false;
        LoginizationValidator loginizationValidator = new LoginizationValidator();
        ClientDao clientDao = new ClientDao();
            try {
                while(!loop) {

                    if (loginizationValidator.validateUser(login, password)) {
                        Client client = clientDao.initializeClient(login, password);
                        loop = true;
                        return client;
                    } else {
                        loop = true;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;

    }

}
