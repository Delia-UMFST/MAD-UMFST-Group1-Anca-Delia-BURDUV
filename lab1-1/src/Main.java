import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        int n;
        System.out.print("Introduceti un numar: ");
        String in= s.nextLine();
        try {
            n = Integer.parseInt(in);
            if (n < 0) {
                System.out.println("negativ");
            } else {
                System.out.println("pozitiv");
            }
        } catch (NumberFormatException nfe){
            System.out.println("nu este un numar");
        }
    }
}