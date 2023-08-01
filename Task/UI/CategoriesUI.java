package task.Task.UI;

import task.Task.OldClasses.Warehouse;
import task.Task.data.ProductType;

public class CategoriesUI {
    public static void startCategoriesUI() {
        int number = 1;
        for (ProductType enumValue : ProductType.values()) {
            System.out.println(number++ +") " + enumValue.getLabel());
        }
    }

    public static void mainMenu(){

        System.out.println(MenuCategories.MAIN_CATEGORIES);
        System.out.println(MenuCategories.ADD_ITEM_TO_BASKET);
        System.out.println(MenuCategories.REMOVE_PRODUCT);
        System.out.println(MenuCategories.SHOW_BASKET);
        System.out.println(MenuCategories.EMPTY_BASKET);
        System.out.println(MenuCategories.BUY_PRODUCTS);
        System.out.println(MenuCategories.END_SESSION);
        System.out.print("Please, write number in order to choose option - ");

    }


    public static ProductType categoryExpand(int categoryExpand, Warehouse warehouse){
        System.out.println();
        switch (categoryExpand) {
            case 1:
                return ProductType.ALCOHOL;
            case  2:
                return ProductType.TOBACCO;
            case 3:
                return ProductType.MEAT;
            case 4:
                return ProductType.MILK_PRODUCTS;
            case 5:
                return ProductType.FISH;
            case 6:
                return ProductType.FRUIT;
            case 7:
                return ProductType.VEGETABLE;
            case 8:
                return ProductType.MACARONI;
            case 9:
                return ProductType.ELECTRONICS;
            case 10:
                return ProductType.CANS;
            case 11:
                return ProductType.KASHAS;
        }
        System.out.println();
        return null;
    }

}
