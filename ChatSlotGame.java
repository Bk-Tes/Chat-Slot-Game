import java.util.Scanner;
import java.util.Random;

public class ChatSlotGame {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] symbol = new String[3];
        String[] symbols = {"🍊", "🍋‍", "🥝", "🍇", "🍉"};

        int balance = 1000;
        String answer = "yes";

        System.out.println("*****************************");
        System.out.println("Welcome to java slot game 🎉🎉🎉");
        System.out.println("symbols: 🍊 🍋 🥝 🍇 🍉");

        do {
            System.out.println("\nCurrent balance: $" + balance);
            System.out.print("Enter bet amount: ");
            int betamount = scanner.nextInt();

            if (betamount > balance) {
                System.out.println("Insufficient balance!");
                continue;
            }

            // spin
            System.out.println("Spinning...");
            for (int i = 0; i < 3; i++) {
                symbol[i] = symbols[random.nextInt(symbols.length)];
                System.out.print(symbol[i] + " ");
            }
            System.out.println();

            balance -= betamount;
            int totalbalance = 0;

            // all three same
            if (symbol[0].equals(symbol[1]) && symbol[1].equals(symbol[2])) {
                switch (symbol[0]) {
                    case "🍇" -> totalbalance = betamount * 4;
                    case "🍋‍" -> totalbalance = betamount * 6;
                    case "🍊" -> totalbalance = betamount * 8;
                    case "🍉" -> totalbalance = betamount * 10;
                    case "🥝" -> totalbalance = betamount * 12;
                }
                System.out.println("🎉 JACKPOT!");

            }
            // any two same
            else if (
                    (symbol[0].equals(symbol[1]) && !symbol[1].equals(symbol[2])) ||
                            (symbol[0].equals(symbol[2]) && !symbol[0].equals(symbol[1])) ||
                            (symbol[1].equals(symbol[2]) && !symbol[0].equals(symbol[1]))
            ) {
                switch (symbol[0]) {
                    case "🍇" -> totalbalance = betamount * 2;
                    case "🍋‍" -> totalbalance = betamount * 4;
                    case "🍊" -> totalbalance = betamount * 6;
                    case "🍉" -> totalbalance = betamount * 8;
                    case "🥝" -> totalbalance = betamount * 10;
                }
                System.out.println("🙂 You matched two!");
            }
            else {
                System.out.println("❌ You lose this round");
            }

            balance += totalbalance;
            System.out.println("Balance now: $" + balance);

            System.out.print("Try again? (yes/no): ");
            scanner.nextLine(); // clear buffer
            answer = scanner.nextLine();

        } while (answer.equalsIgnoreCase("yes"));

        System.out.println("Thanks for playing!");
        scanner.close();
    }
}
