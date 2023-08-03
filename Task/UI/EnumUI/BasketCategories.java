package task.Task.UI.EnumUI;

public enum BasketCategories {
    ADD_ITEM_TO_BASKET(1, ". Add item to basket"),
    REMOVE_PRODUCT(2, ". Remove item from basket"),
    SHOW_BASKET(3, ". Show your basket"),
    EMPTY_BASKET(4,". Empty your basket" ),
    CHECKOUT(5,". Checkout"),
    BACK_TO_MAIN_MENU(6, ". Back to main menu");


    @Override
    public String toString() {
        return  categoryNumber + categories;
    }

    public final int categoryNumber;
    public final String categories;

    BasketCategories(int categoryNum, String categories){
        this.categoryNumber = categoryNum;
        this.categories = categories;
    }

    public String getCategories() {
        return categories;
    }

    public int getCategoryNumber() {
        return categoryNumber;
    }

    public static BasketCategories getBasketCategoryByValue(int value) {
        for (BasketCategories category : BasketCategories.values()) {
            if (category.categoryNumber == value) {
                return category;
            }
        }
        return null;
    }
}

