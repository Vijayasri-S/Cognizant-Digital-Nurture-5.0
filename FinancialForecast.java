/*  
Recursion is when a method calls itself to solve a problem. In this program, we will calculate the future value of an investment using recursion. The future value is calculated using the formula:
Future Value = Present Value * (1 + Rate of Return) ^ Number of Years
Recursion maintains two main components: the base case and the recursive case. The base case is the condition under which the recursion stops, while the recursive case is where the method calls itself with modified parameters to approach the base case.
It uses stack memory to keep track of the recursive calls, which can lead to stack overflow if the recursion depth is too high. The time complexity of this recursive approach is O(n), where n is the number of years, as it makes a single recursive call for each year. The space complexity is also O(n) due to the call stack used for recursion.
Time complexity: O(n) because the function makes a single recursive call for each year, leading to a linear growth in the number of calls as the number of years increases.
Space complexity: O(n)
It can be optimized using memoization or by converting the recursive approach to an iterative one, which would reduce the space complexity to O(1) and maintain the time complexity at O(n).
*/
import java.util.Scanner;

public class FinancialForecast {

    static double futureValue(double amount, double rate, int years) {

        if(years==0)
            return amount;

        return futureValue(amount, rate, years - 1) * (1 + rate / 100);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Initial Amount: ");
        double amount = sc.nextDouble();

        System.out.print("Enter Annual Growth Rate (%): ");
        double rate = sc.nextDouble();

        System.out.print("Enter Number of Years: ");
        int years = sc.nextInt();

        double result = futureValue(amount, rate, years);

        System.out.println("Future Value = " + result);
    }
}