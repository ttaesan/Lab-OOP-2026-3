package Soal11;

import java.util.concurrent.*;

public class MainGudang {
    public static void main(String[] args) {
        Gudang gudang = new Gudang(20);
        ExecutorService executor = Executors.newFixedThreadPool(5); 

        Thread monitoring = new Thread(() -> {
            try {
                while (true) {
                    int stok = gudang.getStok();
                    int kap = gudang.getKapasitasMaksimal();
                    int persen = (stok * 100) / kap;
                    String bar = "#".repeat(persen / 10) + "-".repeat(10 - (persen / 10));
                    System.out.println("\nStatus Gudang: [" + bar + "] " + persen + "%\n");
                    Thread.sleep(1000); 
                }
            } catch (InterruptedException e) { return; }
        });
        monitoring.setDaemon(true);
        monitoring.start(); 

        // Jalankan Pemasok (2 thread) dan Kurir (3 thread)
        for (int i = 0; i < 2; i++) executor.execute(new Pemasok(gudang)); 
        for (int i = 0; i < 3; i++) executor.execute(new Kurir(gudang)); 

        try {
            Thread.sleep(15000); 
            executor.shutdownNow(); 
            executor.awaitTermination(5, TimeUnit.SECONDS); 
            System.out.println("Sistem Berhenti.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}