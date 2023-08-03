package task.Task.validation;

import task.Task.dao.ClientDao;
import task.Task.data.Client;
import task.Task.exception.IllegalLoginException;
import task.Task.exception.InvalidPasswordException;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.*;

public class LoginizationValidator {
    private static final Path DB_PATH = Paths.get("Task/DataBase/client_table.txt");

    public boolean validateUser(String login, String password){
        if(validateLogin(login) && validatePassword(password)) {
            return true;
        }
        return false;
    }

    private boolean validateLogin(String login)   {
        try (BufferedReader reader = Files.newBufferedReader(DB_PATH)) {
            String line;
            boolean exception = false;
            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");

                if (columns.length >= 2 && columns[1].equals(login)) {
                    exception = true;
                    return true;
                }
            }
            if(!exception)
            throw new IllegalLoginException("User with this login does not exist.");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalLoginException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    private boolean validatePassword(String password) {
        try {
            if (password.length() < 8) {
                throw new InvalidPasswordException("Password must have at least 8 characters.");
            }
            boolean hasCapitalLetter = false;
            boolean hasNumber = false;
            boolean correctPassword = false;

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

            try (BufferedReader reader = Files.newBufferedReader(DB_PATH)) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] columns = line.split(",");

                    if (columns.length >= 3 && columns[2].equals(password)) {
                        correctPassword = true;
                    } else {
                        throw new IllegalLoginException("Wrong password.");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (IllegalLoginException e) {
                e.printStackTrace();
            }
            return hasCapitalLetter && hasNumber && correctPassword;
        } catch (InvalidPasswordException e) {
            System.out.println("Invalid password: " + e.getMessage());
            return false;
        }
    }
}
