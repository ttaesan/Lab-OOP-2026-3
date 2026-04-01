import java.util.Scanner;
public class tuprak101 {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        System.out.println("Masukkan Judul Film :");
        String judul = a.nextLine();
        String hasil = capitalize(judul);
        System.out.println(hasil);
    }

    public static String capitalize (String judul){
        String[] kata = judul.toLowerCase().split(" ");
        String hasil = "";

        for (String k : kata) {
            if (k.length()>0) {
                hasil += Character.toUpperCase(k.charAt(0)) + k.substring(1)+ " ";
            }
        }
        return hasil.trim();
    }
    
}
