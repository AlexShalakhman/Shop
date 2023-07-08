package task.Task;

import java.util.Scanner;

public class UI {

    public static void start(){
        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop(warehouse, 900000);
        ShopManager.storageFulfill(warehouse);
        Client client;
        System.out.print("Welcome to the shop, Dear Customer. Please write down your name here - ");

        try(Scanner scanner = new Scanner(System.in)) {
            String customerName = scanner.nextLine();
            System.out.print("Please write how much money would you like to spend today - ");
            double balance = scanner.nextDouble();
            client = new Client(customerName, balance, shop);
            System.out.printf("Alright %s, let's get started with our main menu - \n", client.getName());
            boolean keepGoing = true;
            do{
            mainMenu();
            int category = scanner.nextInt();

            switch (category) {
                case 1:
                    ProductType.getAllPrinted();
                    System.out.println("Choose category you wish to expand - ");
                    int categoryExpand = scanner.nextInt();
                    switch (categoryExpand) {
                        case 1:
                           warehouse.showProductByType(ProductType.ALCOHOL);
                           break;
                        case  2:
                            warehouse.showProductByType(ProductType.TOBACCO);
                        case 3:
                            warehouse.showProductByType(ProductType.MEAT);
                        case 4:
                            warehouse.showProductByType(ProductType.MILK_PRODUCTS);
                        case 5:
                            warehouse.showProductByType(ProductType.FISH);
                        case 6:
                            warehouse.showProductByType(ProductType.FRUIT);
                        case 7:
                            warehouse.showProductByType(ProductType.VEGETABLE);
                        case 8:
                            warehouse.showProductByType(ProductType.MACARONI);
                        case 9:
                            warehouse.showProductByType(ProductType.ELECTRONICS);
                        case 10:
                            warehouse.showProductByType(ProductType.CANS);
                        case 11:
                            warehouse.showProductByType(ProductType.KASHAS);
                        }
                        break;

                case 2:
                    System.out.println("Please write down what do you want to buy - ");
                    Object nameProduct = scanner.nextLine();
                    Product productName = (Product) nameProduct;

                    System.out.println("Please specify how many items do you want to buy - ");
                    int amount = scanner.nextInt();
                    client.addProductToBucket(productName, amount);
                    break;

                case 3:

                    break;

                case 4:

                    break;

                case 5:

                    break;

                case 6:
                    keepGoing = false;
                    break;
            }
        }while (keepGoing == true);
            } catch(Exception e){
                System.out.println("Something wrong");
            }
        }


    public static void mainMenu(){

            System.out.println(MenuCategories.MAIN_CATEGORIES);
            System.out.println(MenuCategories.ADD_ITEM_TO_BASKET);
            System.out.println(MenuCategories.REMOVE_PRODUCT);
            System.out.println(MenuCategories.SHOW_BASKET);
            System.out.println(MenuCategories.BUY_PRODUCTS);
            System.out.println(MenuCategories.END_SESSION);
            System.out.print("Please, write number in order to choose option - ");

    }


    public static void main(String[] args) {
        start();
    }
}
