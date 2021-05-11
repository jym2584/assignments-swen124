package activities;
import java.util.*;
import knapsack.*;

public class Greedy {
    // while the change_given is not equal to the amount
        // if the amount is more than 1
            // add the dollar to the list
            // add the amount to change_given
        // if the amount is less than a dollar
            // if floor(amount / 25) == 3
                // add 3 quarters
                // subtract amount by 25 

    public static List<Currency> makeChange(double price, double payment){
        // change_list = new list
        // change = payment - price
        // while change > 0:
            // count = change / dollar
            // add count DOLLARS to change_list
            // change = change - count * DOLLAR
            // repeat for each successive domination
        // return change_list

        List<Currency> change_list = new ArrayList<>();
        int count = 0;
        double change = payment - price;
        Currency[] monies = {Currency.DOLLAR, Currency.QUARTER, Currency.DIME, Currency.NICKEL, Currency.PENNY};
        int index = 0;
        while(change > 0) {
            count = (int)( change / monies[index].getValue() + 0.005);
            
            for(int i = 0; i < count; i++) {
                change_list.add(monies[index]);
                change = change - monies[index].getValue();
            }
            index++;

        }

        double total_cost = 0;
        for(int i = 0; i < change_list.size(); i++) {
            total_cost += change_list.get(i).getValue();
        }
        System.out.println("Given $" + payment + " on a purchase that costs $" + price + ". $" + total_cost + " given back.");
        return change_list;

    }

    public static void packItems(Knapsack knapsack, List<Item> items) {
        // sort list by value
        // loop over list
            // if item will fit
            // add it to the knapsack
            // remove item from list
        
        items.sort(new ValueComparator());

        while(!items.isEmpty()) {
            knapsack.pack(items.get(0));
            items.remove(0);
        }

    }

    public static void main(String[] args) {
        System.out.println(makeChange(2.74, 5.00));

        Knapsack knapsack = new Knapsack(10);
        packItems(knapsack, ItemSets.sportsSet());
        System.out.println(knapsack);
    }







}
