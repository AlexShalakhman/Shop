package task.Task.UI;

import task.Task.OldClasses.Warehouse;
import task.Task.data.Client;
import task.Task.data.ProductType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class UI {

    public static void start()  {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String customer;
            Client client = null;

            System.out.println("Welcome to the shop, Dear Customer!");
            System.out.println("Are you an existing customer? Yes/No");
            customer = bufferedReader.readLine();

            switch (customer.toLowerCase()) {
                case "yes":

                    client = LoginizationUI.startLoginization(bufferedReader);
                    break;
                case "no":
                    RegistrationUI.startRegistration(bufferedReader);
                    break;
            }

            if (customer.equalsIgnoreCase("no")) {
                LoginizationUI.startLoginization(bufferedReader);
            }

            if (client != null) {
                System.out.println("");
            }
        } catch (IOException io){
            System.out.println("Something wrong");
        }
    }


/*
                System.out.printf("Hello, %s", client.getName());
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
                            //           categoryExpand(categoryExpandCase, warehouse);
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

                        case 5:
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

                        case 6:
                            for (Map.Entry<Product, Integer> entry : client.getBasket().entrySet()) {
                                totalprice += entry.getKey().getPrice();
                                totalNumberOfitems += entry.getValue();
                                System.out.println("Your total price to pay - " + totalprice + " for " + totalNumberOfitems + " items.");
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

            } catch(Exception e){
                System.out.println("Something went wrong.");
                e.printStackTrace();
            }
        } catch (IOException e) {
            throw new IOException(e);
        }

 */
        /* catch(IOException io){
            io.printStackTrace();        }
    }*/






}
