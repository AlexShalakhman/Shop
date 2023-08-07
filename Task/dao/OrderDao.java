package task.Task.dao;
import task.Task.data.Order;
import task.Task.data.Product;

import java.io.*;
import java.util.*;

public class OrderDao {
    private static final String ORDER_PATH = "order_table.txt";

    public int getNewOrderID()  {
        int newOrderID = 0;
            int lastOrderID = getLastOrderID();
             newOrderID = lastOrderID + 1;
        return newOrderID;
    }

    public void writeBasketToFile( Map<Product, Integer> basket) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ORDER_PATH))) {
            int orderID = getLastOrderID() + 1;
            for (Map.Entry<Product, Integer> entry : basket.entrySet()) {
                Product product = entry.getKey();
                Integer quantity = entry.getValue();

                String line = orderID + "," + product.getName() + "," + quantity;
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getLastOrderID()   {
        int lastOrderID = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(ORDER_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                int orderID = Integer.parseInt(line.trim());
                lastOrderID = Math.max(lastOrderID, orderID);
            }
        } catch (FileNotFoundException ignored) {
            ignored.printStackTrace();
        } catch (IOException ioException){
            ioException.printStackTrace();
        }

        return lastOrderID;
    }


}
