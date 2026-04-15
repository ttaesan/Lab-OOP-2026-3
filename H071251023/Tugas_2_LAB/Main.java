public class Main{
    public static void main(String[] args) {

//        MEMBUAT KARAKTER DENGAN JURUS
        Jurus jurus1 = new Jurus("rasengan", 20);
        Karakter karakter1 = new Karakter ("Naruto", 120, jurus1);

//        MEMBUAT KARAKTER LAWAN DENGAN JURUS DEFAULT ATAU TANPA JURUS
        Jurus jurus2 = new Jurus();
        Karakter karakter2 = new Karakter("Sasuke", 100, jurus2);

//        MENGGANTI JURUS KARAKTER LAWAN
        Jurus jurusganti = new Jurus("chidorin", 25);
        karakter2.gantijurus(jurusganti);

//        INTERAKSI ANTAR KARAKTER
        karakter1.serang(karakter2);

//        HASIL
        System.out.println("Sisa HP " + karakter2.nama + ": " + karakter2.hp);
        System.out.println("Sisa HP " + karakter1.nama + ": " + karakter1.hp);


    }

}

