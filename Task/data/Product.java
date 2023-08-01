package task.Task.data;

import task.Task.data.ProductDescription;

public class Product {
    private String name;
    private ProductDescription productDescription;
    private double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Product(Integer id, String name, ProductDescription productDescription, double price) {
        this.name = name;
        this.productDescription = productDescription;
        this.price = price;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductDescription getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(ProductDescription productDescription) {
        this.productDescription = productDescription;
    }

    @Override
    public String toString() {
        return   name  + " " +
                price + " CAD ";
    }

}