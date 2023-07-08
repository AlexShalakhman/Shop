package task.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Shop {
    private List<Casher> cashers;
    private Warehouse warehouse;
    private double bank;

    public List<Casher> getCashers() {
        return cashers;
    }

    public Shop(Warehouse warehouse, double bank) {
        this.warehouse = warehouse;
        this.bank = bank;
    }

    public void findGoods(String productName, Warehouse warehouse){
        // найти товар в магазине
        warehouse.getProductMap().containsValue(productName);
    }

    public void checkQuantity(Product product, Warehouse warehouse){
        // проверить сколько количества товара есть на складе
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

    public double getBank() {
        return bank;
    }

    public void setBank(double bank) {
        this.bank = bank;
    }

    public static void shopPrepareForWork(){
      //  Shop shop = new Shop(ware)
    }
}
