Quiz1
1)
import java.util.HashMap;
public class AccountTransfer {
    public static void main(String[] args) {
        HashMap<String, Account> accounts = new HashMap<>();
        accounts.put("12345", new Account("XXXX", 5000));
        accounts.put("54321", new Account("XXXX", 2500));
        transfer(accounts, "12345", "54321", 1500);
        printReceipt(accounts.get("12345"));
        transfer(accounts, "54321", "12345", 3000);
        printReceipt(accounts.get("54321"));
    }
    public static void transfer(HashMap<String, Account> accounts, String fromId, String toId, int amount) {
        Account fromAccount = accounts.get(fromId);
        Account toAccount = accounts.get(toId);
        fromAccount.withdraw(amount);
        toAccount.deposit(amount);
    }
    public static void printReceipt(Account account) {
        System.out.println("Account id: " + account.getId());
        System.out.println("Name: " + account.getName());
        System.out.println("Account Balance: Rs." + account.getBalance());
    }
    static class Account {
        private String id = "12344";
        private String name;
        private int balance;
        public Account(String name, int balance) {
            this.name = name;
            this.balance = balance;
        }
        public String getId() {
            return id;
        }
        public String getName() {
            return name;
        }
        public int getBalance() {
            return balance;
        }
        public void withdraw(int amount) {
            balance -= amount;
        }
        public void deposit(int amount) {
            balance += amount;
        }
    }
}
2)
import java.util.ArrayList;
import java.util.List;
public class PartitionAndMerge {
    public static List<Integer> partitionAndMerge(List<Integer> arr, int partitionSize, List<Integer> partitionOrder) {
        List<List<Integer>> partitions = new ArrayList<>();
        for (int i = 0; i < arr.size(); i += partitionSize) {
            partitions.add(arr.subList(i, Math.min(i + partitionSize, arr.size())));
        }
        List<Integer> mergedArr = new ArrayList<>();
        for (int index : partitionOrder) {
            mergedArr.addAll(partitions.get(index - 1));
        }
        return mergedArr;
    }
    public static void main(String[] args) {
        List<Integer> arr = List.of(1, 2, 3, 4, 5);
        int partitionSize = 2;
        List<Integer> partitionOrder = List.of(3, 2, 1);
        List<Integer> mergedArr = partitionAndMerge(arr, partitionSize, partitionOrder);
        System.out.println("Merged array: " + mergedArr);
    }
}
3)
class PalPrime {
    int number;
    String message;
    public PalPrime(int number, String message) {
        this.number = number;
        this.message = message;
        System.out.println(message + " " + number);
    }
    public boolean isPalindrome() {
        return Integer.toString(number).equals(new StringBuilder(Integer.toString(number)).reverse().toString());
    }
    public boolean isPrime() {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
public class Main {
    public static void main(String[] args) {
        int[] numbers = {1, 34543, 565, 727, 10099};
        String message = "Number ";
        for (int num : numbers) {
            PalPrime palPrime = new PalPrime(num, message);
            if (palPrime.isPalindrome() && palPrime.isPrime()) {
                System.out.println("is PalPrime");
            } else if (palPrime.isPalindrome()) {
                System.out.println("is Palindrome");
            } else if (palPrime.isPrime()) {
                System.out.println("is Prime");
            } else {
                System.out.println("is neither Prime nor Palindrome");
            }
        }
    }
}
Output÷
Number  1 is Palindrome
Number  34543 is PalPrime
Number  565 is Palindrome
Number  727 is PalPrime
Number  10099 is Prime

Quiz2
1)
class MyClass {
    public MyClass() {
        System.out.println("No-arguments constructor called");
    }
    public MyClass(int dummy) {
    }
    public MyClass(String name, int age) {
        System.out.println("Parameterized constructor called with name: " + name + " and age: " + age);
    }
}
2)
public class RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int uniqueIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[uniqueIndex]) {
                uniqueIndex++;
                nums[uniqueIndex] = nums[i];
            }
        }
        return uniqueIndex + 1;
    }
    public static void main(String[] args) {
        int[] nums = {22, 22, 77, 77, 88, 89, 89};
        int uniqueCount = removeDuplicates(nums);
        System.out.println("Number of unique elements: " + uniqueCount);
    }
}
3)
public class RearrangeArray {
    public static void rearrangeArray(int[] arr) {
        int i = 0, j = arr.length - 1;
        while (i < j) {
            if (arr[i] < 0) {
                i++;
            } else if (arr[j] > 0) {
                j--;
            } else {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {-12, 11, -13, -5, 6, -7, 5, -3, -6};
        rearrangeArray(arr);
        System.out.println("Rearranged array: " + Arrays.toString(arr));
    }
}



