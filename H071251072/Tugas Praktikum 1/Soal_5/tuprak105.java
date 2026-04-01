import java.util.Scanner;
public class tuprak105 {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        
        int [][] data = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        try {
            System.out.println("Masukkan angka yang ingin dicari ");
            int cari = a.nextInt();

            boolean ditemukan = false;

            for (int i= 0; i< data.length; i++){
                for (int j= 0; j< data[i].length; j++) {

                    if (data[i][j] == cari){
                        System.out.println("Found "+ cari + " at ["+ i + "]["+ j + "]");
                        ditemukan = true;
                        break;
                    }
                }
                if (ditemukan){
                    break;
                }
            }
            if (!ditemukan){
                System.out.println("Angka tidak ditemukan");
            }
        }catch (Exception e){
            System.out.println("Input harus angka !!");
        }
        a.close();
    }
}
