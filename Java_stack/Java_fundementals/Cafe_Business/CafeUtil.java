import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CafeUtil {

    public int getStreakGoal(int numWeeks) {
        int sum = 0;
        for (int i = 0; i <= numWeeks; i++){
            sum += i;
        }
        return sum;
    }

    public double getOrderTotal(double[] prices) {
        double sum = 0;
        for (int i = 0; i < prices.length; i++){
            sum += prices[i];
        }
        return sum;
    }

    public void displayMenu(ArrayList<String> menuItems) {
        for (int i = 0; i < menuItems.size(); i++){
            System.out.println(i + " " + menuItems.get(i));
        }
    }

    public void addCustomer( ArrayList<String> customer ) {
        String userName = System.console().readLine();
        System.out.println("Hello, " + userName);
        System.out.println("There are " + customer.size() +" people in front of you");
        customer.add(userName);
        for (int i = 1; i < customer.size(); i++){
            System.out.println(i + " " + customer.get(i-1));
        }
    }

    public void printPriceChart(String product, double price, int maxQuantity) {
        System.out.println(product);
        for (int i = 1; i <= maxQuantity; i++){
            System.out.println(i + " - " + price * i);
        }
    }
}
