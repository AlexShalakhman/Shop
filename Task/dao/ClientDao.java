package task.Task.dao;


import task.Task.data.Client;
import task.Task.data.Product;
import task.Task.validation.LoginizationValidator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class ClientDao {
    private static final Path DB_PATH = Paths.get("Task/DataBase/client_table.txt");
    private final ProductDao productDao = new ProductDao();

    public void save(Client client){

    }
    public static String[] findClientById(String clientId) {
        try (BufferedReader reader = new BufferedReader(new FileReader(DB_PATH.toFile()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lineValues = line.split(",");
                if (lineValues[0].equals(clientId)) {
                    return new String[]{lineValues[1], lineValues[2]};
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public Integer findId(Long id){
        try(BufferedReader reader = new BufferedReader(new FileReader(DB_PATH.toFile()))) {
            String s = "2, Some Name2, 2000.0,Apple,Beer,Vodka";
            String[] split = s.split(",");
            Client client;
            for (int i = 3; i < split.length; i++) {
                String productName = split[i];
       //         client.addProduct(productDao.findByName(productName));
            }
     //       return client;

        } catch (IOException ioException){
            ioException.printStackTrace();
        }
          return null;
    }

    public void update(Client client){

    }
    public static Long findClientIdByLoginData(String login, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader(DB_PATH.toFile()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lineValues = line.split(",");
                if (lineValues[1].equals(login) && lineValues[2].equals(password)) {
                    return Long.parseLong(lineValues[0]); // Assuming first name is in the third column (index 2)
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String findClientNameByLoginData(String login, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader(DB_PATH.toFile()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lineValues = line.split(",");
                if (lineValues[1].equals(login) && lineValues[2].equals(password)) {
                    return lineValues[3] + " " + lineValues[4]; // Assuming first name is in the third column (index 2)
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String findClientFirstNameByLoginData(String login, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader(DB_PATH.toFile()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lineValues = line.split(",");
                if (lineValues[1].equals(login) && lineValues[2].equals(password)) {
                    return lineValues[3] + " " + lineValues[4]; // Assuming first name is in the third column (index 2)
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String findClientLastNameByLoginData(String login, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader(DB_PATH.toFile()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lineValues = line.split(",");
                if (LoginizationValidator.validateUser(login, password)) {
                    return lineValues[4];
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Double findClientBalanceByLoginData(String login, String password ) {
            try (BufferedReader reader = new BufferedReader(new FileReader(DB_PATH.toFile()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] lineValues = line.split(",");
                    if (LoginizationValidator.validateUser(login, password)) {
                        return Double.parseDouble(lineValues[5]); // Assuming first name is in the third column (index 2)
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
    }
    public static Map<Product, Integer> findClientBasketByLogin(String clientLogin) {
        try (BufferedReader reader = new BufferedReader(new FileReader(DB_PATH.toFile()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lineValues = line.split(",");
                if (lineValues[3].equals(clientLogin)) {
                    Map<Product, Integer> basket = new HashMap<>();
                    for (int i = 5; i < lineValues.length; i += 2) {
                        String productString =  lineValues[i].trim();
                    //    Product product = productString;
                        int quantity = Integer.parseInt(lineValues[i + 1].trim());
                  //      basket.put(product, quantity);
                    }
                    return basket;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Client initializeClient(String login, String password){
        final Long id = findClientIdByLoginData(login, password);
        String name = findClientNameByLoginData(login, password);
        double balance = ClientDao.findClientBalanceByLoginData(login, password);

        return new Client(id, name, balance);
    }

}
