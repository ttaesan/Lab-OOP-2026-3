package Soal22;

import java.util.concurrent.*;
import java.util.*;

public class MainSearchEngine {
    public static void main(String[] args) {
        int jumlahDokumen = 10;
        ExecutorService executor = Executors.newFixedThreadPool(4); 
        CountDownLatch latch = new CountDownLatch(jumlahDokumen); 
        ConcurrentHashMap<String, Integer> results = new ConcurrentHashMap<>(); 
        
        // Untuk laporan akhir klasemen
        List<String> report = Collections.synchronizedList(new ArrayList<>());
        long startTimeGlobal = System.currentTimeMillis();

        DataProcessor processor = new DataProcessor();

        for (int i = 1; i <= jumlahDokumen; i++) {
            String docName = "Dokumen_" + i + ".txt";
            executor.execute(() -> {
                try {
                    long start = System.currentTimeMillis();
                    int wordCount = processor.process(docName);
                    long duration = System.currentTimeMillis() - start;

                    results.put(docName, wordCount);
                    report.add(String.format("%-15s | %-10s | %d ms", docName, Thread.currentThread().getName(), duration)); 
                    
                    System.out.println("[" + Thread.currentThread().getName() + "] Selesai memproses " + docName + " (" + wordCount + " kata)."); 
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    latch.countDown();
                }
            });
        }

        try {
            latch.await(); 
            executor.shutdown();

            System.out.println("\n--- Klasemen Akhir ---"); 
            System.out.println("Nama Dokumen    | Thread     | Durasi");
            report.forEach(System.out::println);

            int totalKata = results.values().stream().mapToInt(Integer::intValue).sum(); 
            long totalWaktu = System.currentTimeMillis() - startTimeGlobal; 
            
            System.out.println("\nTotal Kata Keseluruhan: " + totalKata); 
            System.out.println("Rata-rata Waktu Proses: " + (totalWaktu / jumlahDokumen) + " ms"); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}