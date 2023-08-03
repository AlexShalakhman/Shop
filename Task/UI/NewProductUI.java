package task.Task.UI;

import task.Task.validation.ProductValidator;
import task.Task.validation.RegistrationValidator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NewProductUI {
    public static void startAddNewProduct()  {
        CategoriesUI categoriesUI = new CategoriesUI();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("   Addition of new Products   ");
            System.out.println("How many products would you like to add to the database?");
            String numberOfProducts = bufferedReader.readLine();

            for (int i = 0; i < Integer.parseInt(numberOfProducts); i++) {
                System.out.println();
                System.out.println("Please fulfill all of the following fields to add new product:");

                System.out.print("Product Name: ");
                String productName = bufferedReader.readLine();

                System.out.println("Product Type: ");
                categoriesUI.startCategoriesUI();
                System.out.print("Please type category you want your product refer to: ");
                String productType = bufferedReader.readLine();

                System.out.print("Product Price: ");
                String productPrice = bufferedReader.readLine();

                System.out.print("Product Quantity: ");
                String productQuantity = bufferedReader.readLine();

                ProductValidator.validateAddNewProductToFile(productName, productType, productQuantity, productPrice);
            }


        } catch (IOException ioException) {
            System.out.println("An error occurred while processing your input. Please try again.");
            ioException.printStackTrace();
        }
    }
}
