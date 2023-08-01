package task.Task.data;

import task.Task.data.Client;
import task.Task.data.Product;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Casher {

    private String name;
    private int ageExp;
    private final Set<String> productTypes = new HashSet<>();

    public Casher(String name, int ageExp) {
        this.name = name;
        this.ageExp = ageExp;
    }

    public double scanProduct(Client client) {
        double totalprice = 0;
        for (Map.Entry<Product, Integer> entry : client.getBasket().entrySet()) {
            totalprice +=entry.getKey().getPrice() * entry.getValue().intValue();
        }
        return totalprice;

    }

}



