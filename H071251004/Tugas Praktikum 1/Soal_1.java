import java.util.Scanner;

public class Soal_1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Masukkan Judul Film: ");
        System.out.print(">");
        String kata = input.nextLine();
        String hasil = ubahHuruf(kata);
        System.out.println("> " + hasil);

        input.close();
    }

    public static String ubahHuruf(String kalimat) {
        String hasilAkhir = "";
        String[] kumpulanKata = kalimat.split(" ");
        for (String kata : kumpulanKata) {

            if (!kata.isEmpty()) {
                String hurufDepan = kata.substring(0, 1).toUpperCase();
                String sisaHuruf = kata.substring(1).toLowerCase();
                hasilAkhir = hasilAkhir + hurufDepan + sisaHuruf + " ";
            }
        }
        return hasilAkhir.trim();
    }
}
