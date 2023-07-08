package task.Task;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private static Map<Product, Integer> productMap = new HashMap<>();

    public void addProduct(Product product, Integer count) {
        if (productMap.containsKey(product)) {
            productMap.put(product, productMap.get(product) + count);
        } else {
            productMap.put(product, count);
        }
    }

    public void removeProduct(Product product, Integer count) {
        if (productMap.containsKey(product) && productMap.get(product) >= count) {
            Integer currentCount = productMap.get(product);
            productMap.put(product, currentCount - count);
        }
    }

    public Integer showProductQuantity(Product product) {
        productMap.containsValue(product);
        for (Integer o : productMap.values()) {

            return o;
        }
        return null;
    }

    public static Map<Product, Integer> getProductMap() {
        return productMap;
    }

    public void showProductByType(ProductType productType) {
        for (Map.Entry<Product, Integer> pair : productMap.entrySet()) {
            if (pair.getKey().getProductDescription().getProductType().getOrderNm() == productType.getOrderNm()) {
                Product key = pair.getKey();
                Integer value = pair.getValue();
                System.out.println(key + " --> " + value);
            }
        }

    }

}
