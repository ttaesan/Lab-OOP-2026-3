package Soal11;

public class Gudang {
    private int stok = 0;
    private final int kapasitasMaksimal;

    public Gudang(int kapasitasMaksimal) {
        this.kapasitasMaksimal = kapasitasMaksimal; 
    }

    public synchronized void tambahStok(int jumlah, String threadName) throws InterruptedException {
        while (stok + jumlah > kapasitasMaksimal) { 
            System.out.println(threadName + " menunggu... Gudang Penuh.");
            wait(); 
        }
        stok += jumlah; 
        System.out.println(threadName + " menambah " + jumlah + " barang. Stok saat ini: " + stok);
        notifyAll(); 
    }

    public synchronized void ambilStok(int jumlah, String threadName) throws InterruptedException {
        while (stok < jumlah) { 
            System.out.println(threadName + " menunggu... Stok Kosong.");
            wait(); 
        }
        stok -= jumlah; 
        System.out.println(threadName + " mengambil " + jumlah + " barang. Stok saat ini: " + stok);
        notifyAll(); 
    }

    public int getStok() {
        return stok;
    }

    public int getKapasitasMaksimal() {
        return kapasitasMaksimal;
    }
}