package task.Task;

import java.util.Map;
import java.util.Scanner;

public class UI {

    public static void start() {
        Warehouse warehouse = new Warehouse();
        ShopManager.storageFulfill(warehouse);
        Shop shop = new Shop(warehouse, 900000);
        Client client;
        double totalprice = 0;
        int totalNumberOfitems = 0;

        try (Scanner scanner = new Scanner(System.in)) {
            String customerName;

            while (true) {
                System.out.print("Welcome to the shop, Dear Customer. Please write down your name here - ");
                customerName = scanner.nextLine();

                try {
                    char firstChar = customerName.charAt(0);
                    if (Character.isUpperCase(firstChar)) {
                        System.out.println("Input is valid.");
                        break;
                    } else {
                        throw new IllegalArgumentException("Input must start with a capital letter.");
                    }
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Input string is empty.");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }

            double balance;
            do {
                System.out.print("Please write how much money would you like to spend today - ");
                balance = scanner.nextDouble();
                if (balance < 0) {
                    System.out.println("Invalid balance. Please enter a non-negative amount.");
                }
            } while (balance < 0);

        client = new Client(customerName, balance, shop);
            System.out.printf("Alright %s, let's get started with our main menu - %n", client.getName());
            boolean keepGoing = true;
            do {
                mainMenu();
                int category = scanner.nextInt();
                scanner.nextLine();

                switch (category) {
                    case 1:
                        ProductType.getAllPrinted();
                        System.out.print("Choose category you wish to expand - ");
                        int categoryExpandCase = scanner.nextInt();
                        categoryExpand(categoryExpandCase, warehouse);
                        break;

                    case 2:
                        System.out.print("Please write down what do you want to buy - ");
                        String nameProduct = scanner.nextLine();
                        System.out.print("Please specify how many items do you want to buy - ");
                        int amount = scanner.nextInt();

                        scanner.nextLine();

                        Product product = Client.findProductByName(nameProduct, client);
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

                    case 3:
                        System.out.print("Please write down what do you want to remove from your basket - ");
                        String nameProductToReturn = scanner.nextLine();
                        System.out.println("Please specify how many items do you want to remove from basket - ");
                        int amountOFReturn = scanner.nextInt();

                        scanner.nextLine();

                        Product productReturn = Client.findProductByName(nameProductToReturn, client);
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

                    case 4:
                        System.out.println("Here is what you got in your basket - ");
                        if(client.getBasket().isEmpty()){
                            System.out.println("There is nothing in your basket yet...");
                        } else {

                            for (Map.Entry<Product, Integer> entry : client.getBasket().entrySet()) {
                                String item = "Product - " + entry.getKey() + " Amount of items - " + entry.getValue();
                                System.out.println(item.replace("[", "").replace("]", ""));
                                totalprice += entry.getKey().getPrice()* entry.getValue().intValue();
                                totalNumberOfitems += entry.getValue().doubleValue();

                            }
                            System.out.println("Total price - " + totalprice + " Total amount of items - " + totalNumberOfitems);
                        }
                        break;

                    case  5:
                        System.out.println("We are emptying your bucket...");
                        if(client.getBasket().isEmpty() == true){
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

                    case 6:
                        for (Map.Entry<Product, Integer> entry : client.getBasket().entrySet()) {
                            totalprice += entry.getKey().getPrice();
                            totalNumberOfitems += entry.getValue();
                            System.out.println("Your total price to pay - " + totalprice  + " for " + totalNumberOfitems + " items.");
                            System.out.println("Your current balance - " + client.getBalance());
                            System.out.println("Waiting for payment...");
                            client.getShop().processPayment(client, client.getShop().performSale(client));


                        }
                        break;

                    case 7:
                        System.out.println("Thank you for visiting our store! See ya later!");
                        keepGoing = false;
                        break;
                }
            } while (keepGoing);

        } catch (Exception e) {
            System.out.println("Something went wrong.");
            e.printStackTrace();
        }
    }


    public static void mainMenu(){

            System.out.println(MenuCategories.MAIN_CATEGORIES);
            System.out.println(MenuCategories.ADD_ITEM_TO_BASKET);
            System.out.println(MenuCategories.REMOVE_PRODUCT);
            System.out.println(MenuCategories.SHOW_BASKET);
        System.out.println(MenuCategories.EMPTY_BASKET);
            System.out.println(MenuCategories.BUY_PRODUCTS);
            System.out.println(MenuCategories.END_SESSION);
            System.out.print("Please, write number in order to choose option - ");

    }

    public static void categoryExpand(int categoryExpand, Warehouse warehouse){
        System.out.println();
        switch (categoryExpand) {
            case 1:
                warehouse.showProductByType(ProductType.ALCOHOL);
                break;
            case  2:
                warehouse.showProductByType(ProductType.TOBACCO);
                break;
            case 3:
                warehouse.showProductByType(ProductType.MEAT);
                break;
            case 4:
                warehouse.showProductByType(ProductType.MILK_PRODUCTS);
                break;
            case 5:
                warehouse.showProductByType(ProductType.FISH);
                break;
            case 6:
                warehouse.showProductByType(ProductType.FRUIT);
                break;
            case 7:
                warehouse.showProductByType(ProductType.VEGETABLE);
                break;
            case 8:
                warehouse.showProductByType(ProductType.MACARONI);
                break;
            case 9:
                warehouse.showProductByType(ProductType.ELECTRONICS);
                break;
            case 10:
                warehouse.showProductByType(ProductType.CANS);
                break;
            case 11:
                warehouse.showProductByType(ProductType.KASHAS);
                break;
        }
        System.out.println();
    }


}
