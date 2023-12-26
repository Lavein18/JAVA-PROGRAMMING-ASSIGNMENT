Quiz1
1)
A
import java.util.Scanner;
public class ReadInteger {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int number = input.nextInt();
        System.out.println("You entered: " + number);
        input.close();
    }
}
B
import java.util.Scanner;
public class CalculateAverage {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the first floating-point number: ");
        double num1 = input.nextDouble();
        System.out.print("Enter the second floating-point number: ");
        double num2 = input.nextDouble();
        double average = (num1 + num2) / 2;
        System.out.printf("The average is: %.2f", average);
        input.close();
    }
}
2)
import java.util.Scanner;
public class BasicCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter first number: ");
        double num1 = input.nextDouble();
        System.out.print("Enter operator (+, -, *, /): ");
        char operator = input.next().charAt(0);
        System.out.print("Enter second number: ");
        double num2 = input.nextDouble();
        double result = 0;
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 == 0) {
                    System.out.println("Error: Division by zero");
                } else {
                    result = num1 / num2;
                }
                break;
            default:
                System.out.println("Invalid operator");
                return;
        }
        if (result != 0) {
            System.out.println(num1 + " " + operator + " " + num2 + " = " + result);
        }
        input.close();
    }
}

3)
import java.util.HashSet;
public class HappyNumber {
    public static boolean isHappyNumber(int n) {
        HashSet<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            int sum = 0;
            while (n > 0) {
                int digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }
            n = sum;
        }
        return n == 1;
    }
    public static void main(String[] args) {
        int n = 19;
        boolean isHappy = isHappyNumber(n);
        System.out.println(n + " is a happy number: " + isHappy);
   }
}

