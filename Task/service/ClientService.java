package task.Task.service;

import task.Task.dao.ClientDao;
import task.Task.data.Client;
import task.Task.exception.IllegalBalanceException;
import task.Task.validation.ClientValidator;

public class ClientService {
    ClientValidator clientValidator = new ClientValidator();
    ClientDao clientDao = new ClientDao();
    public void save(Client client) throws IllegalBalanceException {
        clientValidator.validateBalance(client.getBalance());
        clientDao.save(client);
    }


}
