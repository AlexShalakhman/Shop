package task.Task.UI.EnumUI;

public enum ProductType {
    ALCOHOL(1, "Alcohol", "Different alcohol beverages"),
    TOBACCO(2,"Tobacco", "Miscellaneous tobacco"),
    MEAT(3, "Meat", "Variety of meat"),
    MILK_PRODUCTS(4, "Milk Products", "All natural and healthy milk products you could ever think of"),
    FISH(5, "Fish", "A lot of fish"),
    FRUIT(6, "Fruit", "Miscellaneous fruits"),
    VEGETABLE(7, "Vegetable", "Miscellaneous vegetables"),
    MACARONI(8, "Macaroni", "Italian macaroni"),
    ELECTRONICS(9, "Electronics", "Huge variety of tech stuff to choose from"),
    CANS(10, "Cans", "Plenty of pre cooked products"),
    KASHAS(11, "Kashas", "All kashas in the world");


    private final int orderNm;
    private String label;
    private String description;

    ProductType(int orderNm, String label, String description) {
        this.orderNm = orderNm;
        this.label = label;
        this.description = description;
    }

    public String getLabel() {
        return label;
    }

    public String getDescription() {
        return description;
    }

    public static void getAllPrinted(){
        for (ProductType producttype: ProductType.values()) {
            System.out.println(producttype);
        }
    }

    public int getOrderNm() {
        return orderNm;
    }

    @Override
    public String toString() {
        return  orderNm +". " +
                 label;
    }

    public static ProductType getProductTypeCategoryByValue(int value) {
        for (ProductType category : ProductType.values()) {
            if (category.orderNm == value) {
                return category;
            }
        }
        return null;
    }
}
