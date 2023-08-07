package task.Task.UI;

import task.Task.UI.EnumUI.BasketCategories;
import task.Task.UI.EnumUI.MenuCategories;
import task.Task.dao.ProductDao;
import task.Task.UI.EnumUI.ProductType;
import task.Task.data.Client;
import task.Task.data.Product;
import task.Task.service.ShopManager;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class CategoriesUI {
    public void startCategoriesUI() {
        int number = 1;
        for (ProductType enumValue : ProductType.values()) {
            System.out.println(number++ + ") " + enumValue.getLabel());
        }
    }

    public void mainMenu(Client client, BufferedReader bufferedReader) throws IOException {
        if (client.getName() != null) {
        int totalNumberOfitems = 0;
        double totalprice = 0;
        System.out.printf("Hello, %s. What are you up to?", client.getName());
        boolean keepGoing = true;
                do {
                    System.out.println();
                    for (MenuCategories action : MenuCategories.values()) {
                        System.out.println(action.getCategoryNumber() + action.getCategories());
                    }
                    System.out.println();
                    System.out.print("Please, write number in order to choose option - ");
                    int choice = Integer.parseInt(bufferedReader.readLine());

                    if (choice == 0) {
                        System.out.println("Exiting the menu.");
                        keepGoing = false;
                    } else {
                        MenuCategories selectedAction = MenuCategories.getMainMenuCategoryByValue(choice);
                        if (selectedAction != null) {
                            switch (selectedAction) {
                                case MAIN_CATEGORIES:
                                    ProductType.getAllPrinted();
                                    System.out.print("Choose category you wish to expand - ");
                                    int categoryExpandCase = Integer.parseInt(bufferedReader.readLine());
                                    productCategoryExpand(categoryExpandCase);
                                    break;
                                case BASKET_MENU:
                                    basketCategories(client, bufferedReader);
                                case CHECKOUT:
                                    for (Map.Entry<Product, Integer> entry : client.getBasket().entrySet()) {
                                        totalprice += entry.getKey().getPrice();
                                        totalNumberOfitems += entry.getValue();
                                        System.out.println("Your total price to pay - " + totalprice + " for " + totalNumberOfitems + " items.");
                                        System.out.println("Your current balance - " + client.getBalance());
                                        System.out.println("Waiting for payment...");
                                    client.getShop().processPayment(client, client.getShop().performSale(client));
                                    }
                                    break;
                                case END_SESSION:
                                    System.out.println("Thank you for visiting our store! See ya later!");
                                    keepGoing = false;
                                    break;
                                default:
                                    System.out.println("Invalid choice. Please try again.");
                            }
                        }
                    }
                }while (keepGoing) ;
        }
    }


    public void productCategoryExpand(int categoryExpand) throws IOException {
        final Path DB_PATH = Paths.get("Task/DataBase/product_table.txt");
        ProductDao productDao = new ProductDao();
        System.out.println();
        switch (categoryExpand) {
            case 1:
                productDao.printProductsByType(ProductType.ALCOHOL);
                break;
            case 2:
                productDao.printProductsByType(ProductType.TOBACCO);
                break;
            case 3:
                productDao.printProductsByType(ProductType.MEAT);
                break;
            case 4:
                productDao.printProductsByType(ProductType.MILK_PRODUCTS);
                break;
            case 5:
                productDao.printProductsByType(ProductType.FISH);
                break;
            case 6:
                productDao.printProductsByType(ProductType.FRUIT);
                break;
            case 7:
                productDao.printProductsByType(ProductType.VEGETABLE);
                break;
            case 8:
                productDao.printProductsByType(ProductType.MACARONI);
                break;
            case 9:
                productDao.printProductsByType(ProductType.ELECTRONICS);
                break;
            case 10:
                productDao.printProductsByType(ProductType.CANS);
                break;
            case 11:
                productDao.printProductsByType(ProductType.KASHAS);
                break;
        }
    }

    public void basketCategories(Client client, BufferedReader reader) throws IOException {
        boolean keepGoing = true;
        int choice;
        double totalprice = 0;
        int totalNumberOfitems = 0;
            ProductDao productDao = new ProductDao();
            while (keepGoing) {
                System.out.println("Basket Menu:");
                for (BasketCategories action : BasketCategories.values()) {
                    System.out.println(action.getCategoryNumber() + action.getCategories());
                }

                System.out.print("Enter your choice: ");
                choice = Integer.parseInt(reader.readLine());

                    BasketCategories selectedAction = BasketCategories.getBasketCategoryByValue(choice);
                    if (selectedAction != null) {
                        switch (selectedAction) {
                            case ADD_ITEM_TO_BASKET:
                                System.out.print("Please write down what do you want to buy - ");
                                String nameProduct = reader.readLine();
                                System.out.print("Please specify how many items do you want to buy - ");
                                int amount = Integer.parseInt(reader.readLine());
                                Product product = productDao.findProductByName(nameProduct);
                                if (product != null) {
                                    boolean addedToBasket = client.addProductToBasket(product, amount);
                                    if (addedToBasket) {
                                        System.out.println("Item added successfully to the basket.");
                                    } else {
                                        System.out.println("Failed to add item to the basket.");
                                    }
                                } else {
                                    System.out.println("Product not found: " + nameProduct);
                                }
                                break;
                            case REMOVE_PRODUCT:
                                System.out.print("Please write down what do you want to remove from your basket - ");
                                String nameProductToReturn = reader.readLine();
                                System.out.println("Please specify how many items do you want to remove from basket - ");
                                int amountOFReturn = Integer.parseInt(reader.readLine());


                                Product productReturn = productDao.findProductByName(nameProductToReturn);
                                if (productReturn != null) {
                                    boolean removedFromBasket = client.addProductToBasket(productReturn, amountOFReturn);
                                    if (removedFromBasket) {
                                        System.out.println("Item removed successfully from the basket.");
                                    } else {
                                        System.out.println("Failed to remove item from the basket.");
                                    }
                                } else {
                                    System.out.println("Product not found: " + nameProductToReturn);
                                }
                                break;
                            case SHOW_BASKET:
                                System.out.println("Here is what you got in your basket - ");
                                if (client.getBasket().isEmpty()) {
                                    System.out.println("There is nothing in your basket yet...");
                                } else {
                                    for (Map.Entry<Product, Integer> entry : client.getBasket().entrySet()) {
                                        String item = "Product - " + entry.getKey() + " Amount of items - " + entry.getValue();
                                        System.out.println(item.replace("[", "").replace("]", ""));
                                        totalprice += entry.getKey().getPrice() * entry.getValue().intValue();
                                        totalNumberOfitems += entry.getValue().doubleValue();

                                    }
                                    System.out.println("Total price - " + totalprice + " Total amount of items - " + totalNumberOfitems);
                                }
                                break;
                            case EMPTY_BASKET:
                                System.out.println("We are emptying your bucket...");
                                if (client.getBasket().isEmpty() == true) {
                                    System.out.println("Your bucket is already empty!");
                                } else {
                                    client.getBasket().clear();
                                    if (client.getBasket().isEmpty() == true) {
                                        System.out.println("Your bucket is empty...");
                                    } else {
                                        System.out.println("Something went wrong...");
                                    }
                                }
                                break;
                            case CHECKOUT:
                                ShopManager shopManager = new ShopManager();
                                for (Map.Entry<Product, Integer> entry : client.getBasket().entrySet()) {
                                    totalprice += entry.getKey().getPrice();
                                    totalNumberOfitems += entry.getValue();
                                    System.out.println("Your total price to pay - " + totalprice + " for " + totalNumberOfitems + " items.");
                                    System.out.println("Your current balance - " + client.getBalance());
                                    System.out.println("Waiting for payment...");
                                    shopManager.finalizePayment(client, totalprice);
                                            if(shopManager.finalizePayment(client, totalprice) == true){
                                                System.out.println("You have successfully paid for your goods, have a nice day!");

                                    } else if (shopManager.finalizePayment(client, totalprice) == false){
                                                System.out.println("Oh, something went wrong, try again");
                                    }

                                }
                                break;
                            case BACK_TO_MAIN_MENU:
                                System.out.println("Moving back to main menu..");
                                keepGoing = false;
                                break;
                            default:
                                System.out.println("Invalid choice. Please try again.");
                        }
                    } else {
                        System.out.println("Invalid choice. Please try again.");
                    }
                }
            }
        }






