package task.Task;

import java.util.Scanner;

public enum MenuCategories {
    MAIN_CATEGORIES(1, ". Categories"),
    ADD_ITEM_TO_BASKET(2, ". Add item to basket"),
    REMOVE_PRODUCT(3, ". Remove item from basket"),
    SHOW_BASKET(4, ". Show your basket"),
    EMPTY_BASKET(5,". Empty your basket" ),
    BUY_PRODUCTS(6,". Checkout"),
    END_SESSION(7, ". End session");


    @Override
    public String toString() {
        return  categoryNumber + categories;
    }

    public final int categoryNumber;
    public final String categories;

    MenuCategories(int categoryNum, String categories){
        this.categoryNumber = categoryNum;
        this.categories = categories;
    }

    public String getCategories() {
        return categories;
    }

    }


