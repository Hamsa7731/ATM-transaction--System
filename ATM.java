import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int correctPin = 1234;
        int attempts = 0;
        double balance = 1000;

        // PIN verification (3 attempts)
        while (attempts < 3) {
            System.out.print("Enter PIN: ");
            int pin = sc.nextInt();

            if (pin == correctPin) {
                System.out.println("Login Successful!");

                int choice;
                do {
                    System.out.println("\n----- ATM MENU -----");
                    System.out.println("1. Check Balance");
                    System.out.println("2. Withdraw");
                    System.out.println("3. Deposit");
                    System.out.println("4. Exit");
                    System.out.print("Enter choice: ");
                    choice = sc.nextInt();

                    switch (choice) {
                        case 1:
                            System.out.println("Balance: " + balance);
                            break;

                        case 2:
                            System.out.print("Enter amount to withdraw: ");
                            double withdraw = sc.nextDouble();
                            if (withdraw <= balance) {
                                balance -= withdraw;
                                System.out.println("Withdraw Successful!");
                            } else {
                                System.out.println("Insufficient Balance!");
                            }
                            break;

                        case 3:
                            System.out.print("Enter amount to deposit: ");
                            double deposit = sc.nextDouble();
                            balance += deposit;
                            System.out.println("Deposit Successful!");
                            break;

                        case 4:
                            System.out.println("Thank you! Visit again.");
                            break;

                        default:
                            System.out.println("Invalid choice!");
                    }

                } while (choice != 4);

                return;
            } else {
                attempts++;
                System.out.println("Wrong PIN!");
            }
        }

        System.out.println("Too many attempts. Card blocked!");
    }
}