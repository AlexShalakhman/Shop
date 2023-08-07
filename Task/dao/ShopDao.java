package task.Task.dao;

import task.Task.data.Client;
import task.Task.data.Product;
import task.Task.data.Shop;

import java.io.*;
import java.nio.file.Path;
import java.util.*;

public class ShopDao {
    private static final Path DB_PATH = Path.of("Task/DataBase/shop.txt");

    public static Map<Product, Integer> readProductFromClientBasketAndReturnNewBasket() {
        Map<Product, Integer> productData = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(DB_PATH.toFile()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");

                for (int i = 2; i < columns.length; i += 2) {
                    if (i + 1 < columns.length) {
                        String productName = columns[i].trim();
                        Product product = ProductDao.findProductByName(productName);
                        int quantity = Integer.parseInt(columns[i + 1].trim());
                        productData.put(product, quantity);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return productData;
    }

    public static String readShopName() {
        try (BufferedReader reader = new BufferedReader(new FileReader(DB_PATH.toFile()))) {
            String line;
            if ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");
                if (columns.length > 0) {
                    return columns[0].trim();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public double readShopBalance() {
        try (BufferedReader reader = new BufferedReader(new FileReader(DB_PATH.toFile()))) {
            String line;
            if ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");
                if (columns.length > 1) {
                    return Double.parseDouble(columns[1].trim());
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return 0.0;
    }

    public void getMoney(double totalPrice) {
        try (BufferedReader reader = new BufferedReader(new FileReader(DB_PATH.toFile()))) {
            String line = reader.readLine();
            if (line != null) {
                String[] columns = line.split(",");
                if (columns.length > 1) {
                    double currentBalance = Double.parseDouble(columns[1].trim());
                    double newBalance = currentBalance + totalPrice;

                    columns[1] = Double.toString(newBalance);
                    String updatedLine = String.join(",", columns);

                    try (FileWriter writer = new FileWriter(DB_PATH.toFile())) {
                        writer.write(updatedLine);
                        writer.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public Shop initializeShop(){
        Double balance = readShopBalance();
        String name = readShopName();
        return new Shop(name, balance);
    }



}


