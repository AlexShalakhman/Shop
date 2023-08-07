package task.Task;


import task.Task.UI.*;
import task.Task.data.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        Client client = new Client(1L, "A", 500);
      CategoriesUI categoriesUI = new CategoriesUI();

       BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
       categoriesUI.mainMenu(client, bufferedReader);
    //    categoriesUI.basketCategories(client, bufferedReader);
    }
}

