package task.Task.validation;

import task.Task.exception.IllegalBalanceException;

public class ClientValidator {


        public void validateBalance(double balance) throws IllegalBalanceException {
            if(balance > 100_000){
                throw new IllegalBalanceException(balance + " > " + 100_000);
            }
        }




    }


