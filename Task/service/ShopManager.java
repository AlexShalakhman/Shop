package task.Task.service;

import task.Task.dao.ProductDao;
import task.Task.data.ProductDescription;
import task.Task.data.Client;
import task.Task.data.Product;
import task.Task.OldClasses.Warehouse;
import task.Task.data.ProductType;

public class ShopManager {



    public void finalizePayment(Client client, double totalPrice) {
        if(client.payForProducts(totalPrice) == true){
            client.getShop().processPayment(client, client.getShop().performSale(client));
        } else if (client.payForProducts(totalPrice) == false) {

        }
    }



}
