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
Quiz2
1)
import java.util.Arrays;
public class SeparateOddEvenArrays {
    public static void main(String[] args) {
        int[] arr = {10, 3, 5, 12, 17, 22};
        int evenCount = 0, oddCount = 0;
        for (int num : arr) {
            if (num % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }
        int[] evenArr = new int[evenCount];
        int[] oddArr = new int[oddCount];
        int evenIndex = 0, oddIndex = 0;
        for (int num : arr) {
            if (num % 2 == 0) {
                evenArr[evenIndex++] = num;
            } else {
                oddArr[oddIndex++] = num;
            }
        }
        System.out.println("Even elements: " + Arrays.toString(evenArr));
        System.out.println("Odd elements: " + Arrays.toString(oddArr));
    }
}
2)
public class StringCompression {
   public static String compressString(String s) {
       StringBuilder compressed = new StringBuilder();
       int count = 0;
       char currentChar = s.charAt(0);
       for (char c : s.toCharArray()) {
           if (c == currentChar) {
               count++;
           } else {
               compressed.append(currentChar).append(count);
               currentChar = c;
               count = 1;
           }
       }
       compressed.append(currentChar).append(count);
       return compressed.toString().length() < s.length() ? compressed.toString() : s;
   }
   public static void main(String[] args) {
       String input1 = "AAABBC";
       String input2 = "AAABBCCCDE";
       System.out.println(compressString(input1));  // Output: A3B2C
       System.out.println(compressString(input2));  // Output: A3B2C3DE
   }
}
3)
public class PatternedString {
    public static void main(String[] args) {
        String input = "zohocorporationteam";
        int len = input.length();
        int spaces = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < spaces; j++) {
                System.out.print(" ");
            }
            System.out.print(input.charAt(i));
            if (isVowel(input.charAt(i))) {
                System.out.println();
                spaces++;
            } else {
                System.out.print(" ");
            }
        }
    }
    private static boolean isVowel(char c) {
        return "aeiou".indexOf(c) != -1;
    }
}

