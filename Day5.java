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
