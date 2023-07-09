package task.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Shop {
    private Casher cashers;
    private Warehouse warehouse;
    private double bank;

    public Casher getCashers() {
        return cashers;
    }

    public Shop(Warehouse warehouse, double bank) {
        this.warehouse = warehouse;
        this.bank = bank;
        this.cashers = new Casher("Cashier", 10);
    }

    public double performSale(Client client) {
        double price = 0.0;
        for (Map.Entry<Product, Integer> entry : client.getBasket().entrySet()) {
            price += entry.getKey().getPrice()* entry.getValue().intValue();
        }
        double scannedPrice = client.getShop().cashers.scanProduct(client);
        if (price == scannedPrice) {
            return price;
        } else {
            throw new RuntimeException("Price mismatch. Expected: " + price + ", Scanned: " + scannedPrice);
        }
    }

    public void processPayment(Client client, double totalPrice) {
        if(client.payForProducts(totalPrice) == true) {
            bank += totalPrice;
            System.out.println("You have successfully paid for your goods, have a nice day!");
        } if(client.payForProducts(totalPrice) == false) {
            System.out.println("Oh, something went wrong, try again");
        }
    }
    public void findGoods(String productName, Warehouse warehouse){
        // найти товар в магазине
        warehouse.getProductMap().containsValue(productName);
    }

    public void checkQuantity(Product product, Warehouse warehouse){
        for(Map.Entry<Product, Integer> entry: warehouse.getProductMap().entrySet()) {
            if(entry.getValue().equals(product.getName())) {
                System.out.println(entry.getKey());
                break;

            }
        }
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

}
