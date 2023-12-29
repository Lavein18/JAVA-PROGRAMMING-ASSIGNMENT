Quiz1
1)
// Member class
class Member {
    protected String name;
    protected int age;
    protected String phoneNumber;
    protected String address;
    protected double salary;
    public void printSalary() {
        System.out.println("Salary: $" + salary);
    }
}
// Employee class
class Employee extends Member {
    private String specialization;
    public Employee(String name, int age, String phoneNumber, String address, double salary, String specialization) {
        super(name, age, phoneNumber, address, salary);
        this.specialization = specialization;
    }
    public void printEmployeeDetails() {
        System.out.println("Employee Details:");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Address: " + address);
        System.out.println("Specialization: " + specialization);
        printSalary();
    }
}
// Manager class
class Manager extends Member {
    private String department;
    public Manager(String name, int age, String phoneNumber, String address, double salary, String department) {
        super(name, age, phoneNumber, address, salary);
        this.department = department;
    }
    public void printManagerDetails() {
        System.out.println("Manager Details:");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Address: " + address);
        System.out.println("Department: " + department);
        printSalary();
    }
}
// Creating objects and printing details
public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee("John Doe", 30, "123-456-7890", "123 Main St", 50000, "Software Engineer");
        Manager manager = new Manager("Jane Smith", 40, "987-654-3210", "456 Elm St", 80000, "Sales");
        System.out.println("------- Employee Information -------");
        employee.printEmployeeDetails();
        System.out.println("\n------- Manager Information -------");
        manager.printManagerDetails();
    }
}
2)
interface Account {
    void deposit(double amount);
    void withdraw(double amount);
    double getBalance();
}
abstract class AbstractAccount implements Account {
    protected double balance;
    public AbstractAccount(double initialBalance) {
        this.balance = initialBalance;
    }
    @Override
    public abstract void deposit(double amount);
    @Override
    public abstract void withdraw(double amount);
    @Override
    public double getBalance() {
        return balance;
    }
}
class SavingsAccount extends AbstractAccount {
    public SavingsAccount(double initialBalance) {
        super(initialBalance);
    }
    @Override
    public void deposit(double amount) {
        balance += amount + (amount * 0.02);
    }
    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds");
        }
    }
}
class CheckingAccount extends AbstractAccount {
    public CheckingAccount(double initialBalance) {
        super(initialBalance);
    }
    @Override
    public void deposit(double amount) {
        balance += amount;
    }
    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            // Implement overdraft handling
        }
    }
}
class LoanAccount extends AbstractAccount {
    private double interestRate;
    public LoanAccount(double initialBalance, double interestRate) {
        super(initialBalance);
        this.interestRate = interestRate;
    }
    @Override
    public void deposit(double amount) {
        balance -= amount;
    }
    @Override
    public void withdraw(double amount) {
        System.out.println("Withdrawals not allowed for loan accounts");
    }
}
3)
class Person {
    protected String name;
    protected int id;
    // Constructor and getters for name and id
}
class Student extends Person {
    private List<String> completedCourses;
    // Constructor and methods for managing completed courses
}
class Professor extends Person {
    private List<Course> teachingCourses;
    // Constructor and methods for managing teaching courses
}
class Course {
    private String name;
    private String courseCode;
    private Professor instructor;
    private List<String> prerequisites;
    private List<Student> enrolledStudents;
    // Constructor and getters for name, code, instructor, and prerequisites
    public boolean enrollStudent(Student student) {
        if (prerequisites.stream().allMatch(student.completedCourses::contains)) {
            enrolledStudents.add(student);
            return true;
        } else {
            System.out.println("Student has not completed prerequisites.");
            return false;
        }
    }
    public void displayEnrolledStudents() {
        System.out.println("Enrolled Students in " + name + " (" + courseCode + "):");
        for (Student student : enrolledStudents) {
            System.out.println("- " + student.name + " (ID: " + student.id + ")");
        }}}
Quiz2 
1)
public class Calculator {
   public int multiply(int num1, int num2) {
       return num1 * num2;
   }
   public double multiply(double num1, double num2, double num3) {
       return num1 * num2 * num3;
   }
   public static void main(String[] args) {
       Calculator calculator = new Calculator();
       int intResult = calculator.multiply(5, 6);
       System.out.println("Product of integers: " + intResult);
       double doubleResult = calculator.multiply(2.5, 3.4, 1.2);
       System.out.println("Product of doubles: " + doubleResult);
   }
}

2)
class Employee {
   String name;
   int employeeId;
   double basicSalary = 50000;
   public Employee(String name, int employeeId) {
       this.name = name;
       this.employeeId = employeeId;
   }
   public double calculateSalary() {
       return basicSalary;
   }
}
class Manager extends Employee {
   double bonusPercentage;
   public Manager(String name, int employeeId, double bonusPercentage) {
       super(name, employeeId);
       this.bonusPercentage = bonusPercentage;
   }
   @Override
   public double calculateSalary() {
       double bonus = basicSalary * bonusPercentage / 100;
       return basicSalary + bonus;
   }
}
class Developer extends Employee {
   String programmingLanguage;
   public Developer(String name, int employeeId, String programmingLanguage) {
       super(name, employeeId);
       this.programmingLanguage = programmingLanguage;
   }
   @Override
   public double calculateSalary() {
       double allowance = 5000;
       return basicSalary + allowance;
   }
}
public class Main {
   public static void main(String[] args) {
       Manager manager1 = new Manager("John Smith", 1234, 10);
       Developer developer1 = new Developer("Jane Doe", 5678, "Python");
       double managerSalary = manager1.calculateSalary();
       double developerSalary = developer1.calculateSalary();
       System.out.println("Manager " + manager1.name + " (ID: " + manager1.employeeId + ") earns $" + managerSalary);
       System.out.println("Developer " + developer1.name + " (ID: " + developer1.employeeId + ") earns $" + developerSalary);
   }
}


3)
public class Vehicle {
    protected int speed;
    public Vehicle(int speed) {
        this.speed = speed;
    }
    public int calculateSpeed() {
        return speed;
    }
}
class Car extends Vehicle {
    private int passengers;
    public Car(int speed, int passengers) {
        super(speed);
        this.passengers = passengers;
    }
    @Override
    public int calculateSpeed() {
        return speed * passengers;
    }
}
class Motorcycle extends Vehicle {
    private int wheels;
    public Motorcycle(int speed, int wheels) {
        super(speed);
        this.wheels = wheels;
    }
    @Override
    public int calculateSpeed() {
        return speed * wheels;
    }
}
public class Main {
    public static void main(String[] args) {
        Car car1 = new Car(60, 4);
        Motorcycle motorcycle1 = new Motorcycle(80, 2);
        int carSpeed = car1.calculateSpeed();
        int motorcycleSpeed = motorcycle1.calculateSpeed();
        if (carSpeed > motorcycleSpeed) {
            System.out.println("Car has the highest effective speed: " + carSpeed);
        } else if (carSpeed < motorcycleSpeed) {
            System.out.println("Motorcycle has the highest effective speed: " + motorcycleSpeed);
        } else {
            System.out.println("Car and motorcycle have the same effective speed: " + carSpeed);
        }
    }
}
