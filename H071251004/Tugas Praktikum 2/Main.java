public class Main {
    public static void main(String[] args) {
        Person pelanggan = new Person("Sarah", "Pelanggan", "Adidas", 50000);
        Person kasir = new Person("Yuni", "Kasir", null, 0);
        Person cleaner = new Person("Budi", "Cleaner", null, 0);

        int biayaLaundry = 25000;

        System.out.println("=== SHOES CARE ===");
        
        // 1. Pelanggan taruh sepatu ke Kasir
        pelanggan.serahkanSepatu(kasir);

        // 2. Kasir oper ke Cleaner untuk dicuci
        kasir.serahkanSepatu(cleaner);
        cleaner.cuciSepatu();

        // 3. Cleaner balikin ke Kasir setelah bersih
        cleaner.serahkanSepatu(kasir);

        // 4. PROSES BAYAR: Pelanggan bayar ke Kasir
        pelanggan.bayarLaundry(kasir, biayaLaundry);

        // 5. AMBIL SEPATU: Kasir serahkan sepatu bersih ke Pelanggan
        kasir.serahkanSepatu(pelanggan);

        System.out.println("\n=== STATUS AKHIR ===");
        System.out.println(pelanggan.nama + " membawa: sepatu " + pelanggan.item.merk + " (" + pelanggan.item.status + ")");
    }
}