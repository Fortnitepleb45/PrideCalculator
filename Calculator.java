import java.util.Scanner;

public class Calculator {


    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public double divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return (double) a / b;
    }

    public int modulus(int a, int b) {
        return a % b;
    }

    public double power(int a, int b) {
        return Math.pow(a, b);
    }

    public double squareRoot(int a) {
        if (a < 0) {
            throw new IllegalArgumentException("Cannot compute square root of negative number");
        }
        return Math.sqrt(a);
    }

    public long factorial(int a) {
        if (a < 0) {
            throw new IllegalArgumentException("Cannot compute factorial of negative number");
        }
        long result = 1;
        for (int i = 2; i <= a; i++) {
            result *= i;
        }
        return result;
    }

    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    public boolean isPrime(int a) {
        if (a <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(a); i++) {
            if (a % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int fibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Cannot compute Fibonacci of negative number");
        }
        if (n == 0) return 0;
        if (n == 1) return 1;
        int a = 0, b = 1, c = 0;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    public int square(int a) {
        return a * a;
    }

    public int cube(int a) {
        return a * a * a;
    }

    public double average(int a, int b) {
        return (a + b) / 2.0;
    }

    public int max(int a, int b) {
        return Math.max(a, b);
    }

    public int min(int a, int b) {
        return Math.min(a, b);
    }

    public int abs(int a) {
        return Math.abs(a);
    }

    public int negate(int a) {
        return -a;
    }

    public int increment(int a) {
        return a + 1;
    }

    public int decrement(int a) {
        return a - 1;
    }

    public int sumOfDigits(int a) {
        a = Math.abs(a);
        int sum = 0;
        while (a > 0) {
            sum += a % 10;
            a /= 10;
        }
        return sum;
    }

    public int multiplyByTwo(int a) {
        return a * 2;
    }

public static void main(String[] args) {
    Calculator calc = new Calculator();
    Scanner scanner = new Scanner(System.in);

    boolean running = true;

    while (running) {
        System.out.println("\n===== Calculator Menu =====");
        System.out.println("0. Exit");
        System.out.println("1. Add");
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");
        System.out.println("5. Modulus");
        System.out.println("6. Power");
        System.out.println("7. Square Root");
        System.out.println("8. Factorial");
        System.out.println("9. GCD");
        System.out.println("10. LCM");
        System.out.println("11. Is Prime");
        System.out.println("12. Fibonacci");
        System.out.println("13. Square");
        System.out.println("14. Cube");
        System.out.println("15. Average");
        System.out.println("16. Max");
        System.out.println("17. Min");
        System.out.println("18. Absolute");
        System.out.println("19. Negate");
        System.out.println("20. Increment");
        System.out.println("21. Decrement");
        System.out.println("22. Sum of Digits");
        System.out.println("===========================");
        System.out.print("Choose an operation (0-22): ");

        int choice = scanner.nextInt();
        int a, b;

        if (choice == 0) {
            System.out.println("Exiting calculator... Goodbye!");
            running = false;
            continue;
        }

        try {
            switch (choice) {
                case 1:
                    System.out.print("Enter first number: ");
                    a = scanner.nextInt();
                    System.out.print("Enter second number: ");
                    b = scanner.nextInt();
                    System.out.println("Result: " + calc.add(a, b));
                    break;
                case 2:
                    System.out.print("Enter first number: ");
                    a = scanner.nextInt();
                    System.out.print("Enter second number: ");
                    b = scanner.nextInt();
                    System.out.println("Result: " + calc.subtract(a, b));
                    break;
                case 3:
                    System.out.print("Enter first number: ");
                    a = scanner.nextInt();
                    System.out.print("Enter second number: ");
                    b = scanner.nextInt();
                    System.out.println("Result: " + calc.multiply(a, b));
                    break;
                case 4:
                    System.out.print("Enter numerator: ");
                    a = scanner.nextInt();
                    System.out.print("Enter denominator: ");
                    b = scanner.nextInt();
                    System.out.println("Result: " + calc.divide(a, b));
                    break;
                case 5:
                    System.out.print("Enter first number: ");
                    a = scanner.nextInt();
                    System.out.print("Enter second number: ");
                    b = scanner.nextInt();
                    System.out.println("Result: " + calc.modulus(a, b));
                    break;
                case 6:
                    System.out.print("Enter base: ");
                    a = scanner.nextInt();
                    System.out.print("Enter exponent: ");
                    b = scanner.nextInt();
                    System.out.println("Result: " + calc.power(a, b));
                    break;
                case 7:
                    System.out.print("Enter number: ");
                    a = scanner.nextInt();
                    System.out.println("Result: " + calc.squareRoot(a));
                    break;
                case 8:
                    System.out.print("Enter number: ");
                    a = scanner.nextInt();
                    System.out.println("Result: " + calc.factorial(a));
                    break;
                case 9:
                    System.out.print("Enter first number: ");
                    a = scanner.nextInt();
                    System.out.print("Enter second number: ");
                    b = scanner.nextInt();
                    System.out.println("Result: " + calc.gcd(a, b));
                    break;
                case 10:
                    System.out.print("Enter first number: ");
                    a = scanner.nextInt();
                    System.out.print("Enter second number: ");
                    b = scanner.nextInt();
                    System.out.println("Result: " + calc.lcm(a, b));
                    break;
                case 11:
                    System.out.print("Enter number: ");
                    a = scanner.nextInt();
                    System.out.println("Is Prime? " + calc.isPrime(a));
                    break;
                case 12:
                    System.out.print("Enter n: ");
                    a = scanner.nextInt();
                    System.out.println("Result: " + calc.fibonacci(a));
                    break;
                case 13:
                    System.out.print("Enter number: ");
                    a = scanner.nextInt();
                    System.out.println("Result: " + calc.square(a));
                    break;
                case 14:
                    System.out.print("Enter number: ");
                    a = scanner.nextInt();
                    System.out.println("Result: " + calc.cube(a));
                    break;
                case 15:
                    System.out.print("Enter first number: ");
                    a = scanner.nextInt();
                    System.out.print("Enter second number: ");
                    b = scanner.nextInt();
                    System.out.println("Result: " + calc.average(a, b));
                    break;
                case 16:
                    System.out.print("Enter first number: ");
                    a = scanner.nextInt();
                    System.out.print("Enter second number: ");
                    b = scanner.nextInt();
                    System.out.println("Result: " + calc.max(a, b));
                    break;
                case 17:
                    System.out.print("Enter first number: ");
                    a = scanner.nextInt();
                    System.out.print("Enter second number: ");
                    b = scanner.nextInt();
                    System.out.println("Result: " + calc.min(a, b));
                    break;
                case 18:
                    System.out.print("Enter number: ");
                    a = scanner.nextInt();
                    System.out.println("Result: " + calc.abs(a));
                    break;
                case 19:
                    System.out.print("Enter number: ");
                    a = scanner.nextInt();
                    System.out.println("Result: " + calc.negate(a));
                    break;
                case 20:
                    System.out.print("Enter number: ");
                    a = scanner.nextInt();
                    System.out.println("Result: " + calc.increment(a));
                    break;
                case 21:
                    System.out.print("Enter number: ");
                    a = scanner.nextInt();
                    System.out.println("Result: " + calc.decrement(a));
                    break;
                case 22:
                    System.out.print("Enter number: ");
                    a = scanner.nextInt();
                    System.out.println("Result: " + calc.sumOfDigits(a));
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    scanner.close();
}

}