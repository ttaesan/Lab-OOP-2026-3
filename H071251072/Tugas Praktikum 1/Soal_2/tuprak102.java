import java.util.Scanner;
public class tuprak102 {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        System.out.println("Masukkan Tanggal Lahir (dd-mm-yy) :");
        String tanggal= a.nextLine();
        String[] bagian = tanggal.split("-");
        int hari= Integer.parseInt(bagian[0]);
        if (hari<1 || hari > 31){
            System.out.println("Tanggal tidak valid");
        }
        int bulan = Integer.parseInt(bagian[1]);
        if (bulan <0||bulan>12){
            System.out.println("Bulan tidak valid");   
        }
        String mounth = "";
        switch(bulan){
            case 1:
                mounth = "Januari";
                break;
            case 2:
                mounth = "Februari";
                break;
            case 3 :
                mounth = "Maret";
                break;
            case 4 :
                mounth = "April";
                break;
            case 5 :
                mounth = "Mei";
                break;
            case 6 :
                mounth = "Juni";
                break;
            case 7 :
                mounth = "Juli";
                break;
            case 8 :
                mounth = "Agustus";
                break;
            case 9 :
                mounth = "September";
                break;
            case 10 :
                mounth = "Oktober";
                break;
            case 11 :
                mounth = "November";
                break;
            case 12 :
                mounth = "Desember";
                break;
        }
        int tahun = Integer.parseInt(bagian[2]);
        if (tahun>26){
            tahun+=1900;
        }
        else if (tahun <=0){
            System.out.println("Tahun tidak valid");
        }
        else{
            tahun+=2000;
        }
        System.out.println(hari + " "+ mounth + " "+ tahun + " ");
    }
}
