import java.util.Scanner;
public class tuprak103 {
    public static void main(String[] args) {
        Scanner a = new Scanner (System.in);
        System.out.println("Masukkan Password");
        String password= a.nextLine();

        boolean adaHurufBesar = false;
        boolean adaHurufKecil = false;
        boolean adaAngka      = false;

        if (password.length() < 8){
            System.out.println("Password harus minimal 8 karakter !!");
            return;
        }

        for (int i= 0; i<password.length(); i++){
            char c = password.charAt(i);
            
            if (Character.isUpperCase(c)){
                adaHurufBesar = true;
            } else if (Character.isLowerCase(c)){
                adaHurufKecil = true;
            } else if (Character.isDigit(c)){
                adaAngka      = true;
            }
        }

        if (adaHurufBesar&&adaHurufKecil&&adaAngka){
            System.out.println("Passoword valid ");
        }
        else {
            System.out.println("Password tidak valid ");
            System.out.println("Password harus menggunakan kombinasi angka,huruf kecil,dan huruf besar");
        }
    }
}
