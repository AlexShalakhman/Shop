package task.Task.validation;

import task.Task.UI.EnumUI.ProductType;
import task.Task.exception.IllegalBalanceException;
import task.Task.exception.IllegalProductNameException;
import task.Task.exception.IllegalProductTypeException;

import java.io.*;
import java.nio.file.*;

import static task.Task.dao.ProductDao.addNewProductToFile;


public class ProductValidator {
    private static final Path DB_PATH = Paths.get("Task/DataBase/product_table.txt");

    public static boolean validateAddNewProductToFile(String productName, String productType, String productQuantity, String productPrice) {

        if (isProductNameUnique(productName) && validateProductType(productType) && validateProductQuantity(productQuantity) && validateProductPrice(productPrice)) {
            addNewProductToFile(productName, productType, productQuantity, productPrice);
            System.out.println("New product added successfully.");
            return true;
        } else {
            System.out.println("Failed to add new product.");
            return false;
        }

    }

    private static boolean validateProductPrice(String price) {
        double finalBalance = Double.parseDouble(price);
        try {
            if (finalBalance > 0) {
                return true;
            } else {
                throw new IllegalBalanceException("Price can`t be less then 1$");
            }
        }catch (NumberFormatException e){
            System.out.println("Input must be a valid number.");
            return false;
        } catch (IllegalBalanceException e) {
            e.printStackTrace();

        }
        return false;
    }
    private static boolean validateProductQuantity(String quantity) {
        int finalBalance = Integer.parseInt(quantity);
        try {
            if (finalBalance > 0) {
                return true;
            } else {
                System.out.println("Balance can not be 0.");
                throw new IllegalBalanceException("Product quantity can`t be less then 1.");
            }
        }catch (NumberFormatException e){
            System.out.println("Input must be a valid number.");
            return false;
        } catch (IllegalBalanceException e) {
            e.printStackTrace();

        }
        return false;
    }


    private static boolean validateProductType(String productType) {
        try {
            for (ProductType enumValue : ProductType.values()) {
                if (enumValue.getLabel().equalsIgnoreCase(productType)) {
                    return true;
                } else {
                }
            }
            throw new IllegalProductTypeException("Ths product type does not exist.");
        } catch (IllegalProductTypeException e){
            e.printStackTrace();
        }
        return false;
    }


    private static boolean isProductNameUnique(String productName)  {
        try (BufferedReader reader = Files.newBufferedReader(DB_PATH)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");

                if (columns.length >= 2 && columns[1].equals(productName)) {
                    throw new IllegalProductNameException("This product already exist.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalProductNameException e) {
            e.printStackTrace();
        }
        return true;
    }

}
