package task.Task.service;

import task.Task.data.Client;

public class ShopManager {


    public boolean finalizePayment(Client client, double totalPrice) {
        if(client.payForProducts(totalPrice) == true){
            client.getShop().processPayment(client, client.getShop().performSale(client));
            return true;
        } else if (client.payForProducts(totalPrice) == false) {
            return false;

        }
        return false;
    }



}
