public class Karakter {

//    KELAS DENGAN 3 ATRIBUT
    public String nama;
    public int hp;
    public Jurus jurus;

//    CONSTRUCTOR DEFAULT
    public Karakter(String Nama) {
        this.nama = Nama;
        this.hp = 100;
        this.jurus = new Jurus();
    }

//    CONSTRUCTOR DENGAN PARAMETER
    public Karakter(String Nama, int Hp, Jurus Jurus) {
        this.nama = Nama;
        this.hp = Hp;
        this.jurus = Jurus;
    }

//    BEHAVIOR UNTUK MENGGANTI JURUS
    public void gantijurus(Jurus jurus) {
        this.jurus = jurus;
    }

//    BEHAVIOR INTERAKSI DENGAN KARAKTER LAIN
     public void serang(Karakter musuh) {
        System.out.println(this.nama + " menyerang " + musuh.nama + " dengan jurus " + this.jurus.nama);
        musuh.hp -= this.jurus.damage;
        System.out.println(musuh.nama + " menerima damage sebesar " + this.jurus.damage + ". HP sekarang: " + musuh.hp);
    }
}
