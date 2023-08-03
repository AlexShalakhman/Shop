package task.Task.UI;

import task.Task.validation.RegistrationValidator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RegistrationUI {
    public static boolean startRegistration(BufferedReader bufferedReader)  {
        boolean registration = false;
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try{
            boolean doing = false;
            do{
                System.out.println("   Registration   ");
                System.out.println("Please fulfill all of the following fields:");

                System.out.print("First Name: ");
                String firstName = bufferedReader.readLine();

                System.out.print("Last Name: ");
                String lastName = bufferedReader.readLine();

                System.out.print("Login: ");
                String login = bufferedReader.readLine();

                System.out.print("Password: ");
                String password = bufferedReader.readLine();

                System.out.print("How much money you want to add to your wallet: ");
                String balance = bufferedReader.readLine();
                registration = RegistrationValidator.validateAddNewClientToFile(login, password, firstName, lastName, balance) ? true : false;
                if(registration == true){
                    doing = true;
                }
             } while (!doing);

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return registration;
    }
}

