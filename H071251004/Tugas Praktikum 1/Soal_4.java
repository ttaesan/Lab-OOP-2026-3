import java.util.Scanner;

public class Soal_4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan bilangan: ");
        int n = input.nextInt();
        int hasil = hitungFaktorial(n);
        System.out.println("Faktorial dari " + n + " adalah: " + hasil);
        input.close();
    }

    static int hitungFaktorial(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * hitungFaktorial(n - 1);
        }
    }
}