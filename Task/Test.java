package task.Task;

import java.util.SortedMap;

public class Test {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        ProductDescription productDescription = new ProductDescription("One of the most trusted maccaroni in Italy!");
        Shop walmart = new Shop(warehouse, 80_000);
        Product macaroni = new Product("Buccatini", productDescription, 500);
        Client andrew = new Client("Andrew", 6000, walmart);
        Casher Alon = new Casher("Alena", 22);

        warehouse.addProduct(macaroni, 261);
        warehouse.showProductQuantity(macaroni);

        andrew.addProductToBucket(macaroni, 2);

        System.out.println(warehouse.showProductQuantity(macaroni));

        Alon.sellProducts(andrew);
        System.out.println(andrew.getShop().getBank());

        System.out.println(warehouse.showProductQuantity(macaroni));
    }
}
