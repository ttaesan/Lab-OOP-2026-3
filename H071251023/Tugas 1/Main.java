import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner yes = new Scanner(System.in);
        
        System.out.println("total belanja :");
        float n = yes.nextInt();
        System.out.println("apakah punya member ya/tidak:");
        String s = yes.next();
        
        if (n >= 1000000 && n < 5000000) {
            n *= 0.97f;
        } else if (n >= 5000000){
            n *= 0.96f;
        }

        if (s.equals("ya")) {
            n*= 0.99f;
            System.out.println("total yang harus dibayar : " + n);
        } else if (s.equals("tidak")) {
            n*= 1.0f;
            System.out.println("total yang harus dibayar : " + n);
        } else {
            System.out.println("input tidak valid");

        }
    }
}