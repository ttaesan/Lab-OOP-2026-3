public class Playermafia {
    String username;
    boolean isNyawa;
    boolean isProteksi;
    Rolemafia role;

    public Playermafia() {
        username = "Unknown";
        isNyawa = true;
        isProteksi = false;
        role = new Rolemafia("Villager", "Citizen");
    }

    public Playermafia(String username, Rolemafia role) {
        this.username = username;
        this.role = role;
        isNyawa = true;
        isProteksi = false;
    }

    public String Username() {
        return username;
    }

    public void performAction(Playermafia target) {
        if (!this.isNyawa) return;
        if (this.role.RoleName().equals("Doctor")) {
            target.isProteksi = true;
            System.out.println("[+] Dokter memberikan perlindungan kepada " + target.username);
        } 
        else if (this.role.RoleName().equals("Detective")) {
            System.out.println("[?] Hasil Penyelidikan: " + target.username + " adalah " + target.role.RoleName());
        } 
        else if (this.role.RoleName().equals("Mafia")) {
            if (!target.isProteksi) {
                target.isNyawa = false;
                System.out.println("[!] Mafia melenyapkan " + target.username);
            } else {
                System.out.println("[!] Mafia gagal! " + target.username + " dilindungi Dokter.");
            }
        }
    }
        
    
    public void resetProtection() {
        this.isProteksi = false;
    }


    public String Info() {
        return "Pemain: " + username + "  Peran: " + role.RoleName() + 
               "  Status: " + (isNyawa ? "Hidup" : "TERELIMINASI");
    }

}