package task.Task;

public class ShopManager {
    public static void storageFulfill(Warehouse warehouse){
         warehouse = new Warehouse();
        ProductDescription macaroni = new ProductDescription(ProductType.MACARONI);
        ProductDescription alcohol = new ProductDescription(ProductType.ALCOHOL);
        ProductDescription electronics = new ProductDescription(ProductType.ELECTRONICS);
        ProductDescription fish = new ProductDescription(ProductType.FISH);
        ProductDescription fruit = new ProductDescription(ProductType.FRUIT);
        ProductDescription meat = new ProductDescription(ProductType.MEAT);
        ProductDescription tobacco = new ProductDescription(ProductType.TOBACCO);
        ProductDescription vegetable = new ProductDescription(ProductType.VEGETABLE);
        ProductDescription cans = new ProductDescription(ProductType.CANS);
        ProductDescription milkProducts = new ProductDescription(ProductType.MILK_PRODUCTS);
        ProductDescription kashas = new ProductDescription(ProductType.KASHAS);


        Product buccatini = new Product("Buccatini 500 gram", macaroni, 4.40);
        Product spageti = new Product("Spagetti Delvavella , 1kg", macaroni, 6);
        Product Jack_Daniels = new Product("JackDaniels 500ml", alcohol, 33);
        Product beherovka = new Product("Beherovka Odessa mama", alcohol, 17.63);
        Product iphone14 = new Product("Iphone 14 PRO", electronics, 5000);
        Product alienware = new Product("Laptop alienware 2022, 512GB/i9", electronics, 6700);
        Product dell = new Product("Monitor dell 26 inch , 60gh", electronics, 725);
        Product pike = new Product("Pike 1 kg", fish, 55.99);
        Product walleye = new Product("Walleye 1 kg", fish, 72.87);
        Product apple = new Product("Apple 1 kg", fruit, 4.99);
        Product cocos = new Product("Cocos 1 item", fruit, 7);
        Product pork = new Product("Pork meat, 1kg", meat, 19.50);
        Product chicken = new Product("Chicken Nuggets, 1kg", meat, 8.99);
        Product president = new Product(" Cigarettes President 20 sticks", tobacco, 13.22);
        Product parliament = new Product("Parliament 20 sticks", tobacco, 20.69);
        Product cucumbers = new Product("Cucumber 1 extra large", vegetable, 7.99);
        Product carrot = new Product("Carrot 1 extra large", vegetable, 5.99);
        Product rice = new Product("Rice 5kg",  kashas,23.50);
        Product milk = new Product("Milk 3% 2.0 liters", milkProducts, 4.40);
        Product beans = new Product("Beans, 400 gram", cans, 3.30);

        warehouse.addProduct(buccatini, 600);
        warehouse.addProduct(spageti, 600);
        warehouse.addProduct(Jack_Daniels, 100);
        warehouse.addProduct(beherovka, 100);
        warehouse.addProduct(pike, 50);
        warehouse.addProduct(walleye, 100);
        warehouse.addProduct(apple, 1000);
        warehouse.addProduct(cocos, 50);
        warehouse.addProduct(iphone14, 200);
        warehouse.addProduct(alienware, 10);
        warehouse.addProduct(dell, 35);
        warehouse.addProduct(pork, 100);
        warehouse.addProduct(chicken, 100);
        warehouse.addProduct(president, 50);
        warehouse.addProduct(parliament, 50);
        warehouse.addProduct(cucumbers, 50);
        warehouse.addProduct(carrot, 50);
        warehouse.addProduct(rice, 600);
        warehouse.addProduct(milk, 50);
        warehouse.addProduct(beans, 300);
    }


    public void finalizePayment(Client client, double totalPrice) {
        if(client.payForProducts(totalPrice) == true){
            client.getShop().processPayment(client, client.getShop().performSale(client));
        } else if (client.payForProducts(totalPrice) == false) {

        }
    }



}
