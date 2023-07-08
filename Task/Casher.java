package task.Task;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Casher {

    private String name;
    private int ageExp; // лет опыта
    private final Set<String> productTypes = new HashSet<>();

    public Casher(String name, int ageExp) {
        this.name = name;
        this.ageExp = ageExp;
    }

    public void addProductType(String productType) {
        productTypes.add(productType);
    }

    public Set<String> getProductTypes() {
        return productTypes;
    }

    public String getName() {
        return name;
    }

    public int getAgeExp() {
        return ageExp;
    }

    public void sellProducts(Client clientName) {
        double totalPrice = 0;
        for (Product item : clientName.getBasket().keySet()) {
           totalPrice = totalPrice + item.getPrice();
           for (Integer quantity : clientName.getBasket().values()){
               totalPrice = totalPrice * quantity;

            if (clientName.getBalance() > totalPrice) {
                    clientName.getShop().getWarehouse().removeProduct(item, quantity);
                }
            }
            }
        clientName.setBalance(clientName.getBalance() - totalPrice);
        clientName.getShop().setBank(clientName.getShop().getBank() + totalPrice);
        }


    public void  returnProductFromClient(Product product, int quantity){

    }

    // each product(bucket) has a separate cashier
    //

}
