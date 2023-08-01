package task.Task.dao;

import task.Task.data.Client;
import task.Task.data.Product;
import task.Task.data.ProductDescription;
import task.Task.data.ProductType;

import java.io.*;
import java.nio.file.Path;
import java.util.*;

public class ShopDao {
    private static final Path DB_PATH = Path.of("Task/DataBase/order_table.txt");

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







}


