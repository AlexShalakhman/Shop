package task.Task.UI.EnumUI;

import java.util.Scanner;

public enum MenuCategories {
    MAIN_CATEGORIES(1, ". Categories"),
    BASKET_MENU(2, ". Show basket menu"),
    CHECKOUT(3,". Checkout"),
    END_SESSION(4, ". End session");


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


    public int getCategoryNumber() {
        return categoryNumber;
    }

    public static MenuCategories getMainMenuCategoryByValue(int value) {
        for (MenuCategories category : MenuCategories.values()) {
            if (category.categoryNumber == value) {
                return category;
            }
        }
        return null;
    }
}