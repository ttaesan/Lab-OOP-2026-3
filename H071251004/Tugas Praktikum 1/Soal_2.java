import java.util.Scanner;

public class Soal_2 {
    public static void main(String[] args) {
        String[] namaBulan = {
            "Januari", "Februari", "Maret", "April", "Mei", "Juni",
            "Juli", "Agustus", "September", "Oktober", "November", "Desember"
        };

        Scanner input = new Scanner(System.in);
        System.out.println("Masukkan Tanggal: ");
        String tanggalInput = input.nextLine();
        String[] bagian = tanggalInput.split("-");
        
        int hari = Integer.parseInt(bagian[0]);
        int bulan = Integer.parseInt(bagian[1]);
        String tahun = bagian[2];

        String tahunLengkap;
        if (Integer.parseInt(tahun) <= 26) {
            tahunLengkap = "20" + tahun;
        } else {
            tahunLengkap = "19" + tahun;
        }

        System.out.println(hari + " " + namaBulan[bulan - 1] + " " + tahunLengkap);
        input.close();
    }
}