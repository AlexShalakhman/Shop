package task.Task.UI;


import task.Task.data.Client;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UI {

    public void start()  {

        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            LoginizationUI loginizationUI = new LoginizationUI();
            CategoriesUI categoriesUI = new CategoriesUI();
            String clientInput;
            Client client = null;

            System.out.println("Welcome to the shop.txt, Dear Customer!");
            System.out.println("Are you an existing customer? Yes/No");
            clientInput = bufferedReader.readLine();

            switch (clientInput.toLowerCase()) {
                case "yes":
                    client = loginizationUI.startLoginization(bufferedReader);
                    break;
                case "no":
                    RegistrationUI.startRegistration(bufferedReader);
                    break;
            }

            if (clientInput.equalsIgnoreCase("no")) {
                loginizationUI.startLoginization(bufferedReader);
            }

            if (client != null) {
                System.out.println("");
            }

            categoriesUI.mainMenu(client, bufferedReader);


        } catch (IOException io){
            System.out.println("Something wrong");
        }
    }


    }

