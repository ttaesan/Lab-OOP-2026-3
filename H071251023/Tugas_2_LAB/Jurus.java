public class Jurus {
    public String nama;
    public int damage;

//    CONSTRUCTOR DEFAULT
    public Jurus() {
        this.nama = "tendangan";
        this.damage = 10;
    }

//    CONSTRUCTOR DENGAN PARAMETER
    public Jurus(String Nama, int Damage) {
        this.nama = Nama;
        this.damage = Damage;
    }
}
