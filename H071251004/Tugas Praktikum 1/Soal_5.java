import java.util.Scanner;

public class Soal_5 {
    public static void main(String[] args) {
        int[][] nums = {
            {1, 2, 3}, 
            {4, 5, 6}, 
            {7, 8, 9}};

        Scanner input = new Scanner(System.in);

        try{
            System.out.print("Masukkan bilangan: ");
            int search = input.nextInt();
            boolean found = false;

            for (int i = 0; i< nums.length; i++) {
                for (int j = 0; j < nums[i].length; j++) {
                    if (nums[i][j] == search) {
                        System.out.println("Found " + search + " at [" + i + "][" + j + "]");
                        found = true;
                        break;
                    }
                } 
                if (found) {
                    break;
                }
            }
            if(!found) {
                System.out.println("Angka tidak ada di dalam array.");
            }
        } 
        catch (Exception e) {
            System.out.println("Input tidak valid. Harap masukkan angka bulat!");
        } 
        input.close();
    }
}