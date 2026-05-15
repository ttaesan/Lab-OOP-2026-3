package Soal11;
import java.util.Random;

public class Pemasok implements Runnable {
    private Gudang gudang;
    private Random random = new Random();

    public Pemasok(Gudang gudang) { this.gudang = gudang; }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                Thread.sleep(1000 + random.nextInt(1001)); 
                gudang.tambahStok(random.nextInt(5) + 1, Thread.currentThread().getName()); 
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
