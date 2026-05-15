package Soal22;
import java.util.Random;

public class DataProcessor {
    public int process(String fileName) throws InterruptedException {
        Random random = new Random();
        int processingTime = 500 + random.nextInt(1501); 
        Thread.sleep(processingTime); 
        return 100 + random.nextInt(401); 
    }
}