package question01;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

/**
 * Complete the implementation of run() which will execute the transaction passed
 * into the ATM constructor.
 * 
 * The accountBalances map contains the mapping from the account number (Integer)
 * to the current account balance (Double).
 * 
 * If the transaction type is DEPOSIT, update the accountBalances map with the 
 * new balance (current balance + amount).
 * 
 * If the transaction type is WITHRAWAL, update the accountBalances map with the new balance
 * (current balance - amount).  If the amount is less than the current balance, no update
 * should take place.
 * 
 * If the transaction is a success, call the printTransactionSuccess() helper method.
 * If the transaction is a failure, call the printTransactionFail() helper method.
 * 
 * Note that accounts can be shared by more than one person, therefore care must be taken
 * that multiple transactions with the same account number do not occur simulaneoulsy.
 */

public class ATM implements Runnable {
    public static enum TRANSACTION_TYPE {WITHDRAWL, DEPOSIT};

    private Map<Integer,Double> accountBalances;
    private TRANSACTION_TYPE type;
    private Integer accountNum;
    private Double amount;

    public ATM(Map<Integer,Double> accountBalances,TRANSACTION_TYPE type,Integer accountNum,Double amount) {
        this.accountBalances = accountBalances;
        this.type = type;
        this.accountNum = accountNum;
        this.amount = amount;
    }

    @Override
    public void run() {
        // Should not happen, but good to have a check anyway
        if (accountBalances.containsKey(accountNum) == false) {
            return;
        } else {
        // ADD CODE HERE
            synchronized(accountBalances) {
                if (type == TRANSACTION_TYPE.DEPOSIT) { // Deposit
                    double addMoney = accountBalances.get(accountNum) + amount;
                    accountBalances.put(accountNum, addMoney);

                    printTransactionSuccess(TRANSACTION_TYPE.DEPOSIT, accountNum, amount, accountBalances.get(accountNum)); // should always guarantee

                } else if (type == TRANSACTION_TYPE.WITHDRAWL) { // Withdrawl
                    if (accountBalances.get(accountNum) >= amount) {
                        double removeMoney = accountBalances.get(accountNum) - amount;
                        accountBalances.put(accountNum, removeMoney);

                        printTransactionSuccess(TRANSACTION_TYPE.WITHDRAWL, accountNum, amount, accountBalances.get(accountNum));
                    
                    } else { // if trying to take out more money than you have
                        printTransactionFail(TRANSACTION_TYPE.WITHDRAWL, accountNum, amount, accountBalances.get(accountNum));
                    }
                }
            }
        }
	}

    public static String formatDollar(double amount) {
        return "$" + String.format("%.2f",amount);
    }

    private void printTransactionSuccess(TRANSACTION_TYPE type,Integer accountNum,double amount,double newBalance) {
        System.out.println("SUCCESS: " + type + " of " + formatDollar(amount) + " into " + accountNum + " (balance=" + formatDollar(newBalance) + ")");
    }

    private void printTransactionFail(TRANSACTION_TYPE type,Integer accountNum,double amount,double currentBalance) {
        System.out.println("FAIL: " + type + " of " + formatDollar(amount) + " into " + accountNum + " (balance=" + formatDollar(currentBalance) + ")");
    }

    public static void printAccountBalances(Map<Integer,Double> accountBalances) {
        for (Integer account : accountBalances.keySet())
            System.out.println(account + ": " + formatDollar(accountBalances.get(account)));
    }

    public static ATM genRandomTransaction(Map<Integer,Double> accounts) {
        Random random = new Random();
        Integer accountNum = random.nextInt(5);
        TRANSACTION_TYPE type = random.nextBoolean() ? TRANSACTION_TYPE.DEPOSIT : TRANSACTION_TYPE.WITHDRAWL;
        double amount = random.nextInt(20) + (random.nextInt(99) / 100.0);

        if (accounts.containsKey(accountNum) == false)
            accounts.put(accountNum,0.00);

        return new ATM(accounts,type,accountNum,amount);
    }

    public static void main(String[] args) throws InterruptedException{
        Map<Integer,Double> accounts = new TreeMap<>();

        List<Thread> threads = new ArrayList<>();

        
        for (int i = 0;i < 10;++i) 
            threads.add(new Thread(genRandomTransaction(accounts)));
        

        accounts.put(123,0.00);
        threads.add(new Thread(new ATM(accounts,TRANSACTION_TYPE.DEPOSIT,123,10.00)));
        threads.add(new Thread(new ATM(accounts,TRANSACTION_TYPE.WITHDRAWL,123,8.00)));
        threads.add(new Thread(new ATM(accounts,TRANSACTION_TYPE.DEPOSIT,123,5.00)));

        for (Thread thread : threads)
            thread.start();
        
        for (Thread thread : threads)
            thread.join();

        System.out.println("\nEnding Balances:");
        printAccountBalances(accounts);
    }
}
