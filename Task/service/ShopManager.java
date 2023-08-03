package task.Task.service;

import task.Task.data.Client;

public class ShopManager {



    public void finalizePayment(Client client, double totalPrice) {
        if(client.payForProducts(totalPrice) == true){
            client.getShop().processPayment(client, client.getShop().performSale(client));
        } else if (client.payForProducts(totalPrice) == false) {

        }
    }



}
