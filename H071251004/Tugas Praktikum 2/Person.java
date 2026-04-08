public class Person {
    //Atribut
    public String nama;
    public String tipe; 
    public Sepatu item; 
    public int saldo; 

    //Constructor Default
    public Person() {
        this.nama = "Staff";
        this.tipe = "Helper";
        this.item = null;
        this.saldo = 0;
    }

    //Constructor Parameter
    public Person(String nama, String tipe, String merkSpt, int uang) {
        this.nama = nama;
        this.tipe = tipe;
        this.saldo = uang;
        if (merkSpt != null) {
            this.item = new Sepatu(merkSpt);
        }
    }

    // Behavior (method) untuk serah terima barang
    public void serahkanSepatu(Person penerima) {
        if (this.item != null) {
            System.out.println("\n[SERAH TERIMA] " + this.nama + " (" + this.tipe + ")" + " menyerahkan sepatu ke " + penerima.nama + " (" + penerima.tipe + ")");
            penerima.item = this.item;
            this.item = null; 
        } else {
            System.out.println(this.nama + " tidak memegang sepatu.");
        }
    }

    // Behavior (method) untuk Proses Bayar dan cuci
    public void bayarLaundry(Person kasir, int tagihan) {
        if (this.saldo >= tagihan) {
            this.saldo -= tagihan; // Saldo pelanggan berkurang
            System.out.println("\n[PEMBAYARAN] " + this.nama + " membayar Rp" + tagihan + " ke kasir ");
            System.out.println("Sisa saldo " + this.nama + ": Rp" + this.saldo);
        } else {
            System.out.println("\n[GAGAL] Saldo " + this.nama + " tidak cukup untuk membayar laundry!");
        }
    }

    public void cuciSepatu() {
        if (this.item != null && this.tipe.equals("Cleaner")) {
            System.out.println("[PROSES] " + this.nama + " sedang mencuci sepatu " + this.item.merk + "...");
            this.item.status = "Bersih"; 
            System.out.println(">>> Sepatu sekarang sudah Bersih!");
        }
    }
}