import java.util.Scanner;

public class ATMMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATMSystem atmSystem = new ATMSystem(scanner);
        atmSystem.run();
    }
}
