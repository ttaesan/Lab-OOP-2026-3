
import java.util.Scanner;

public class dompet {

    private int PIN;
    private int saldo;
    protected String nama;
    int noRekening;

    public dompet(int PIN, String nama, int noRekening) {
        this.PIN = PIN;
        this.nama = nama;
        this.noRekening = noRekening;
    }

    public void getinfo() {
        System.out.println("Nama =" + this.nama);
        System.out.println("No.Rekening =" + this.noRekening);
        System.out.println("Saldo =" + this.saldo);
    }

    public void setPIN(int PINbaru) {
        Scanner sabri = new Scanner(System.in);
        System.out.print("Masukkan PIN lama:");
        int pinlama = sabri.nextInt();
        Boolean valid = true;
        if (pinlama != this.PIN) {
            valid = false;
            System.out.println("PIN lama tidak valid.");
        }
        String pinbaru = String.valueOf(PINbaru);

        if (pinbaru.length() != 6) {
            valid = false;
            System.out.println("PIN baru harus terdiri dari 6 digit.");
        }
        if (valid) {
            this.PIN = PINbaru;
            System.out.println("PIN berhasil diubah.");
        }
        sabri.close();
    }

    public void setor(int uang) {

        if (uang <= 0) {
            System.out.println("Jumlah uang yang disetor harus lebih besar dari 0.");
            logTransaksi("SETOR", uang, false);
        } else {
            this.saldo += uang;
            System.out.println("Setor berhasil. Saldo saat ini: " + this.saldo);
            logTransaksi("SETOR", uang, true);
        }

    }

    public void tarik(int uang) {
        Scanner sabri = new Scanner(System.in);
        int pinlama = sabri.nextInt();
        System.out.print("Masukkan PIN : ");
        Boolean valid = true;
        if (pinlama != this.PIN) {
            valid = false;
            System.out.println("PIN lama tidak valid.");
        }
        if (uang <= 0 || uang > this.saldo) {
            System.out.println("Jumlah uang yang ditarik tidak valid atau melebihi saldo.");
        }
        if (valid) {
            this.saldo -= uang;
            System.out.println("Tarik berhasil. Saldo saat ini: " + this.saldo);
        }
        logTransaksi("TARIK TUNAI", uang, valid);
        sabri.close();
    }

    private void logTransaksi(String jenis, double jumlah, boolean status) {
        String hasil = status ? "BERHASIL" : "GAGAL";
        System.out.println("[LOG] " + jenis + " " + jumlah + " : " + hasil);
    }

}
