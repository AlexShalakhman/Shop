package task.Task.validation;

import task.Task.exception.IllegalLoginException;
import task.Task.exception.InvalidPasswordException;

import java.io.*;
import java.nio.file.*;

import static task.Task.Loginization.Registration.addNewClientToFile;

public class RegistrationValidator {
    private static final Path DB_PATH = Paths.get("Task/DataBase/client_table.txt");

    public static boolean validateAddNewClientToFile(String login, String password, String firstName, String lastName, String balance) {
        Double numberBalance = Double.parseDouble(balance);
        try {
            if (isLoginUnique(login) && validatePassword(password) && validateFirstName(firstName) && validateLastName(lastName) && validateBalance(balance)) {
                boolean success = addNewClientToFile(DB_PATH, login, password, firstName, lastName, numberBalance);
                System.out.println("New user added successfully.");
                return true;
            } else {
                System.out.println("Failed to add new user.");
                return false;
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    private static boolean isLoginUnique(String login)  {
        try (BufferedReader reader = Files.newBufferedReader(DB_PATH)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");

                if (columns.length >= 2 && columns[1].equals(login)) {
                    throw new IllegalLoginException("User with this login already exist.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalLoginException e) {
            e.printStackTrace();
        }
        return true;
    }

    private static boolean validatePassword(String password) {
        try {
            if (password.length() < 8) {
                throw new InvalidPasswordException("Password must have at least 8 characters.");
            }
            boolean hasCapitalLetter = false;
            boolean hasNumber = false;

            for (char c : password.toCharArray()) {
                if (Character.isUpperCase(c)) {
                    hasCapitalLetter = true;
                }
                if (Character.isDigit(c)) {
                    hasNumber = true;
                }
                if (hasCapitalLetter && hasNumber) {
                    break;
                }
            }

            if (!hasCapitalLetter) {
                throw new InvalidPasswordException("Password must contain at least one uppercase letter.");
            }
            if (!hasNumber) {
                throw new InvalidPasswordException("Password must contain at least one digit.");
            }

            return hasCapitalLetter && hasNumber;
        } catch (InvalidPasswordException e) {
            System.out.println("Invalid password: " + e.getMessage());
            return false;
        }
    }

    private static boolean validateFirstName(String input) {
        if (!Character.isUpperCase(input.charAt(0))) {
            System.out.println("First name must start with a capital letter.");
            return false;
        }


        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                System.out.println("First name cannot contain any digits.");
                return false;
            }
        }

        return true;
    }

    private static boolean validateLastName(String input) {
        if (!Character.isUpperCase(input.charAt(0))) {
            System.out.println("Last name must start with a capital letter.");
            return false;
        }


        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                System.out.println("Last name cannot contain any digits.");
                return false;
            }
        }

        return true;
    }

    private static boolean validateBalance(String balance) {
        double finalBalance = Double.parseDouble(balance);
        try {
            if (finalBalance > 0) {
                return true;
            } else {
                System.out.println("Balance can not be 0.");
                return false;
            }
        }catch (NumberFormatException e){
            System.out.println("Input must be a valid number.");
            return false;
        }
    }
}
