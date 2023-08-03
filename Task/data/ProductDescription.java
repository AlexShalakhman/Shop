package task.Task.data;

import task.Task.UI.EnumUI.ProductType;

public class ProductDescription {
    private ProductType productType;

    public ProductDescription(String productType) {
        String stringValue =  productType.toUpperCase();
        this.productType = ProductType.valueOf(stringValue);

    }

    public ProductType getProductType() {
        return productType;
    }
}
