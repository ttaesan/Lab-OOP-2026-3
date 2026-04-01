import java.util.Scanner;
public class tuprak104 {
    public static void main(String[] args) {
    Scanner a = new Scanner(System.in);
    System.out.println("Masukkan angka");
    int bilangan = a.nextInt();
    int faktorial = hitungFaktorial(bilangan);
    System.out.println("Faktorial dari " + bilangan + " adalah: " + faktorial);
    a.close();
  }
    static int hitungFaktorial(int a) {
        if (a <= 1) {
            return 1;
        } else {
            return a * hitungFaktorial(a - 1);
        }
    }
}
