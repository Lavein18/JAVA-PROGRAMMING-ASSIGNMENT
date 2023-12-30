Quiz1
1)
import java.lang.Thread;
class MyRunnable implements Runnable {
    String name;
    MyRunnable(String name) {
        this.name = name;
    }
    public void run() {
        System.out.println("Thread name: " + Thread.currentThread().getName());
    }
}
public class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyRunnable("Thread-1"));
        Thread t2 = new Thread(new MyRunnable("Thread-2"));
        t1.start();
        t2.start();
    }
}
2)
import java.util.concurrent.Semaphore;
class PrintNumbers implements Runnable {
    private int start, end;
    private Semaphore semaphore;
    PrintNumbers(int start, int end, Semaphore semaphore) {
        this.start = start;
        this.end = end;
        this.semaphore = semaphore;
    }
    @Override
    public void run() {
        try {
            for (int i = start; i <= end; i++) {
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName() + ": " + i);
                semaphore.release();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
public class Main {
    public static void main(String[] args) {
        int N = 10;
        Semaphore semaphore = new Semaphore(1);
        Thread t1 = new Thread(new PrintNumbers(1, N / 2, semaphore), "Thread 1");
        Thread t2 = new Thread(new PrintNumbers(N / 2 + 1, N, semaphore), "Thread 2");
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finished printing all numbers!");
    }
}


3)
import java.util.ArrayList;
public class SequentialThreads {
    public static void main(String[] args) {
        int[] primeRange = {0, 10};
        int[] palindromeRange = {10, 50};
        Thread primeThread = new Thread(new PrimeNumberFinder(primeRange));
        Thread palindromeThread = new Thread(new PalindromeFinder(palindromeRange));
        primeThread.start();
        try {
            primeThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        palindromeThread.start();
        try {
            palindromeThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class PrimeNumberFinder implements Runnable {
    int[] range;
    PrimeNumberFinder(int[] range) {
        this.range = range;
    }
    @Override
    public void run() {
        ArrayList<Integer> primes = findPrimes(range[0], range[1]);
        System.out.println("Prime numbers: " + primes);
    }
    ArrayList<Integer> findPrimes(int start, int end) {
        ArrayList<Integer> primes = new ArrayList<>();
        for (int num = start; num <= end; num++) {
            if (isPrime(num)) {
                primes.add(num);
            }
        }
        return primes;
    }
    boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
class PalindromeFinder implements Runnable {
    int[] range;
    PalindromeFinder(int[] range) {
        this.range = range;
    }
    @Override
    public void run() {
        ArrayList<Integer> palindromes = findPalindromes(range[0], range[1]);
        System.out.println("Palindrome numbers: " + palindromes);
    }
    ArrayList<Integer> findPalindromes(int start, int end) {
        ArrayList<Integer> palindromes = new ArrayList<>();
        for (int num = start; num <= end; num++) {
            if (isPalindrome(num)) {
                palindromes.add(num);
            }
        }
        return palindromes;
    }
    boolean isPalindrome(int num) {
        String numStr = String.valueOf(num);
        return numStr.equals(new StringBuilder(numStr).reverse().toString());
    }
}
Quiz2
1)
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;
public class FindFilesWithExtension {
    public static void main(String[] args) {
        String folderPath = "/path/to/your/folder";
        String extension = ".txt";
        List<File> files = getFilesWithExtension(folderPath, extension);
        for (File file : files) {
            System.out.println(file.getName());
        }
    }
    public static List<File> getFilesWithExtension(String folderPath, String extension) {
        File folder = new File(folderPath);
        List<File> files = new ArrayList<>();
        FilenameFilter filter = (dir, name) -> name.toLowerCase().endsWith(extension);
        File[] foundFiles = folder.listFiles(filter);
        if (foundFiles != null) {
            for (File file : foundFiles) {
                if (file.isFile()) {
                    files.add(file);
                } else if (file.isDirectory()) {
                    files.addAll(getFilesWithExtension(file.getAbsolutePath(), extension));
                }
            }
        }
        return files;
    }
}
2)
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class CheckPositiveNumbers {
    public static void main(String[] args) {
        String filename = "test.txt";
        try {
            checkForPositiveNumbers(filename);
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        } catch (PositiveNumberException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void checkForPositiveNumbers(String filename) throws FileNotFoundException, PositiveNumberException {
        Scanner scanner = new Scanner(new File(filename));
        System.out.println("Content of " + filename + ":");
        while (scanner.hasNextInt()) {
            int number = scanner.nextInt();
            System.out.print(number + " ");
            if (number > 0) {
                throw new PositiveNumberException("Positive number found: " + number);
            }
        }
        System.out.println("\nAll numbers are non-positive.");
    }
}
class PositiveNumberException extends Exception {
    public PositiveNumberException(String message) {
        super(message);
    }
}


3)
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class FindMostCommonWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory name: ");
        String directoryName = scanner.nextLine();
        Map<String, Integer> wordCounts = new HashMap<>();
        try {
            countWordsInDirectory(directoryName, wordCounts);
        } catch (FileNotFoundException e) {
            System.out.println("Error: Directory not found.");
            return;
        }
        int highestFrequency = findHighestFrequency(wordCounts);
        printWordsWithFrequency(wordCounts, highestFrequency);
    }
    private static void countWordsInDirectory(String directoryName, Map<String, Integer> wordCounts) throws FileNotFoundException {
        File directory = new File(directoryName);
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    countWordsInFile(file, wordCounts);
                }
            }
        }
    }
    private static void countWordsInFile(File file, Map<String, Integer> wordCounts) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(file);
        while (fileScanner.hasNext()) {
            String word = fileScanner.next().toLowerCase();  // Convert to lowercase for case-insensitive counting
            wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
        }
    }
    private static int findHighestFrequency(Map<String, Integer> wordCounts) {
        int highestFrequency = 0;
        for (int frequency : wordCounts.values()) {
            highestFrequency = Math.max(highestFrequency, frequency);
        }
        return highestFrequency;
    }
    private static void printWordsWithFrequency(Map<String, Integer> wordCounts, int highestFrequency) {
        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            if (entry.getValue() == highestFrequency) {
                System.out.println("Word: " + entry.getKey() + ", Frequency: " + entry.getValue());
            }
        }
    }
}
