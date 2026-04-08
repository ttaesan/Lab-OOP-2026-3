public class Mainmafia {
    public static void main(String[] args) {
        Rolemafia Mafia = new Rolemafia("Mafia", "Villain");
        Rolemafia Det = new Rolemafia("Detective", "Citizen");
        Rolemafia Doc = new Rolemafia("Doctor", "Citizen");
        Rolemafia Vill = new Rolemafia("Villager", "Citizen");

        Playermafia bunga = new Playermafia();
        Playermafia dino = new Playermafia("dino", Mafia);
        Playermafia taehyun = new Playermafia("taehyun", Det);
        Playermafia hoshi = new Playermafia("Hoshi", Doc);
        Playermafia niki = new Playermafia("Ni-ki", Vill);
  
        Playermafia[] listPemain = {bunga,dino, taehyun, hoshi, niki};
        System.out.println("=== MALAM PERTAMA TIBA ===");

        taehyun.performAction(niki);
        hoshi.performAction(taehyun);
        dino.performAction(hoshi);

        System.out.println("\n=== STATUS AKHIR ===");
        for (Playermafia n : listPemain) {
            System.out.println(n.Info());
        }

        for (Playermafia p : listPemain) {
            p.resetProtection();
        }
        System.out.println("\n=== MALAM KEDUA TIBA ===");
        taehyun.performAction(dino);
        hoshi.performAction(taehyun);
        dino.performAction(taehyun);

        System.out.println("\n=== STATUS AKHIR ===");
        for (Playermafia p : listPemain) {
            System.out.println(p.Info());
        }
    }
}