package Soal11;
import java.util.Random;

public class Kurir implements Runnable {
    private Gudang gudang;
    private Random random = new Random();

    public Kurir(Gudang gudang) { this.gudang = gudang; }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                Thread.sleep(2000 + random.nextInt(1001));
                gudang.ambilStok(random.nextInt(3) + 1, Thread.currentThread().getName()); 
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}